package view.frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Statistique extends javax.swing.JFrame {

    public DefaultTableModel RowEmploye;
    public int id ;
    public String CIN;
    /**
     * Creates new form Statistique
     * @return 
     */
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
    public Statistique() {
        initComponents();
        this.setLocation(450, 100); 
        try {
                ResultSet rs = connection().executeQuery("SELECT * FROM employe ");
                RowEmploye = new DefaultTableModel();
                String[] names = {"Id employ�", "Nom", "Prenom", "CIN", "Date de recrutement", "Date de naissance"};
                RowEmploye.setColumnIdentifiers(names);
                while (rs.next())
                {
                    Object[] objects = new Object[6];
                    objects[0] = rs.getInt(1);
                    objects[1] = rs.getString(2);
                    objects[2] = rs.getString(3);
                    objects[3] = rs.getString(4);
                    objects[4] = rs.getString(10);
                    objects[5] = rs.getString(5);
                    RowEmploye.addRow(objects);
                }
                ListeProc.setModel(RowEmploye);
                ListeProc.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void paintComponent(Graphics g){
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        afficher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Afficher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeProc = new javax.swing.JTable();
        NomEmp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        afficher.setText("Rechercher");
        afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom de l'employ�");

        Afficher.setText("Afficher le Graphique");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });

        ListeProc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListeProc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeProcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeProc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(NomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(afficher)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Afficher)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(afficher)
                    .addComponent(NomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void afficherActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         try {
            ResultSet rst = connection().executeQuery("SELECT * FROM employe where Nom LIKE '" +NomEmp.getText()+"%'");
            RowEmploye = new DefaultTableModel();
            String[] names = {"Id employ�", "Nom", "Prenom", "CIN", "Date de recrutement", "Date de naissance"};
            RowEmploye.setColumnIdentifiers(names);
            while (rst.next())
            {
                Object[] objects = new Object[6];
                objects[0] = rst.getInt(1);
                objects[1] = rst.getString(2);
                objects[2] = rst.getString(3);
                objects[3] = rst.getString(4);
                objects[4] = rst.getString(10);
                objects[5] = rst.getString(5);
                
                RowEmploye.addRow(objects);
            }
            ListeProc.setModel(RowEmploye);
            ListeProc.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        try
        {
            String queryGraph = "select * from archive_employe where Cin = '"+CIN+"'";
            ResultSet resultat1 = connection().executeQuery(queryGraph);
            DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
            
             JPanel pnl = new JPanel(new BorderLayout());
             setContentPane(pnl);
             setSize(800, 500);
            while ( resultat1.next())
            {
               bardataset.setValue(resultat1.getInt(3),resultat1.getString(5),resultat1.getString(4));
            } 
            JFreeChart barchart = ChartFactory.createBarChart("Evolution des employ�s au sein de l'entreprise","Date","Nombre d'ann�e",bardataset,PlotOrientation.VERTICAL,true,true,false);
            ChartPanel cpanel = new ChartPanel(barchart);
            pnl.add(cpanel);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Pas d'employ� avec ce CIN");
        }
    }                                        

    private void ListeProcMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
        int ij = ListeProc.getSelectedRow();
        CIN = (String) ListeProc.getValueAt(ij, 3);
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Afficher;
    private javax.swing.JTable ListeProc;
    private javax.swing.JTextField NomEmp;
    private javax.swing.JButton afficher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    
}