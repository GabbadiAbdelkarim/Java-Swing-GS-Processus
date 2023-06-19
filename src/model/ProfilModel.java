package model;
import java.util.*;

import model.entities.Employe;
import model.entities.Profil;
import model.entities.Role;
import model.entities.Sexe;
import model.persistence.Persistent;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TreeModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;


/***
 * 
 * @author GABBADI
 *
 */
public class ProfilModel extends DefaultTableModel{
	
	private static List<Profil> profils=new ArrayList<Profil>();
	private String[] entetes={"Login","Password","Rôle","Employé"};
	
	public ProfilModel(){}
	
	/************************Mise à jour******************************/
	public void add(Profil prfl, int emp) throws Exception{
		if(Persistent.isConnected())
			Persistent.addProfil(prfl,emp);//apres l'ajout le Profil a un id 
		else{
			//affecter un id au Profil
			int id=1;
			if(profils.size()!=0)
			id=Collections.max(profils,new Comparator<Profil>() {
				public int compare(Profil o1, Profil o2) {
					return o1.getId_profile()-o2.getId_profile();
				}
			}).getId_profile()+1;
		
			prfl.setId_profile(id);
		}
		
		profils.add(prfl);
		fireTableDataChanged();
	}
	
	
	
	public void delete(Profil prfl) throws Exception{
		if(Persistent.isConnected())
			Persistent.deleteProfil(prfl);
		profils.remove(prfl);
		fireTableDataChanged();
		
	}
	
	public void update(Profil prfl) throws Exception{
		if(Persistent.isConnected())
			Persistent.updateProfil(prfl);
		
		//profils.set(profils.indexOf(prfl), prfl);
		fireTableDataChanged();
		
	}
	
	public Profil getProfil(int i){
		return profils.get(i);
	}
	public String getIdProfil(String Log, String Pass) throws Exception{
		String id=null;
		String[] parts;
		List<Profil> prl = new ArrayList<>();
		if(Persistent.isConnected())
			prl = Persistent.authentificationProfil(Log,Pass);
			id = prl.toString();
			parts = id.split(",");
			id=parts[0].substring(20);
		return id;
	}
	public String getRoleProfil(String Log, String Pass) throws Exception{
		String role=null;
		String[] parts;
		List<Profil> prl = new ArrayList<>();
		if(Persistent.isConnected())
			prl = Persistent.authentificationProfil(Log,Pass);
			role = prl.toString();
			parts = role.split(",");
			role=parts[4].substring(6,parts[4].length()-2);
		return role;
	}
	public String getEmpProfil(String Log, String Pass) throws Exception{
		String Emp=null;
		String[] parts;
		List<Profil> prl = new ArrayList<>();
		if(Persistent.isConnected())
			prl = Persistent.authentificationProfil(Log,Pass);
			Emp = prl.toString();
			parts = Emp.split(",");
			Emp=parts[3].substring(11);
		return Emp;
	}
	/***********************base de données****************************/
	public int setModelFromDB() throws Exception{
		if(Persistent.isConnected())
			profils=Persistent.getListProfil();
		fireTableDataChanged();
		return profils.size();
	}
	

	 
	/************************Fichiers**********************************/
	public String setModelFromFile(String nomFichier) throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
		String ligne = null;
		profils=new ArrayList<>();
		int n=0;
		while((ligne = reader.readLine())!=null){
			String[] l = ligne.split(";");
			Profil s = new Profil();
			s.setId_profile(Integer.parseInt(l[0]));
			s.setLogin(l[1]);
			s.setMot_de_passe(l[2]);
			s.setRole(Role.valueOf(l[4]));
			s.setIdEmploye(Integer.parseInt(l[3]));
			if(!profils.contains(s)){
				profils.add(s);
				n++;
			}
		}
		reader.close();
		fireTableDataChanged();
		return profils.toString();
	}
//119;Admin;admin;1119;Admin
	public static void saveModelInFile(String nomFichier,String idProfil,String log, String pass, String id_employe,String role) throws Exception {
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
		writer.write(idProfil+";"+log+";"+pass+";"+id_employe+";"+role+";");
//		for(Profil s : profils ){
//			System.out.println(s.getId_profile()+";"+s.getLogin()+";"+s.getMot_de_passe()+";"+s.getIdEmploye()+";"+s.getRole()+";");
//			writer.println(s.getId_profile()+";"+s.getLogin()+";"+s.getMot_de_passe()+";"+s.getIdEmploye()+";"+s.getRole()+";");
//		}
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
		if(profils==null)
			return 0;
		return profils.size();
	}
	
	public Object getValueAt(int i,int j){
		try{
			Profil s = profils.get(i);
			switch(j){
				case 0 : return s.getLogin();
				case 1 : return s.getMot_de_passe();
				case 2 : return s.getRole();
				case 3 : return s.getIdEmploye();
				default : return null;
			}
		
		}catch(Exception e){return null;}
	}

	
}



