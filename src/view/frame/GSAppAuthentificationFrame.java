package view.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.persistence.Persistent;
import view.menubar.GProcessAppMenuBarAdmin;
import view.menubar.GProcessAppMenuBarPilote;
import view.menubar.GProcessAppMenuBarResponsable;

public class GSAppAuthentificationFrame extends JFrame{
	private static final long serialVersionUID = 1L;
		/**
	     * Creates new form CreateProcessus
	     */
	    public int codeEmploye;
	    public GSAppAuthentificationFrame() {
	        initComponents();
	        this.setLocation(450, 100);
	    }
	    
	    public Statement connection()
	    {
	        
	        Connection cnx =null;
	        Statement stm=null;
	        String user="root";
	        String pass="";
	        try {
	            cnx=DriverManager.getConnection("jdbc:mysql://localhost/gestionprocessus",user,pass);
	            stm = cnx.createStatement();
	            return stm;
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "test", JOptionPane.ERROR_MESSAGE);
	        }
	        return null;
	    }
	    
	    private void initComponents() {
	        jPanel1 = new javax.swing.JPanel();
	        btConnecter = new javax.swing.JButton();
	        btEffacer = new javax.swing.JButton();
	        lbLogin = new javax.swing.JLabel();
	        lbPassword = new javax.swing.JLabel();
	        LoginAuthentification = new javax.swing.JTextField();
	        jLabel6 = new javax.swing.JLabel();
	        PasswordAuthentification = new javax.swing.JPasswordField();
	        jPanel2 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        Information = new javax.swing.JTextArea();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setBackground(new java.awt.Color(0, 102, 255));
	        setForeground(new java.awt.Color(0, 51, 255));

	        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

	        btConnecter.setText("Se connecter");
	        btConnecter.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        btEffacer.setText("Effacer");
	        btEffacer.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        lbLogin.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
	        lbLogin.setText("Login");
	        lbLogin.setPreferredSize(new java.awt.Dimension(30, 14));

	        lbPassword.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
	        lbPassword.setText("Password");

	        LoginAuthentification.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                LoginAuthentificationActionPerformed(evt);
	            }
	        });

	        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
	        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
	        jLabel6.setText("Authentification");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(btEffacer)
	                .addGap(18, 18, 18)
	                .addComponent(btConnecter)
	                .addGap(26, 26, 26))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addGap(38, 38, 38)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
	                        .addComponent(LoginAuthentification, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(lbPassword)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(PasswordAuthentification, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGap(46, 46, 46))
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(76, 76, 76)
	                .addComponent(jLabel6)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addGap(73, 73, 73)
	                .addComponent(jLabel6)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(LoginAuthentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(PasswordAuthentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbPassword))
	                .addGap(53, 53, 53)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(btConnecter)
	                    .addComponent(btEffacer))
	                .addGap(89, 89, 89))
	        );

	        Information.setBackground(new java.awt.Color(204, 204, 204));
	        Information.setColumns(20);
	        Information.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
	        Information.setForeground(new java.awt.Color(255, 0, 0));
	        Information.setRows(5);
	        Information.setEnabled(false);
	        jScrollPane1.setViewportView(Information);

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
	        );
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>                        

	    private void LoginAuthentificationActionPerformed(java.awt.event.ActionEvent evt) {                                                      
	    }                                                     

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	            LoginAuthentification.setText("");
	            PasswordAuthentification.setText("");
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        String Login =LoginAuthentification.getText();
	        String Password= PasswordAuthentification.getText();
	        try {
	               ResultSet resultSet= connection().executeQuery
	            		   ("SELECT * FROM PROFIL where login = '"+Login+"' and mot_de_passe = '"+Password+"'");
	               		resultSet.next();
	               		codeEmploye = resultSet.getInt(1);
//	               if("Admin".equals(resultSet.getString("type")))             // Est ce qu'il ya "ADMIN" comme role ?
//	               {
//	                this.setVisible(false);
//	                AcceilAdmin admin = new AcceilAdmin();
//	                admin.setVisible(true); 
//	                admin.setLocationRelativeTo(null);
//	               }
	               if("Responsable".equals(resultSet.getString("role")))         
	               {
	                 this.setVisible(false);
	                 GProcessAppMenuBarResponsable responsable = new GProcessAppMenuBarResponsable();
	                 responsable.setVisible(true);
	                 responsable.setLocation(null);
	               }
	               else if("Pilote".equals(resultSet.getString("type")))
	               {
	                this.setVisible(false);
	                GProcessAppMenuBarPilote pilote = new GProcessAppMenuBarPilote();
	                pilote.setVisible(true);
	                pilote.setLocation(null);
	               }
	               else
	               {
	                 this.setVisible(false);
	                 GProcessAppMenuBarAdmin Admin = new GProcessAppMenuBarAdmin();
	                 Admin.setVisible(true); 
	                 Admin.setLocation(null);
	               }
	        }
	        catch (SQLException ex) {
	                Information.setText("Login ou Password incorrect");
	        } catch (Exception e) {
				e.printStackTrace();
			}
	    }                                        

//	    public static void main(String args[]) {
//	        
//	        java.awt.EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                new GSAppAuthentificationFrame().setVisible(true);
//	            }
//	        });
//	    }

	    private javax.swing.JTextArea Information;
	    private javax.swing.JTextField LoginAuthentification;
	    private javax.swing.JPasswordField PasswordAuthentification;
	    // Les noms des boutons n'ont pas de sens
	    private javax.swing.JButton btEffacer;
	    private javax.swing.JButton btConnecter;
	    private javax.swing.JLabel lbLogin;
	    private javax.swing.JLabel lbPassword;
	    private javax.swing.JLabel jLabel6;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JScrollPane jScrollPane1;

	    private boolean egal(String admin, String string) {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	}


