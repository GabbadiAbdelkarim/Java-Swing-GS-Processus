package controller;


import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JWindow;

import view.window.SplashScreenWindow;

import model.EmployeModel;
import model.MessageModel;
import model.ProfilModel;
import view.frame.AuthentificationFrame;
import view.frame.GSAppAuthentificationFrame;
import view.frame.Gest;
import view.frame.Pilote;
import view.frame.Responsale;
import view.frame.Statistique;
import view.internalframe.*;
import view.frame.frame3.GestionProcessusG3;
import view.frame.GestionProcessus;

/***
 * 
 * @author GABBADI
 *
 */
public class Controller {
	public static JWindow wdSplash;
	public static JFrame frMain;
	public static JFrame frAuth;
	public static EmployeListerInternalFrame ifrListerE;
	public static EmployeNouveauInternalFrame ifrNouveauE;
	public static EmployeModifierInternalFrame ifrModifier;

	public static ProfilListerInternalFrame ifrListerP;
	public static ProfilNouveauInternalFrame ifrNouveauP;
	public static ProfilModifierInternalFrame ifrMofierP;

	public static MessageListerInternalFrame ifrListerM;
	public static MessageNouveauInternalFrame ifrNouveauM;
	public static MessageLireInternalFrame ifrLireM;

	public static AproposInternalFrame ifrApropos;
	public static JToolBar jtb;
	
	
	public static Responsale resp;
	public static Pilote pilote;
	public static Gest guest;
	
	
	public static EmployeModel Employemodel=new EmployeModel();
	public static ProfilModel Profilmodel=new ProfilModel();
	public static MessageModel Messagemodel = new MessageModel();
	
	public static Statistique Stat = new Statistique();
	
	public static GestionProcessusG3 GPG3 = new GestionProcessusG3();
	public static GestionProcessus GPG2 = new GestionProcessus();
	public Controller() throws Exception {
	
		wdSplash=new SplashScreenWindow();
		frAuth = new AuthentificationFrame();
		//frMain=new GProcessAppFrame();
//		try {
//			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
//			SwingUtilities.updateComponentTreeUI(Controller.frMain);
//		} catch (ClassNotFoundException	| InstantiationException| IllegalAccessException| UnsupportedLookAndFeelException e1) {
//			
//		}
		
	
		
	}
}
