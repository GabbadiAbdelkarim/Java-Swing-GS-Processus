package view.menubar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileFilter;

import controller.Controller;
import model.persistence.Persistent;



/***
 * 
 * @author GABBADI
 *
 */
public class GProcessAppMenuBarPilote extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mFichier,mEmploye,mProfil,mMessage,mAffichage,mStyle,mAide;
	private JMenuItem miOuvrir,miEnregistrer,miConnecter,miQuitter;//menu fichier
	private JMenuItem miListerE,miNouveauE;//menu Employe
	private JMenuItem miListerP,miNouveauP;//menu Profil
	private JMenuItem miEnvMessage,miListMessage;//menu Message
	private JMenuItem miApropos;//menu aide
	
	private String[] styles=new String[]{"Autumn","BusinessBlackSteel","BusinessBlueSteel","Business","ChallengerDeep","CremeCoffee","Creme","EmeraldDusk","Magma","MistAqua","MistSilver","Moderate","NebulaBrickWall","Nebula","OfficeBlue2007","OfficeSilver2007","RavenGraphiteGlass","RavenGraphite","Raven","Sahara"};
	private LookAndFeelInfo[] lf = UIManager.getInstalledLookAndFeels();
	
	public GProcessAppMenuBarPilote() throws Exception {
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() throws Exception {
		mFichier=new JMenu("Fichier");
		mFichier.setMnemonic(KeyEvent.VK_F);
		miOuvrir=new JMenuItem("Ouvrir...");
			miOuvrir.setToolTipText("Ouvrir un fichier de données");
			miOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		miEnregistrer=new JMenuItem("Enregistrer...");
			miEnregistrer.setToolTipText("Enregistrer un fichier de données");
			miEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
//		miConnecter=new JMenuItem("Se connecter");
//			miConnecter.setToolTipText("Se connecter à une base de données");
//			miConnecter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miQuitter=new JMenuItem("Quitter");
			miQuitter.setToolTipText("Quitter l'application");
			miQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		
		mEmploye=new JMenu("Employe");
		mEmploye.setMnemonic(KeyEvent.VK_S);
		miListerE=new JMenuItem("Liste Employé");
			miListerE.setToolTipText("liste des employés");
			miListerE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		miNouveauE=new JMenuItem("Nouveau employé");
			miNouveauE.setToolTipText("nouveau employé");
			miNouveauE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		mProfil=new JMenu("Profil");
		mProfil.setMnemonic(KeyEvent.VK_S);
		miListerP=new JMenuItem("Liste profil");
			miListerE.setToolTipText("liste des profils");
			miListerE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		miNouveauP=new JMenuItem("Nouveau profil");
			miNouveauE.setToolTipText("nouveau profil");
			miNouveauE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		
		mMessage=new JMenu("Messages");
			mMessage.setMnemonic(KeyEvent.VK_M);
			miListMessage=new JMenuItem("Liste messages");
				miListerE.setToolTipText("liste des messages");
				miListerE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
			miEnvMessage=new JMenuItem("Nouveau message");
				miNouveauE.setToolTipText("nouveau message");
				miNouveauE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
			
		mAffichage=new JMenu("Affichage");
		mAffichage.setMnemonic(KeyEvent.VK_A);
		mStyle=new JMenu("Thème de l'application");
		
		
		mAide=new JMenu("Aide");
		mAide.setMnemonic(KeyEvent.VK_D);
		miApropos=new JMenuItem("A Propos");
	}

	
	private void layoutComponents() {
			add(mFichier);
				mFichier.add(miOuvrir);	
				mFichier.add(miEnregistrer);
				mFichier.addSeparator();
				//mFichier.add(miConnecter);	
				mFichier.addSeparator();
				mFichier.add(miQuitter);
			add(mEmploye);
				mEmploye.add(miNouveauE);	
				mEmploye.add(miListerE);
			add(mProfil);
				mProfil.add(miNouveauP);	
				mProfil.add(miListerP);
			add(mMessage);
				mMessage.add(miEnvMessage);	
				mMessage.add(miListMessage);
			
			add(mAffichage);
				mAffichage.add(mStyle);
					for(LookAndFeelInfo f:lf)
						mStyle.add(f.getName());
					for(String s:styles)
						mStyle.add(s);
			add(mAide);
				mAide.add(miApropos);
				
	}
	
	private void setController() {
		
		miOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser(new File("./datafiles"));
				fc.setFileFilter(new FileFilter(){
					public boolean accept(File file){
					      if(file.isDirectory())return true; 
					      return file.getName().toLowerCase().endsWith(".sdata");
					}
					public String getDescription() {
						return "fichier stagiaire" ;
					}
				});
                fc.setAcceptAllFileFilterUsed(false);
                fc.setDialogTitle("Importation d'une liste d'employés");
				
                if(fc.showOpenDialog(miOuvrir)==JFileChooser.APPROVE_OPTION){
					String nomFichier = fc.getSelectedFile().getAbsolutePath();
					try {
						int n=Controller.Employemodel.setModelFromFile(nomFichier);
						JOptionPane.showMessageDialog(miOuvrir, n+" employé chargés avec succes","Chargement terminé", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(miOuvrir, "Echec du chargement des employés ","Chargement terminé", JOptionPane.INFORMATION_MESSAGE);
					} 
				}

			}
			
		});
		
		miEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser(new File("./datafiles"));
				fc.setSelectedFile(new File("employés_"+new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date())+".sdata"));
				
				if(fc.showSaveDialog(miEnregistrer)==JFileChooser.APPROVE_OPTION){
					String nomFichier = fc.getSelectedFile().getAbsolutePath();
					try {
						Controller.Employemodel.saveModelInFile(nomFichier);
						JOptionPane.showMessageDialog(miEnregistrer, "L'enregistrement est terminé avec succes","Enregistrement terminé", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(miEnregistrer, "Echec d'enregistrement des employés","Enregistrement terminé", JOptionPane.INFORMATION_MESSAGE);
					} 
				}
			}
		});
