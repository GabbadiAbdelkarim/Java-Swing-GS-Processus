package model;
import java.util.*;

import model.entities.Employe;
import model.entities.Message;
import model.entities.Profil;
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
public class MessageModel extends DefaultTableModel{
	
	private List<Message> messsages=new ArrayList<Message>();
	private String[] entetes={"De","À","Date","Message"};
	public MessageModel(){}
	

	/************************Mise à jour******************************/
	public void add(Message msg, int emp) throws Exception{
		if(Persistent.isConnected())
			Persistent.addMessage(msg,emp);//apres l'ajout du message a un id 
		else{
			//affecter un id au message
			int id=1;
			if(messsages.size()!=0)
			id=Collections.max(messsages,new Comparator<Message>() {
				public int compare(Message o1, Message o2) {
					return o1.getId_message()-o2.getId_message();
				}
			}).getId_message()+1;
			msg.setId_message(id);
		}
		messsages.add(msg);
		fireTableDataChanged();
	}
	
	public String getEmployeById(int id) throws Exception{
		String Employe = null;
		if(Persistent.isConnected())
			Employe = Persistent.getEmployeByID(id);
		else{
			System.err.println("Error mule");
		}
		
		return Employe;
		
	}
	
	public Message getMessage(int i){
		return messsages.get(i);
	}
	
	/***********************base de données****************************/
	public int setModelFromDB() throws Exception{
		if(Persistent.isConnected())
			messsages=Persistent.getListMessage();
		fireTableDataChanged();
		return messsages.size();
	}
	
	/*************************TableModel************************************/
	public int getColumnCount(){
		return entetes.length;
	}
	
	public String getColumnName(int i){
		return entetes[i];
	}
	
	public int getRowCount(){
		if(messsages==null)
			return 0;
		return messsages.size();
	}
	
	public Object getValueAt(int i,int j){
		try{
			Message s = messsages.get(i);
			switch(j){
				case 0 : return getEmployeById(s.getId_employe_Emet());
				case 1 : return getEmployeById(s.getId_employe_desti());
				case 2 : return s.getDate_envoie();
				case 3 : return s.getText();
				default : return null;
			}
		}catch(Exception e){return null;}
	}

	
}



