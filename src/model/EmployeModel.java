package model;
import java.util.*;

import model.entities.Employe;
import model.entities.Profil;
import model.entities.Sexe;
import model.persistence.Persistent;
import view.internalframe.EmployeNouveauInternalFrame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

/***
 * 
 * @author GABBADI
 *
 */
public class EmployeModel extends DefaultTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<Employe> Employes=new ArrayList<Employe>();
	//private List<Profil> profils = new ArrayList<Profil>();
	private String[] entetes={"ID","Nom","Prenom","	CIN","Date de Naissance","sexe","adresse","email","téléphone","Date de Recrutement"};
	public SimpleDateFormat dateNaissFormat= new SimpleDateFormat("dd/MM/yyyy");
	
	
	public EmployeModel(){}
	
	/************************Mise à jour******************************/
	public void add(Employe emp) throws Exception{
		if(Persistent.isConnected()){
			Persistent.addEmploye(emp);
		}
		else{
			//affecter un id
			int id=1;
			if(Employes.size()!=0)
			id=Collections.max(Employes,new Comparator<Employe>() {
				public int compare(Employe o1, Employe o2) {
					return o1.getId_Employe()-o2.getId_Employe();
				}
			}).getId_Employe()+1;
		
			emp.setId_Employe(id);
		}
		
		Employes.add(emp);
		fireTableDataChanged();
	}
	
	public void delete(Employe emp) throws Exception{
		if(Persistent.isConnected())
			Persistent.deleteEmploye(emp);
		Employes.remove(emp);
		fireTableDataChanged();
		
	}
	
	public void update(Employe emp) throws Exception{
		if(Persistent.isConnected())
			Persistent.updateEmploye(emp);
		//Employes.set(Employes.indexOf(emp), emp);
		fireTableDataChanged();
	}
	/*
	public List<Employe> getEmployeByType(int id){
		return profils.get(id);
	}*/
	public Employe getEmploye(int i){
		return Employes.get(i);
	}
	public Employe getEmployeCo(int i){
		return Employes.get(i);
	}
	public static List<Object> getAllEmployeID() {
		List<Object> cats = new ArrayList<Object>();
		try{
			if(Persistent.isConnected()){
				Connection con = Persistent.getCon();
			PreparedStatement PS = con.prepareStatement	("select * from employe");			
			ResultSet rs = PS.executeQuery();
			while(rs.next()){
				cats.add(rs.getInt("Id_Employe"));
				}
			PS.close();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return cats;
	}
	
	public static List<Object> getAllEmployeIDName() {
		List<Object> cats = new ArrayList<Object>();
		int id;
		String nom;
		String Prenom;
		try{
			if(Persistent.isConnected()){
				Connection con = Persistent.getCon();
			PreparedStatement PS = con.prepareStatement	("select Id_Employe,Nom,Prenom from employe where Id_Employe not in (select id_employe from profil)");			
			ResultSet rs = PS.executeQuery();
			while(rs.next()){
				id = rs.getInt("Id_Employe"); // Get the Id
	            nom = rs.getString("Nom"); // Get the LastName
	            Prenom = rs.getString("Prenom"); // Get the FirstName
	            Employe emp = new Employe(id, nom, Prenom); // Create a new emp
	            String [] sp =emp.toString().split("-",2);
	            String sp1 = sp[0];
	            //System.err.println(sp1);
	            cats.add(sp1); // Put it into the ComboBox
				}
			PS.close();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return cats;
	}
	public static List<Object> getAllEmployeName() {
		List<Object> cats = new ArrayList<Object>();
		int id;
		String nom;
		String Prenom;
		try{
			if(Persistent.isConnected()){
				Connection con = Persistent.getCon();
			PreparedStatement PS = con.prepareStatement	("select Id_Employe,Nom,Prenom from employe");			
			ResultSet rs = PS.executeQuery();
			while(rs.next()){
				id = rs.getInt("Id_Employe"); // Get the Id
	            nom = rs.getString("Nom"); // Get the LastName
	            Prenom = rs.getString("Prenom"); // Get the FirstName
	            Employe emp = new Employe(id, nom, Prenom); // Create a new emp
	            String [] sp =emp.toString().split("-",2);
	            String sp1 = sp[0];
	            //System.err.println(sp1);
	            cats.add(sp1); // Put it into the ComboBox
				}
			PS.close();
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return cats;
	}
	/***********************base de données****************************/
	public int setModelFromDB() throws Exception{
		if(Persistent.isConnected())
			Employes=Persistent.getListEmploye();
		fireTableDataChanged();
		return Employes.size();
	}
	
	public void seConnecter(String user, String password) throws Exception {
		Persistent.seConnecter(user, password);
	}

	public void seDeconnecter() throws Exception {
		Persistent.seDeconnecter();
	}
	 
	/************************Fichiers**********************************/
	public int setModelFromFile(String nomFichier) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
		String ligne = null;
		Employes=new ArrayList<>();
		int n=0;
		while((ligne = reader.readLine())!=null){
			String[] l = ligne.split(";");
			Employe s = new Employe();
			s.setId_Employe(Integer.parseInt(l[0]));
			s.setNom(l[1]);
			s.setPrénom(l[2]);
			s.setCin(l[3]);
			s.setDate_Recrutement(dateNaissFormat.parse(l[4]));
			s.setDate_Naissance(dateNaissFormat.parse(l[5]));
			s.setSexe(Sexe.valueOf(l[6]));
			s.setAdresse(l[7]);
			if(!Employes.contains(s)){
				Employes.add(s);
				n++;
			}
		}
		reader.close();
		fireTableDataChanged();
		return n;
	}

	public void saveModelInFile(String nomFichier) throws Exception {
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
		for(Employe s : Employes ){
			//String Profils=Arrays.toString(s.getProfile()..replaceAll(" ","");
			writer.println(s.getId_Employe()+";"+s.getNom()+";"+s.getPrénom()+";"+s.getSexe()+";"+dateNaissFormat.format(s.getDate_Recrutement())+";"+dateNaissFormat.format(s.getDate_Naissance())+";"+s.getAdresse()+";");
		}
		writer.close();
	}
	/*************************TableModel************************************/
	public int getColumnCount(){
		return entetes.length;
	}
	
	public String getColumnName(int i){
		return entetes[i];
	}
	
	public int getRowCount(){
		if(Employes==null)
			return 0;
		return Employes.size();
	}
	
	public Object getValueAt(int i,int j){
		try{
			Employe e = Employes.get(i);
			switch(j){
				case 0 : return e.getId_Employe();
				case 1 : return e.getNom();
				case 2 : return e.getPrénom();
				case 3 : return e.getCin();
				case 4 : return dateNaissFormat.format(e.getDate_Naissance());
				case 5 : return e.getSexe();
				case 6 : return e.getAdresse();
				case 7 : return e.getEmail();
				case 8 : return e.getTelephone();
				case 9 : return dateNaissFormat.format(e.getDate_Recrutement());
				default : return null;
			}
		}catch(Exception e){return null;}
	}
}
