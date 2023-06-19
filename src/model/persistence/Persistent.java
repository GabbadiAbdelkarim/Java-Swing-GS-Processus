package model.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import controller.Controller;
import model.EmployeModel;
import model.ProfilModel;
import model.entities.Employe;
import model.entities.Message;
import model.entities.Profil;
import model.entities.Role;
import model.entities.Sexe;
import view.frame.AuthentificationFrame;
import view.menubar.GProcessAppMenuBarAdmin;
import view.menubar.GProcessAppMenuBarPilote;
import view.menubar.GProcessAppMenuBarResponsable;

public class Persistent {
	
	private static String database="gestionprocessus";
	private static String server="localhost";
	private static int port=3306;

	private static Connection con;
	
	public static void seConnecter(String user,String password) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database,user,password);
			getListMessage();
	}
	
	public static void seDeconnecter() throws Exception {
		 		if(con!=null)con.close();
	}
	
	public static  boolean isConnected() throws Exception{
		return con!=null && !con.isClosed();
	}

	public static Connection getCon() {
		return con;
	}
	
	/**********************  PROFIL *******************************/
	public static void addProfil(Profil p, int emp) {
		try {
			PreparedStatement PS = con.prepareStatement
					("insert into profil(login,passwrd,	id_employe,role) values (?,?,?,?)");
			PS.setString(1, p.getLogin());
			PS.setString(2, p.getMot_de_passe());
			PS.setInt(3, p.getIdEmploye());
			PS.setString(4,p.getRole().toString());
			PS.executeUpdate();
			PS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Profil> getListProfil() throws Exception{
		List<Profil> l=new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery
				("SELECT login,passwrd,id_employe,role FROM Profil");
		while(rs.next()){
			Profil prfl = new Profil();
			prfl.setLogin(rs.getString(1));
			prfl.setMot_de_passe(rs.getString(2));
			prfl.setIdEmploye(rs.getInt(3));
			prfl.setRole(Role.valueOf(rs.getString(4)));
			l.add(prfl);
		}
		st.close();
		return l;
	}
	
	public static void deleteProfil(Profil prfl) throws Exception {
		Statement st;
		st =con.createStatement();
		st.executeUpdate("delete from profil where id_employe="+prfl.getIdEmploye());
		st.close();	
	}
	public static void updateProfil(Profil prfl) throws Exception {
		PreparedStatement st=con.prepareStatement("update Profil set login=?, passwrd=?,role=? where id_employe=?");
		st.setString(1,prfl.getLogin());
		st.setString(2,prfl.getMot_de_passe());
		st.setString(3,prfl.getRole().toString());
		st.setInt(4,prfl.getIdEmploye());
		st.executeUpdate();
		st.close();
	}
	public static String getEmployeByProfil() throws Exception{
	
		String Emp = Controller.Profilmodel.setModelFromFile(System.getProperty("user.dir")+"/datafiles/abcd.sdata");
		Emp=Emp.substring(0, Emp.length()-2);
		String val[] = Emp.split(",");
		Emp=val[3].substring(11);
		int idEmpl = Integer.parseInt(Emp);
		String NomEmploye=null;

		Statement stat;
		stat= con.createStatement();
		ResultSet rs = stat.executeQuery ("select Nom from employe where Id_Employe='"+idEmpl+"'");
		while(rs.next()){
			NomEmploye = rs.getString(1);
		}
		stat.close();
		String Employe = idEmpl+" "+NomEmploye;
		return Employe;
	}
	public static List<Profil> authentificationProfil(String Login,String Passwd) throws Exception{
		List<Profil> pr = new ArrayList<>();
		Statement st=con.createStatement();
		try {
            ResultSet rs = st.executeQuery
         		   ("SELECT * FROM PROFIL where login = '"+Login+"' and passwrd = '"+Passwd+"'");
            		while(rs.next()){
            			Profil prf = new Profil();
            			prf.setId_profile(rs.getInt(1));
            			prf.setIdEmploye(rs.getInt(4));
            			prf.setRole(Role.valueOf(rs.getString(5)));
            			pr.add(prf);
            		}
            		st.close();

     } catch (Exception e) {
			e.printStackTrace();
		}
		
		return pr;
	}

	/**********************  EMPLOYE *******************************/
	public static void addEmploye(Employe e) {
		try {
			PreparedStatement st=con.prepareStatement
					("insert into Employe(`Id_Employe`, `Nom`, `Prenom`, `Cin`, `Date_Naissance`, `sexe`, `adresse`, `email`, `telephone`, `Date_Recrutement`) values(null,?,?,?,?,?,?,?,?,?)");
			st.setString(1,e.getNom());
			st.setString(2,e.getPrénom());
			st.setString(3,e.getCin());
			st.setObject(4,e.getDate_Naissance());
			st.setObject(5,e.getSexe().toString());
			st.setString(6,e.getAdresse());
			st.setString(7,e.getEmail());
			st.setString(8,e.getTelephone());
			st.setObject(9,e.getDate_Recrutement());
			//st.setInt(11,idProfil);
			
			st.executeUpdate();
			st.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			PreparedStatement st=con.prepareStatement
					("INSERT INTO `archive_employe`(`id_Archive`, `Cin`, `nombreAnnee`, `date_Changement`, `Role`) values(null,?,?,?,?,?)");
			st.setString(1,e.getCin());
			st.setObject(3,e.getDate_Recrutement());

			st.executeUpdate();
			st.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static List<Employe> getListEmploye() throws Exception{
		List<Employe> l=new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery
				("SELECT Id_Employe,Nom,Prenom,Cin,Date_Naissance,sexe,adresse,email,telephone,Date_Recrutement FROM employe");
		while(rs.next()){
			Employe emp = new Employe();
			emp.setId_Employe(rs.getInt(1));
			emp.setNom(rs.getString(2));
			emp.setPrénom(rs.getString(3));
			emp.setCin(rs.getString(4));
			emp.setDate_Naissance(rs.getDate(5));
			emp.setSexe(Sexe.valueOf(rs.getString(6)));
			emp.setAdresse(rs.getString(7));
			emp.setEmail(rs.getString(8));
			emp.setTelephone(rs.getString(9));
			emp.setDate_Recrutement(rs.getDate(10));
			l.add(emp);
		}
		st.close();
		return l;
	}
	public static List<Object> getComboEmploye() throws Exception{
		List<Object> p= new ArrayList<Object>();
		if(Persistent.isConnected()){
				p=EmployeModel.getAllEmployeIDName();
				for(int i =0; i< p.size();i++){
					p.get(i);
					
				}
			}else{
				System.err.println("***go Persistent");
			}
		return p;
	}
	public List<Employe> getEmployeByProfil(int idProfil) {
		List<Employe> employes = new ArrayList<Employe>();
		try{
			PreparedStatement PS = con.prepareStatement
					("select * from employe where id_profil = ?");
			PS.setInt(1, idProfil);
			ResultSet rs = PS.executeQuery();
			while(rs.next()){
				Employe e = new Employe();
				e.setId_Employe(rs.getInt("Id_Employe"));
				e.setNom(rs.getString("Nom"));
				e.setPrénom(rs.getString("Prenom"));
				e.setCin(rs.getString("CIN"));
				e.setDate_Naissance(rs.getDate("Date_Naissance"));
				e.setSexe(Sexe.valueOf(rs.getString("sexe")));
				e.setAdresse(rs.getString("adresse"));
				e.setEmail(rs.getString("email"));
				e.setTelephone(rs.getString("telephone"));
				e.setDate_Recrutement(rs.getDate("Date_Recrutement"));
				
				employes.add(e);
			}
			PS.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return employes;
	}
	public static String getEmployeByID(int id) {
		String Empl=null;
		try{
			PreparedStatement PS = con.prepareStatement
					("select Nom from employe where id_Employe = ?");
			PS.setInt(1, id);
			ResultSet rs = PS.executeQuery();
			while(rs.next()){
				Empl = rs.getString(1);
			}
			PS.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return Empl;
	}
	

	public static void deleteEmploye(Employe emp) throws Exception {
		Statement st=con.createStatement();
		st.executeUpdate("delete from employe where Id_Employe="+emp.getId_Employe());
		
		st.close();	
	}
	

	
	public static void updateEmploye(Employe emp) throws Exception {
		PreparedStatement st=con.prepareStatement("update Employe set Nom=?, Prenom=?,Cin=?,Date_Naissance=?,sexe=?,"
				+ "adresse=?,email=?,telephone=?,Date_Recrutement=? where Id_Employe=?");
		st.setString(1,emp.getNom());
		st.setString(2,emp.getPrénom());
		st.setString(3,emp.getCin());
		st.setObject(4,emp.getDate_Naissance());
		st.setObject(5,emp.getSexe().toString());
		st.setString(6,emp.getAdresse());
		st.setString(7,emp.getEmail());
		st.setString(8,emp.getTelephone());
		st.setObject(9,emp.getDate_Recrutement());
		st.setInt(10,emp.getId_Employe());
		st.executeUpdate();
		st.close();
	}

	/**********************  MESSAGE *******************************/
	public static void addMessage(Message m, int emp) {
		try {
			PreparedStatement PS = con.prepareStatement
					("insert into message(id_employe_Emet,id_employe_desti,text) values (?,?,?)");
			PS.setInt(1, emp);
			PS.setInt(2, m.getId_employe_desti());
			PS.setString(3, m.getText());
			PS.executeUpdate();
			PS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Message> getListMessage() throws Exception{
		List<Message> al = new ArrayList<>();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery
				("SELECT id_employe_Emet,id_employe_desti,date_envoie,text FROM message");
		while ( rs.next() ) { 
			Message msg = new Message();
            msg.setId_employe_Emet(rs.getInt(1));
            msg.setId_employe_desti(rs.getInt(2));
            msg.setDate_envoie(rs.getDate(3));
            msg.setText(rs.getString(4));
            al.add(msg);
        } 
		st.close();
		return al;
	}
	
	/*******************************Statistiques*****************/
	/*
	public static void get(){
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM employe ");
        RowEmploye = new DefaultTableModel();
        String[] names = {"Id employé", "Nom", "Prenom", "CIN", "Date de recrutement", "Date de naissance"};
        RowEmploye.setColumnIdentifiers(names);
        while (rs.next())
        {
            Object[] objects = new Object[6];
            objects[0] = rs.getInt(1);
            objects[1] = rs.getString(3);
            objects[2] = rs.getString(4);
            objects[3] = rs.getString(5);
            objects[4] = rs.getString(6);
            objects[5] = rs.getString(7);
            RowEmploye.addRow(objects);
        }
        ListeProc.setModel(RowEmploye);
        ListeProc.repaint();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}*/
}
