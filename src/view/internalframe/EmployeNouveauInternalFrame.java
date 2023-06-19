package view.internalframe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import controller.Controller;
import model.EmployeModel;
import model.entities.Employe;
import model.entities.Profil;
import model.entities.Role;
import model.entities.Sexe;
import model.persistence.Persistent;

/***
 * 
 * @author GABBADI
 *
 */
public class EmployeNouveauInternalFrame extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel pEmploye,pButtonsNouveau,pSexe;
	private JScrollPane spAdress;
	
	private JLabel lbNom,lbPremon,lbCIN,lbDateRecut,lbDateNaiss,lbSexe,lbAdress,lblEmail,lblTelephone;
	
	private JTextField tfNom,tfPrenom,tfCIN;
	private JSpinner spnDateNaissane,spnDateRecrut;
	private JFormattedTextField ftfTel,ftfEmail;
	private ButtonGroup bgSexe;
	private JRadioButton rbSexeH,rbSexeF;
	private JTextArea taAdress;
	//private JComboBox<Object> cbProfil;
	//private JComboBox<Role> cbRole;
	
	private JButton btAjouter,btEffacer;
	
	public EmployeNouveauInternalFrame() {
		super("Nouvel Employé",true,true,true,true);
		initComponents();
		layoutComponents();
		setController();
	}
	
	private void initComponents() {
		setSize(400,450);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		pEmploye=new JPanel();
		pEmploye.setBorder(BorderFactory.createTitledBorder("Informations"));
		pButtonsNouveau=new JPanel();
		pSexe=new JPanel();

		/********nom**************/
		lbNom=new JLabel("Nom");
		tfNom=new JTextField(5);
		tfNom.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********prenom**************/
		lbPremon=new JLabel("Prénom");
		tfPrenom=new JTextField(5);
		tfPrenom.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		/********CIN**************/
		lbCIN=new JLabel("CIN");
		tfCIN=new JTextField(5);
		tfCIN.setDocument(new PlainDocument(){
			public void insertString(int arg0, String arg1, AttributeSet arg2)
					throws BadLocationException {
				if(getLength()<=20)
				super.insertString(arg0, arg1, arg2);
			}
		});
		
		/********date de naissance**************/
		lbDateNaiss=new JLabel("Date de Naissance");
		spnDateNaissane=new JSpinner(new SpinnerDateModel());
		spnDateNaissane.setValue(new Date());
		spnDateNaissane.setEditor(new JSpinner.DateEditor(spnDateNaissane,"dd/MM/yyyy"));
		/********sexe**************/
		lbSexe=new JLabel("Sexe");
		rbSexeH=new JRadioButton(Sexe.M.toString());
		rbSexeF=new JRadioButton(Sexe.F.toString());
		bgSexe=new ButtonGroup();
		bgSexe.add(rbSexeF);
		bgSexe.add(rbSexeH);
		rbSexeH.setSelected(true);
		
		/********adresse**************/
		lbAdress=new JLabel("Adresse");
		taAdress=new JTextArea(8,20);
		taAdress.setLineWrap(true);
		spAdress=new JScrollPane(taAdress);
		
		/********email**************/
		lblEmail=new JLabel("Email");
		ftfEmail=new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
				@Override
				public Object stringToValue(String s) throws ParseException {
					Matcher matcher=regex.matcher(s);
							if(matcher.matches())
								return s;
							else throw new ParseException("email invalid",0);
				} 
				@Override
				public String valueToString(Object v)  {
					return (String)v;
				}
				Pattern regex=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");		
			});
		
		/********tel**************/
		lblTelephone=new JLabel("Tel");
		try {MaskFormatter m = new MaskFormatter("06-##-##-##-##");
		m.setPlaceholderCharacter('_');
		ftfTel=new JFormattedTextField(m);
		} catch (ParseException e) {e.printStackTrace();}
		
		/********date de recrutement**************/
		lbDateRecut=new JLabel("Date de Recrutement");
		spnDateRecrut=new JSpinner(new SpinnerDateModel());
		spnDateRecrut.setValue(new Date());
		spnDateRecrut.setEditor(new JSpinner.DateEditor(spnDateRecrut,"dd/MM/yyyy"));
		
		
		/********boutons**************/
		btAjouter =new JButton("Ajouter");
		btEffacer =new JButton("Effacer");
		
	}
	
	private void layoutComponents() {
		add(pEmploye);
		pEmploye.setLayout(new GridLayout(0,2,5,5));
		pEmploye.add(lbNom);pEmploye.add(tfNom);
		pEmploye.add(lbPremon);pEmploye.add(tfPrenom);
		pEmploye.add(lbCIN);pEmploye.add(tfCIN);
		pEmploye.add(lbDateNaiss);pEmploye.add(spnDateNaissane);
		pEmploye.add(lbSexe);pEmploye.add(pSexe);pSexe.add(rbSexeH);pSexe.add(rbSexeF);
		pEmploye.add(lbAdress);pEmploye.add(spAdress);
		pEmploye.add(lblEmail);pEmploye.add(ftfEmail);
		pEmploye.add(lblTelephone);pEmploye.add(ftfTel);
		pEmploye.add(lbDateRecut);pEmploye.add(spnDateRecrut);
		//pEmploye.add(lblprofil);pEmploye.add(cbProfil);
		add(pButtonsNouveau,BorderLayout.SOUTH);
		pButtonsNouveau.add(btAjouter);
		pButtonsNouveau.add(btEffacer);
	}
	
	private void setController() {
		btAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(	tfNom.getText().equals("") || 
					tfPrenom.getText().equals("") ||
					tfCIN.getText().equals("") ||
					taAdress.getText().equals("") ||
					ftfEmail.getText().equals("")
				){
					JOptionPane.showConfirmDialog(btAjouter, "Veuillez remplir tous les champs");
				}else {
				try {	
					Employe emp = new Employe();
					emp.setNom(tfNom.getText());
					emp.setPrénom(tfPrenom.getText());
					emp.setCin(tfCIN.getText());
					emp.setDate_Naissance((Date)spnDateNaissane.getValue());
					emp.setSexe(rbSexeF.isSelected()?Sexe.F:Sexe.M);
					emp.setAdresse(taAdress.getText());
					emp.setEmail(ftfEmail.getText());
					emp.setTelephone(ftfTel.getText());
					emp.setDate_Recrutement((Date)spnDateRecrut.getValue());

//					emp.setProfile((int)cbProfil.getSelectedItem());
						if(JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(btAjouter, "Voulez vraiment ajouter l'Employe\n"+emp+" ?")){
							Controller.Employemodel.add(emp);
							JOptionPane.showMessageDialog(btAjouter,"Employe ajouté avec succès");
							
						}
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(btAjouter,"Echec ajout du Employe");
					}
				
			}}
		});
		btEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNom.setText("");
				tfPrenom.setText("");
				spnDateNaissane.setValue(new Date());
				bgSexe.clearSelection();
				taAdress.setText("");
				
			}
		});
	}
}
