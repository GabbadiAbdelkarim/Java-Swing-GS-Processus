package view.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import controller.Controller;
import model.EmployeModel;
import model.entities.Employe;
import model.entities.Profil;
import model.entities.Sexe;
import model.persistence.Persistent;
import view.desktoppane.GSAppDesktopPane;
import view.frame.frame3.GestionProcessusG3;
import view.menubar.GProcessAppMenuBarAdmin;
import view.menubar.GProcessAppMenuBarPilote;
import view.menubar.GProcessAppMenuBarResponsable;
import view.toolbar.GProcessAppToolBar;



/***
 * 
 * @author GABBADI
 *
 */
public class AuthentificationFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JMenuBar jmb;
	private JPanel pAuthentification,pConnexion;
	private JButton btConnecter,btEffacer;
	private JLabel lbLogin, lbPassword,jLabel6;
	private JTextField tfLogin;
	private JScrollPane jScrollPane1;
	private JTextArea Information;
	private JPasswordField pfPasswd;
	
	
	public AuthentificationFrame() throws Exception{
		
		initComponents();
		layoutComponents();
		setController();
		setVisible(true);
		
	}
	private void clear() throws Exception{
		tfLogin.setText("");
		pfPasswd.setText("");
	}
	private void initComponents() throws Exception {
		Persistent.seConnecter("root", "");
		setTitle("Authentification");
		setSize(250,150);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("images\\icon.jpg").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pAuthentification=new JPanel();
		pAuthentification.setBackground(new java.awt.Color(153, 255, 153));
		pConnexion = new JPanel();
		pConnexion.setBackground(new java.awt.Color(153, 255, 153));
		
		/********Login**************/
		lbLogin=new JLabel("Login :");
		tfLogin=new JTextField(5);
		tfLogin.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********prenom**************/
		lbPassword=new JLabel("Password :");
		pfPasswd=new JPasswordField(5);
		pfPasswd.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		
		/********boutons**************/
		btConnecter =new JButton("Se connecter");
		btEffacer =new JButton("Effacer");
		
		//jmb=new GProcessAppMenuBarAdmin();
		
	}
		
	private void layoutComponents() {
		//setJMenuBar(jmb);
		add(pAuthentification);
		pAuthentification.setLayout(new GridLayout(0,2,5,5));
		pAuthentification.add(lbLogin);pAuthentification.add(tfLogin);
		pAuthentification.add(lbPassword);pAuthentification.add(pfPasswd);
		add(pConnexion,BorderLayout.SOUTH);
		pConnexion.setLayout(new GridLayout(0,2,5,5));
		pConnexion.add(btConnecter);
		pConnexion.add(btEffacer);
	}
	
	private void setController() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(AuthentificationFrame.this, "Voulez vous vraiment quitter l'application ?","Boite de fermeture",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		btEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfLogin.setText("");
				pfPasswd.setText("");
			}
		});
		
		btConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(	tfLogin.getText().equals("") || 
						pfPasswd.getText().equals("")
					){
						JOptionPane.showConfirmDialog(btConnecter, "Veuillez remplir tous les champs");
					}else {	
							String idProfil=null;
							String Login =tfLogin.getText();
					        String Password= pfPasswd.getText();
					        String id_employe = null;
					        String role=null;
					      //119;Admin;admin;1119;Admin
					       
					        try {
					        	idProfil = Controller.Profilmodel.getIdProfil(Login, Password);
					        	role = Controller.Profilmodel.getRoleProfil(Login, Password);
					        	id_employe=Controller.Profilmodel.getEmpProfil(Login, Password);
							} catch (Exception e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(btConnecter,"Login ou Password incorrecte");
							
							}
					        try {
					        	 model.ProfilModel.saveModelInFile(System.getProperty("user.dir")+"/datafiles/abcd.sdata",idProfil,Login,Password,id_employe,role);
							} catch (Exception e) {
								System.out.println("*********Error : Authentification line 156");
							}
					        switch(role){
					        case "Pilote" : 
					        	try {
						            Controller.frAuth.setVisible(false);
									Controller.pilote=new Pilote();
									Controller.pilote.setVisible(true);
					             } catch (Exception e) 
				             		{
					            	 	e.printStackTrace();
				             		}
					        	break;
					        case "Admin" :
					        	try {
						            Controller.frAuth.setVisible(false);
									Controller.frMain=new GProcessAppFrame();
									Controller.frMain.setVisible(true);
					             } catch (Exception e) 
				             		{
					            	 	e.printStackTrace();
				             		}break;
					        case "Responsable" :
					        	try {
						            Controller.frAuth.setVisible(false);
						            Controller.GPG2=new GestionProcessus();
									Controller.GPG2.setVisible(true);
					             } catch (Exception e) 
				             		{
					            	 	e.printStackTrace();
				             		}break;
					        case "Employe" :
					        	try {
						            Controller.frAuth.setVisible(false);
						            Controller.GPG3=new GestionProcessusG3();
									Controller.GPG3.setVisible(true);
					             } catch (Exception e) 
				             		{
					            	 	e.printStackTrace();
				             		}break;
					        }
					        try {
								clear();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        JOptionPane.showMessageDialog(btConnecter,"Vous êtes connecté");
							}
				try {
					Persistent.getEmployeByProfil();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