//		miConnecter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(miConnecter.getText().equals("Se connecter")){
//					JTextField  tfUser=new JTextField();
//					JPasswordField pfPassword=new JPasswordField();
//					Object[] list={"user",tfUser,"password",pfPassword};
//					if(0==JOptionPane.showOptionDialog(null, list, "login", JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Se connecter", "Annuler"},null)){
//						try {
//							Controller.Employemodel.seConnecter(tfUser.getText(),pfPassword.getText());
//							Controller.Employemodel.setModelFromDB();
//							try{
//								Controller.Employemodel.getAllEmployeID();
//							}catch(Exception ex){System.out.println("problem a3chiri!");}
//							miConnecter.setText("se Déconnecter");
//							
//							JOptionPane.showMessageDialog(miConnecter,"Vous etes maintenant Connecté à la base de données");
//						} catch (Exception e1) {
//							JOptionPane.showMessageDialog(miConnecter,"Echec Connexion à la base de données");
//						}
//					}
//				}
//				if(miConnecter.getText().equals("Se Déconnecter")){
//					try {
//						Controller.Employemodel.seDeconnecter();
//						miConnecter.setText("se Déconnecter");
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(miConnecter,"Echec de déconnexion à la base de données");
//					}
//				}
//			}
//		});
		
		
		
		miQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(miQuitter, "Voulez vous vraiment quitter l'application ?","boite de fermeture",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		miListerE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				try {
					Controller.Employemodel.setModelFromDB();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(miConnecter,"Problème chargement données");
					e1.printStackTrace();
				}
				Controller.ifrListerE.setVisible(true);
				Controller.ifrListerE.toFront();
			}
		});
		
		miNouveauE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.ifrNouveauE.setVisible(true);
				Controller.ifrNouveauE.toFront();
			}
		});
		
			
		miListerP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				try {
					Controller.Profilmodel.setModelFromDB();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(miConnecter,"Problème chargement données");
					e1.printStackTrace();
				}
				Controller.ifrListerP.setVisible(true);
				Controller.ifrListerP.toFront();
			}
		});
		
		miNouveauP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.ifrNouveauP.setVisible(true);
				Controller.ifrNouveauP.toFront();
				Controller.ifrNouveauP.MajCombo();
			}
		});
		
		miListMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				try {
					Controller.Messagemodel.setModelFromDB();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(miConnecter,"Problème chargement données");
					e1.printStackTrace();
				}
				try{
					Controller.ifrListerM.setVisible(true);
					Controller.ifrListerM.toFront();
				}catch(Exception ea){
					ea.printStackTrace();
				}
			}
		});
		
		miEnvMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Controller.ifrNouveauM.setVisible(true);
					Controller.ifrNouveauM.toFront();
				}catch(Exception ea){
					ea.printStackTrace();
				}
				
			}
		});
		
		
		miApropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.ifrApropos.setVisible(true);
				Controller.ifrApropos.toFront();
			}
		});
		
		
		
		for(int i=0;i<lf.length;i++)
			mStyle.getItem(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<lf.length;i++)
						if(e.getSource().equals(mStyle.getItem(i)))
						{
							try {
									UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[i].getClassName());
									SwingUtilities.updateComponentTreeUI(Controller.frMain);
								} catch (ClassNotFoundException	| InstantiationException| IllegalAccessException| UnsupportedLookAndFeelException e1) {
									JOptionPane.showMessageDialog(mStyle,"Echec de l'affichage !!");
								}
						}	
				}
			});
				
		for(int j=lf.length;j<mStyle.getItemCount();j++)
			mStyle.getItem(j).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						UIManager.setLookAndFeel("org.jvnet.substance.skin.Substance"+((JMenuItem)e.getSource()).getText()+"LookAndFeel");
						SwingUtilities.updateComponentTreeUI(Controller.frMain);
					} catch (ClassNotFoundException	| InstantiationException| IllegalAccessException| UnsupportedLookAndFeelException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(mStyle,"Echec de l'affichage !!");
					}
				}
			});
		
	}
		
		
	}
	


