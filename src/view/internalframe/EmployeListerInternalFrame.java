package view.internalframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import model.entities.Employe;



/***
 * 
 * @author GABBADI
 *
 */
public class EmployeListerInternalFrame extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pButtonsMAJ;
	private JScrollPane spListe;
	private JTable tbListe;
	private JButton btModifier, btSupprimer;
	
	
	public EmployeListerInternalFrame() {
		super("Liste des employés",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() {
		setSize(1200,300);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	    
		tbListe=new JTable();
	    spListe=new JScrollPane(tbListe);
	    tbListe.setModel(Controller.Employemodel);
	    tbListe.getTableHeader().setReorderingAllowed(false);
	    
	    pButtonsMAJ=new JPanel();	
	    btModifier =new JButton("Modifier");
		btSupprimer =new JButton("Supprimer");
		
	}
	
	private void layoutComponents() {
		add(spListe);
		add(pButtonsMAJ,BorderLayout.SOUTH);
			pButtonsMAJ.add(btSupprimer);
			pButtonsMAJ.add(btModifier);
	}		
	
	private void setController() {
							
		btSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btSupprimer, "Voulez vraiment supprimer cet employé ?")){
						Controller.Employemodel.delete(Controller.Employemodel.getEmploye(tbListe.getSelectedRow()));
						JOptionPane.showMessageDialog(btSupprimer,"Employé supprimé avec succès");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(btSupprimer,"Echec suppression de l'employé");
				}				
			}
		});
		
		btModifier.addActionListener(new ActionListener() {
			Employe e = new Employe();
			public void actionPerformed(ActionEvent arg0) {
					e=Controller.Employemodel.getEmploye(tbListe.getSelectedRow());
					Controller.ifrModifier.setEmploye(e);
					Controller.ifrModifier.setVisible(true);
					Controller.ifrModifier.toFront();
				
			}
		});
	}

}
