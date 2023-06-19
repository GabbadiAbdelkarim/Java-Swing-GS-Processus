package view.internalframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import model.entities.Employe;
import model.entities.Message;



/***
 * 
 * @author GABBADI
 *
 */
public class MessageListerInternalFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pButtonsMAJ;
	private JScrollPane spListe;
	private JTable tbListe;
	private JButton btLire;
	
	public MessageListerInternalFrame() {
		super("Liste des messages",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() {
		setSize(700,300);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	    
		tbListe=new JTable();
	    spListe=new JScrollPane(tbListe);
	    tbListe.setModel(Controller.Messagemodel);
	    tbListe.getTableHeader().setReorderingAllowed(false);
	    
	    pButtonsMAJ=new JPanel();	
		btLire =new JButton("Lire");
		
	}
	
	private void layoutComponents() {
		add(spListe);
		add(pButtonsMAJ,BorderLayout.SOUTH);
			pButtonsMAJ.add(btLire);
	}		
	
	private void setController() {
							
		btLire.addActionListener(new ActionListener() {
			Message m = new Message();
				public void actionPerformed(ActionEvent arg0) {
					try {
						m=Controller.Messagemodel.getMessage(tbListe.getSelectedRow());
						//m.setId_message(0);
						Controller.ifrLireM.setMessage(m);
						Controller.ifrLireM.setVisible(true);
						Controller.ifrLireM.toFront();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
						
				}
		});
	}

}
