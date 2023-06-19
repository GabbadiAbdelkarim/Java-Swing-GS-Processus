package view.internalframe;


import javax.swing.JInternalFrame;

public class Authentification extends JInternalFrame{
	 
	public Authentification() {
		super("A propos",true,true,true,true);
		initComponents();
		setController();
	}
	private void initComponents() {
		setSize(500,200);
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	}

	private void setController() {
	}
}
