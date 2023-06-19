package view.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import controller.Controller;



public class GProcessAppToolBar extends JToolBar{
	private JButton btOuvrir,btEnregistrer,btConncter,btparametre,btNouveau,btList,btFiches;
	

	public GProcessAppToolBar(){
		initComponents();
		layoutComponents();
		setController();
		setFloatable(false);//fixer la barre
		setVisible(false);
	}
	private void initComponents() {
		// TODO Auto-generated method stub
		btOuvrir=new JButton(new ImageIcon("images/icons/open.gif"));
		btEnregistrer=new JButton(new ImageIcon("images/icons/Save.png"));
		btConncter=new JButton(new ImageIcon("images/icons/connexion.png"));
		btparametre=new JButton(new ImageIcon("images/icons/reference.png"));
		btNouveau=new JButton();
		btList=new JButton();
		btFiches=new JButton();
	}
	private void setController() {
		
		
		
		
	}

	private void layoutComponents() {
		// TODO Auto-generated method stub
		add(btOuvrir);
		add(btEnregistrer);
		add(btConncter);
		add(btparametre);
	}

	
}


