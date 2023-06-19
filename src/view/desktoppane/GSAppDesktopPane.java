package view.desktoppane;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import controller.Controller;
import view.frame.Statistique;
import view.internalframe.AproposInternalFrame;
import view.internalframe.EmployeListerInternalFrame;
import view.internalframe.EmployeModifierInternalFrame;
import view.internalframe.EmployeNouveauInternalFrame;
import view.internalframe.MessageLireInternalFrame;
import view.internalframe.MessageListerInternalFrame;
import view.internalframe.MessageNouveauInternalFrame;
import view.internalframe.ProfilListerInternalFrame;
import view.internalframe.ProfilModifierInternalFrame;
import view.internalframe.ProfilNouveauInternalFrame;

/***
 * 
 * @author GABBADI
 *
 */
public class GSAppDesktopPane extends JDesktopPane{
	
	public GSAppDesktopPane() {
		Controller.ifrListerE=new EmployeListerInternalFrame();
		Controller.ifrApropos=new AproposInternalFrame();
		Controller.ifrNouveauE=new EmployeNouveauInternalFrame();
		Controller.ifrModifier=new EmployeModifierInternalFrame();
		Controller.ifrListerM = new MessageListerInternalFrame();
		Controller.ifrNouveauM = new MessageNouveauInternalFrame();
		Controller.ifrLireM = new MessageLireInternalFrame();
		Controller.ifrMofierP=new ProfilModifierInternalFrame();
		Controller.Stat=new Statistique();
		add(Controller.ifrListerE);
		add(Controller.ifrApropos);
		add(Controller.ifrNouveauE);
		add(Controller.ifrModifier);
		add(Controller.ifrNouveauM);
		add(Controller.ifrListerM);
		add(Controller.ifrLireM);
		add(Controller.ifrMofierP);
		Controller.ifrListerP=new ProfilListerInternalFrame();
		Controller.ifrNouveauP=new ProfilNouveauInternalFrame();
		add(Controller.ifrListerP);
		add(Controller.ifrNouveauP);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(new ImageIcon("images\\background.jpg").getImage(), 0, 0,this.getWidth(),this.getHeight(), this);
	}
}
