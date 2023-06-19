package view.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

import controller.Controller;
import model.persistence.Persistent;
import view.desktoppane.GSAppDesktopPane;
import view.menubar.GProcessAppMenuBarAdmin;
import view.toolbar.GProcessAppToolBar;



/***
 * 
 * @author GABBADI
 *
 */
public class GProcessAppFrame extends JFrame {
	
	private JMenuBar jmb;
	private JDesktopPane jdp;

	public GProcessAppFrame() throws Exception{
		
		initComponents();
		layoutComponents();
		setController();
		setVisible(true);
		
	}
	
	private void initComponents() throws Exception {
		Persistent.seConnecter("root", "");
		setTitle("Application de gestion des processus");
		setSize(getToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("images\\icon.jpg").getImage());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		jmb=new GProcessAppMenuBarAdmin();
		jdp=new GSAppDesktopPane();
		Controller.jtb=new GProcessAppToolBar();

	}
		
	private void layoutComponents() {
		setJMenuBar(jmb);
		add(jdp);
		add(Controller.jtb, BorderLayout.PAGE_START);
	}
	
	private void setController() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if(JOptionPane.showConfirmDialog(GProcessAppFrame.this, "Voulez vous vraiment quitter l'application ?","Boite de fermeture",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		


				
	}
}

