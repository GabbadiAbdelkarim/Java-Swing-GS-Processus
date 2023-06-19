package view.internalframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.Controller;
import model.EmployeModel;
import model.ProfilModel;
import model.entities.Employe;
import model.entities.Message;
import model.entities.Profil;
import model.entities.Role;
import model.persistence.Persistent;

/***
 * 
 * @author GABBADI
 *
 */
public class MessageNouveauInternalFrame extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel pMessage,pButtonsNouveau;
	
	private JLabel lbMessage,lbDestinaire,lbEmeteur;
	
	private JTextField tfEmeteur;
	private JTextArea tfMessage;
	private JComboBox<Object> cbEmploye;
	private JScrollPane scroll;
	private JButton btAjouter,btEffacer;
	
	public MessageNouveauInternalFrame() {
		super("Nouveau message",true,true,true,true);
			initComponents();
			layoutComponents();
			setController();
		
	}
	
	private void initComponents() {
		setSize(500,200);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		pMessage=new JPanel();
		pMessage.setBorder(BorderFactory.createTitledBorder("Informations"));
		pButtonsNouveau=new JPanel();
		/********Emmeteur**************/
		lbEmeteur=new JLabel("De :");
		tfEmeteur=new JTextField(5);
		tfEmeteur.setEditable(false);
		try {
			tfEmeteur.setText(Persistent.getEmployeByProfil());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/********Destinataire**************/
		lbDestinaire=new JLabel("À : ");
		cbEmploye=new JComboBox();
		cbEmploye.removeAllItems();
		try {
			for(int i =0; i< EmployeModel.getAllEmployeName().size();i++){
				cbEmploye.addItem(EmployeModel.getAllEmployeName().get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/********Message**************/
		lbMessage=new JLabel("Message :");
		tfMessage=new JTextArea(8,20);
		tfMessage.setLineWrap(true);
		scroll=new JScrollPane(tfMessage);
		
		
		/********boutons**************/
		btAjouter =new JButton("Ajouter");
		btEffacer =new JButton("Effacer");
		
	}
	
	private void layoutComponents() {
		add(pMessage);
		pMessage.setLayout(new GridLayout(0,2,5,5));
		pMessage.add(lbEmeteur);pMessage.add(tfEmeteur);
		pMessage.add(lbDestinaire);pMessage.add(cbEmploye);
		pMessage.add(lbMessage);pMessage.add(scroll);
		add(pButtonsNouveau,BorderLayout.SOUTH);
		pButtonsNouveau.add(btAjouter);
		pButtonsNouveau.add(btEffacer);
	}
	
	private void setController() {
		btAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idEm=Integer.parseInt(tfEmeteur.getText().substring(0, 4));
				int idEd=Integer.parseInt(cbEmploye.getSelectedItem().toString().substring(0,4));
				try {	
					Message msg = new Message();
					msg.setId_employe_Emet(idEm);
					msg.setId_employe_desti(idEd);
					msg.setText(tfMessage.getText());
						if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btAjouter, "Voulez vraiment envoyer le message ?")){
							Controller.Messagemodel.add(msg,idEm);
							JOptionPane.showMessageDialog(btAjouter,"Message envoyé !");
						}
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(btAjouter,"Echec ajout du Profil");
					}
				
			}
		});
		btEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfMessage.setText("");
				cbEmploye.setSelectedIndex(-1);
				
			}
		});
	}
}
