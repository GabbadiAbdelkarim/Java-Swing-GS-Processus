package view.internalframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;
import model.MessageModel;
import model.entities.Message;
import model.entities.Sexe;

/***
 * 
 * @author GABBADI
 *
 */
public class MessageLireInternalFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pMessage,pButtons;
	
	private JLabel lbEmet,lbDest,lbMessage,lbDate;
	
	private JTextField tfEmet,tfDest,tfDate;
	private JTextArea tfMessage;
	private JScrollPane spMessage;
	private JButton btOK;
	
	private Message m;
	
	
	public MessageLireInternalFrame() {
		super("Message",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	public void setMessage(Message m){
		this.m=m;
		try {
			initValues();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void initComponents() {
		setSize(500,300);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		pMessage=new JPanel();
		pButtons=new JPanel();
		/********Emet**************/
		lbEmet=new JLabel("De :");
		tfEmet=new JTextField(5);
		tfEmet.setEnabled(false);
		/********Recepteur**************/
		lbDest=new JLabel("A :");
		tfDest=new JTextField(5);
		tfDest.setEnabled(false);
		/********Message**************/
		lbMessage=new JLabel("Message :");
		tfMessage=new JTextArea(8,20);
		tfMessage.setLineWrap(true);
		tfMessage.setEnabled(false);
		spMessage=new JScrollPane(tfMessage);
		

		/********date**************/
		lbDate=new JLabel("Date :");
		tfDate=new JTextField(5);
		tfDate.setEnabled(false);
		
		/********boutons**************/
		btOK=new JButton("OK");
	
			
	}
	private void layoutComponents() {
		add(pMessage);
		pMessage.setLayout(new GridLayout(0,2,5,5));
		pMessage.add(lbEmet);pMessage.add(tfEmet);
		pMessage.add(lbDest);pMessage.add(tfDest);
		pMessage.add(lbMessage);pMessage.add(spMessage);
		pMessage.add(lbDate);pMessage.add(tfDate);
		add(pButtons,BorderLayout.SOUTH);
		pButtons.add(btOK);
	}
	private void setController() {
		
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
	
	}
	
	private void initValues() throws Exception{
		tfEmet.setText(Controller.Messagemodel.getEmployeById(m.getId_employe_Emet()));
		tfDest.setText(Controller.Messagemodel.getEmployeById(m.getId_employe_desti()));
		tfMessage.setText(m.getText());
		tfDate.setText(m.getDate_envoie().toString());
		}
}