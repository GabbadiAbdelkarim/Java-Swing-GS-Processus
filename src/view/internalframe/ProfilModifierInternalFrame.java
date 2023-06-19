package view.internalframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.Controller;
import model.EmployeModel;
import model.entities.Profil;
import model.entities.Profil;
import model.entities.Role;
import model.entities.Sexe;
import model.persistence.Persistent;


/***
 * 
 * @author GABBADI
 *
 */
public class ProfilModifierInternalFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pProfil,pButtonsNouveau;
	private JLabel lbLogin,lbPasswd,lbRole;
	
	private JTextField tfLogin,tfPasswd;
	private JComboBox<Role> cbRole;
	private JButton btSaveUpdate,btAnnuler;
	
	private Profil p;
	
	
	public ProfilModifierInternalFrame() {
		super("Modification de profil",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	public void setProfil(Profil p){
		this.p=p;
		initValues();
	}
	
	private void initComponents() {
		setSize(500,300);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		pProfil=new JPanel();
		pButtonsNouveau=new JPanel();
		/********Login**************/
		lbLogin=new JLabel("Nom");
		tfLogin=new JTextField(5);
		tfLogin.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********PAsswd**************/
		lbPasswd=new JLabel("Prénom");
		tfPasswd=new JTextField(5);
		tfPasswd.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********role**************/
		lbRole=new JLabel("Rôle");
		Vector v = new Vector();
		v.addElement(Role.Admin);
		v.addElement(Role.Responsable);
		v.addElement(Role.Employe);
		cbRole=new JComboBox(v);
		
		/********boutons**************/
		btSaveUpdate=new JButton("Enregistrer");
		btAnnuler =new JButton("Annuler");
	
			
	}
	private void layoutComponents() {
		add(pProfil);
		pProfil.setLayout(new GridLayout(0,2,5,5));
		pProfil.add(lbLogin);pProfil.add(tfLogin);
		pProfil.add(lbPasswd);pProfil.add(tfPasswd);
		pProfil.add(lbRole);pProfil.add(cbRole);
		add(pButtonsNouveau,BorderLayout.SOUTH);
		pButtonsNouveau.add(btSaveUpdate);
		pButtonsNouveau.add(btAnnuler);
	}
	private void setController() {
		btSaveUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Profil prf = new Profil();
					prf.setId_profile(p.getId_profile());
					prf.setLogin(tfLogin.getText());
					prf.setMot_de_passe(tfPasswd.getText());
					prf.setRole((Role)cbRole.getSelectedItem());
					prf.setIdEmploye(p.getIdEmploye());
					if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btSaveUpdate, "Voulez vous vraiment modifier le profil ?\n")){
						Controller.Profilmodel.update(prf);
						JOptionPane.showMessageDialog(btSaveUpdate,"Profil modifié avec succès");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(btSaveUpdate,"Echec modification du profil");
				}			
			}
		});
		btAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initValues();
			}
		});
	}
	
	private void initValues(){
		tfLogin.setText(p.getLogin());
		tfPasswd.setText(p.getMot_de_passe());
		cbRole.setSelectedItem(p.getRole());
		
		}
		
}