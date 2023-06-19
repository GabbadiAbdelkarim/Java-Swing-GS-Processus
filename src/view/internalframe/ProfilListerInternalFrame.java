package view.internalframe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import model.entities.Employe;
import model.entities.Profil;



/***
 * 
 * @author GABBADI
 *
 */
public class ProfilListerInternalFrame extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pButtonsMAJ;
	private JScrollPane spListe;
	private JTable tbListe;
	private JButton btModifier, btSupprimer;
	
	
	public ProfilListerInternalFrame() {
		super("Liste des Profils",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() {
		setSize(500,300);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	    
		tbListe=new JTable();
	    spListe=new JScrollPane(tbListe);
	    tbListe.setModel(Controller.Profilmodel);
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
					if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btSupprimer, "Voulez vraiment supprimer ce profil ?")){
						Controller.Profilmodel.delete(Controller.Profilmodel.getProfil(tbListe.getSelectedRow()));
						JOptionPane.showMessageDialog(btSupprimer,"Profil supprimé avec succès");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(btSupprimer,"Echec suppression du profil !");
				}				
			}
		});
		
		btModifier.addActionListener(new ActionListener() {
			Profil p = new Profil();
			public void actionPerformed(ActionEvent arg0) {
					p=Controller.Profilmodel.getProfil(tbListe.getSelectedRow());
					Controller.ifrMofierP.setProfil(p);
					Controller.ifrMofierP.setVisible(true);
					Controller.ifrMofierP.toFront();
				
			}
		});
	}

}
