package view.menubar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileFilter;

import controller.Controller;
import model.persistence.Persistent;
import view.frame.GProcessAppFrame;



/***
 * 
 * @author GABBADI
 *
 */
public class GProcessAppMenuBarAdmin extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mFichier,mEmploye,mProfil,mMessage,mStatistique,mAffichage,mStyle,mAide;
	private JMenuItem miDeconnecter,miQuitter;//menu fichier
	private JMenuItem miListerE,miNouveauE;//menu Employe
	private JMenuItem miListerP,miNouveauP;//menu Profil
	private JMenuItem miEnvMessage,miListMessage;//menu Message
	private JMenuItem miStat,miApropos;//menu aide
	
	private String[] styles=new String[]{"Autumn","BusinessBlackSteel","BusinessBlueSteel","Business","ChallengerDeep","CremeCoffee","Creme","EmeraldDusk","Magma","MistAqua","MistSilver","Moderate","NebulaBrickWall","Nebula","OfficeBlue2007","OfficeSilver2007","RavenGraphiteGlass","RavenGraphite","Raven","Sahara"};
	private LookAndFeelInfo[] lf = UIManager.getInstalledLookAndFeels();
	
	public GProcessAppMenuBarAdmin() throws Exception {
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() throws Exception {
		mFichier=new JMenu("Fichier");
		mFichier.setMnemonic(KeyEvent.VK_F);
		miDeconnecter=new JMenuItem("Se deconnecter...");
			miDeconnecter.setToolTipText("Se deconnecter de l'application");
			miDeconnecter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
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
				
		mStatistique=new JMenu("Statistiques");
		miStat=new JMenuItem("Visualiser Statistiques");
		mAffichage=new JMenu("Affichage");
		mAffichage.setMnemonic(KeyEvent.VK_A);
		mStyle=new JMenu("Thème de l'application");
		
		
		mAide=new JMenu("Aide");
		mAide.setMnemonic(KeyEvent.VK_D);
		miApropos=new JMenuItem("A Propos");
	}

	
	private void layoutComponents() {
			add(mFichier);
				mFichier.add(miDeconnecter);	
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
			add(mStatistique);
			mStatistique.add(miStat);
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
		
		miDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(miQuitter, "Voulez vous se déconnecter ?","boite de fermeture",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					setVisible(false);
					(Controller.frMain).dispose();
					Controller.frAuth.setVisible(true);
				}
			}
		});
		
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
					JOptionPane.showMessageDialog(miDeconnecter,"Problème chargement données");
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
					JOptionPane.showMessageDialog(miDeconnecter,"Problème chargement données");
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
					JOptionPane.showMessageDialog(miDeconnecter,"Problème chargement données");
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
		
		miStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.Stat.setVisible(true);
				Controller.Stat.toFront();
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
	


