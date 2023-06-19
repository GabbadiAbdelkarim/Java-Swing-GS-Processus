package view.window;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import model.persistence.Persistent;

public class SplashScreenWindow extends JWindow{
	
	private JProgressBar pbStart;
	
	public SplashScreenWindow() {
		
		setSize(450,350);
		setLocationRelativeTo(null);
		add(new JLabel(){
			public void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    g.drawImage(new ImageIcon("images\\background.jpg").getImage(), 0, 0,getWidth(),getHeight(), this);
			}
		});
		pbStart = new JProgressBar(0,100);
		add(pbStart,BorderLayout.SOUTH);
		
		setVisible(true);
		
		for(int i=0;i<10;i++){
			pbStart.setValue(i);
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		dispose();
	}
}
