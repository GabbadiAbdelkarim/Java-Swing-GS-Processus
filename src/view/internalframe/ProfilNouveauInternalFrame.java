package view.internalframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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
import model.entities.Profil;
import model.entities.Role;
import model.persistence.Persistent;

/***
 * 
 * @author GABBADI
 *
 */
public class ProfilNouveauInternalFrame extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel pProfil,pButtonsNouveau;
	
	private JLabel lbLogin,lbPasswrd,lbEmploye,lblRole;
	
	private JTextField tfLogin,tfPasswrd;
	private JComboBox<Object> cbEmploye;

	private JComboBox<Role> cbRole;
	private JButton btAjouter,btEffacer;
	
	public ProfilNouveauInternalFrame() {
		super("Nouveau profil",true,true,true,true);
		initComponents();
		layoutComponents();
//		MajCombo();
		setController();
	}
	
	private void initChamps() {
		tfLogin.setText("");
		tfPasswrd.setText("");
		cbRole.setSelectedIndex(-1);
		
		MajCombo();
	}
	public void MajCombo(){
		cbEmploye.removeAllItems();
		try {
			for(int i =0; i< Persistent.getComboEmploye().size();i++){
				cbEmploye.addItem(Persistent.getComboEmploye().get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		setSize(500,200);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		pProfil=new JPanel();
		pProfil.setBorder(BorderFactory.createTitledBorder("Informations"));
		pButtonsNouveau=new JPanel();
		
		/********idp**************/
		lbEmploye=new JLabel("Employé");
		cbEmploye=new JComboBox();
//		MajCombo();

		/********Login**************/
		lbLogin=new JLabel("Login");
		tfLogin=new JTextField(5);
		tfLogin.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********Password**************/
		lbPasswrd=new JLabel("Password");
		tfPasswrd=new JTextField(5);
		tfPasswrd.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********role**************/
		lblRole=new JLabel("Rôle");
		Vector v = new Vector();
		v.addElement(Role.Admin);
		v.addElement(Role.Responsable);
		v.addElement(Role.Employe);
		cbRole=new JComboBox(v);
		
		/********boutons**************/
		btAjouter =new JButton("Ajouter");
		btEffacer =new JButton("Effacer");
		
	}
	
	private void layoutComponents() {
		add(pProfil);
		pProfil.setLayout(new GridLayout(0,2,5,5));
		pProfil.add(lbLogin);pProfil.add(tfLogin);
		pProfil.add(lbPasswrd);pProfil.add(tfPasswrd);
		pProfil.add(lbEmploye);pProfil.add(cbEmploye);
		pProfil.add(lblRole);pProfil.add(cbRole);
		add(pButtonsNouveau,BorderLayout.SOUTH);
		pButtonsNouveau.add(btAjouter);
		pButtonsNouveau.add(btEffacer);
	}
	
	private void setController() {
		btAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MajCombo();
				if(tfLogin.getText().equals("")
						|| tfPasswrd.getText().equals("") || cbEmploye.equals("") || cbRole.equals("")){
					JOptionPane.showConfirmDialog(btAjouter, "Veuillez remplir tous les champs");
				}else {
				try {	
					Profil prfl = new Profil();
					prfl.setLogin(tfLogin.getText());
					prfl.setMot_de_passe(tfPasswrd.getText());
					String[] parts = cbEmploye.getSelectedItem().toString().split(" ", 2);
					String part1 = parts[0];
					prfl.setIdEmploye(Integer.parseInt(part1));
					prfl.setRole((Role)cbRole.getSelectedItem());
						if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btAjouter, "Voulez vraiment ajouter l'Profil ?")){
							Controller.Profilmodel.add(prfl,Integer.parseInt(part1));
							JOptionPane.showMessageDialog(btAjouter,"Profil ajouté avec succès");
							initChamps();
						}
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(btAjouter,"Echec ajout du Profil");
					}
			}}
		});
		btEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initChamps();
				
			}
		});
	}
}
