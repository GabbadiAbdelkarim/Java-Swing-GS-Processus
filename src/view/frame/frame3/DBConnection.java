package view.frame.frame3;

import  controller.controller3.*;
import model.model3.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnection 
{
 public Connection con;
 private Statement st;
 private ResultSet rs;
 
 
 public DBConnection()
 {
     try 
     {
         
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/gestionprocessus";
             String username = "root";
             String password = "";

              System.out.println("Connecting database...");
             con = DriverManager.getConnection(url, username, password) ;
             
             System.out.println("Connected!");
    } 
     catch (ClassNotFoundException e)

    {
    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
    }
     catch (SQLException e) {
    throw new IllegalStateException("Cannot connect the database!", e);
    }
 }
    /// ANOMALIE//////////////////////////////////////////////////////////////////////////////////////////////////////
     public String[] getAnomaliesIds()
     {
         String[] ids= new String[1];
         try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Processus");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          ids = new String[count] ;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_anomalie from Processus");
            int i = 0;
            while (rs.next()) 
            {
                ids[i] = rs.getString("id_anomalie");
                i++;

            }
            } catch (SQLException e ) 
            {
                System.out.println(e);
            } 
              finally 
              {
                if (st != null) 
                { 
                    try 
                    {
                            st.close();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                 return ids;
             }
     public AnomalieModel[] getAnomalielist()
    {
     AnomalieModel[] t= new AnomalieModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM anomalie");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new AnomalieModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Anomalie");
        AnomalieModel anomalie;
        int i = 0;
        while (rs.next()) 
        {
            String id = rs.getString("id_anomalie");
            String libelle = rs.getString("libelle");
            String Detaille = rs.getString("Detaille");
            String duree = rs.getString("duree");
            String id_processus = rs.getString("id_processus");
            System.out.println("Id :"+id+" Libelle : "+libelle+" Detaille : "+Detaille+" durée : "+duree+" Processus :   "+id_processus);
            anomalie = new AnomalieModel(id, libelle, Detaille,duree,id_processus);
            t[i]=anomalie;
            i++;
            anomalie=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addAnomalie(String libelle,String Detaille,String duree,String id_processus)
     {
         String query ="insert into Anomalie(Libelle,Detaille,duree,id_processus) values('"+libelle+"','"+Detaille+"','"+duree+"','"+id_processus+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editAnomalie(String id_anomalie,String libelle,String Detaille,String duree,String id_processus)
     {
         String query ="update Anomalie set Libelle = '"+libelle+"', detaille='"+Detaille+"', duree='"+duree+"', id_processus='"+id_processus+"' where id_Anomalie = "+id_anomalie+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteAnomalie(String id_anomalie)
     {
          String query ="delete from  Anomalie  where Id_Anomalie ="+id_anomalie+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
     /////////////////////////////////EMPLOYE//////////////////////////////////////////////////////////////////
     public String[] getEmployeIds()
     {
         String[] ids= new String[1];
         try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM employe ");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          ids = new String[count] ;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select Id_Employe from employe");
            int i = 0;
            while (rs.next()) 
            {
                ids[i] = rs.getString("id_employe");
                i++;

            }
            } catch (SQLException e ) 
            {
                System.out.println(e);
            } 
              finally 
              {
                if (st != null) 
                { 
                    try 
                    {
                            st.close();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                 return ids;
             }
     public EmployeModel[] getEmployelist()
    {
     EmployeModel[] t= new EmployeModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM employe");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new EmployeModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from employe");
        EmployeModel employe;
        int i = 0;
        while (rs.next()) 
        {
            String id_employe = rs.getString("id_employe");
            String id_profile = rs.getString("id_profile");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String cin = rs.getString("cin");
            String date_recrutement = rs.getString("date_recrutement");
            String date_naissance = rs.getString("date_naissance");
            
            System.out.println("id_employe :"+id_employe+" id_profile : "+id_profile+" nom : "+nom+" prenom :   "+prenom+" cin :   "+cin+" date_recrutement :   "+date_recrutement+" date_naissance :   "+date_naissance);
            employe = new EmployeModel( id_employe,id_profile, nom, prenom, cin, date_recrutement, date_naissance);
            t[i]=employe;
            i++;
            employe=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addEmploye( String id_profile, String nom, String prenom,String cin,String date_recrutement,String date_naissance)
     {
         // ( id_profile, nom, prenom, cin, date_recrutement, date_naissance);
         /*
         INSERT INTO `gestionprocessus`.`employe` (`Id_Employe`, `id_profile`, `Nom`, `Prenom`, `Cin`, `Date_Recrutement`, `Date_Naissance`) 
         VALUES ('1', '1', 'alaoui', 'babla', '78ghki', '2016-06-07', '2016-06-08');
         */
         String query ="insert into Employe(id_profile,nom,prenom,cin,date_recrutement,date_naissance) values('"+
                 id_profile+"','"+nom+"','"+prenom+"','"+cin+"','"+date_recrutement+"','"+date_naissance+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editEmploye(String id_employe, String id_profile, String nom, String prenom,String cin,String date_recrutement,String date_naissance)
     {
         /*
         UPDATE `gestionprocessus`.`employe` SET `Id_Employe` = '3', `id_profile` = '1', `Nom` = 'nomndom', `Prenom` = 'pooikjd', `Cin` = 'jhg78d', `Date_Recrutement` = '2016-06-02', `Date_Naissance` = '2016-06-09' WHERE `employe`.`Id_Employe` = 2;
         */
         String query = " UPDATE `gestionprocessus`.`employe` SET `id_profile` = '"+id_profile+"', `Nom` = '"+nom+
                 "', `Prenom` = '"+prenom+"', `Cin` = '"+cin+"', `Date_Recrutement` = '"+date_recrutement+"', `Date_Naissance` = '"+date_naissance+
                 "' WHERE `employe`.`Id_Employe` = '"+id_employe+"';";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteEmploye(String id_employe)
     {
          String query ="delete from  Employe  where Id_Employe ="+id_employe+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
     /////////////////////////////////RECLAMATION ///////////////////////////////////////////////////////////////
      public String[] getReclamationIds()
     {
         String[] ids= new String[1];
         try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Reclamation");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          ids = new String[count] ;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select Id_Reclamation from Reclamation");
            int i = 0;
            while (rs.next()) 
            {
                ids[i] = rs.getString("Id_Reclamation");
                i++;

            }
            } catch (SQLException e ) 
            {
                System.out.println(e);
            } 
              finally 
              {
                if (st != null) 
                { 
                    try 
                    {
                            st.close();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                 return ids;
             }
     public ReclamationModel[] getReclamationlist()
    {
     ReclamationModel[] t= new ReclamationModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Reclamation");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ReclamationModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Reclamation");
        ReclamationModel reclamation;
        int i = 0;
        while (rs.next()) 
        {
            String id = rs.getString("id_Reclamation");
            String type = rs.getString("Type");
            String description = rs.getString("description");
            String id_employe = rs.getString("Id_Employe");
            String id_activite = rs.getString("Id_Activite");
            String date_reclamation = rs.getString("Date_Reclamation");
            
            System.out.println("Id :"+id+" type : "+type+" description : "+description+" id_employe :   "+id_employe+", id_activite :"+id_activite+", date_reclamation : "+date_reclamation);
            reclamation = new ReclamationModel(id, type, description,id_employe,id_activite,date_reclamation);
            t[i]=reclamation;
            i++;
            reclamation=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addReclamation(String type, String description, String id_employe,String id_activite,String date_reclamation)
     {
         String query ="insert into Reclamation(type,description,id_employe,id_activite,date_reclamation) values('"+type+"','"+description+"','"+id_employe+"','"+id_activite+"','" +date_reclamation+"');";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editReclamation(String id_reclamation,String type, String description, String id_employe,String id_activite,String date_reclamation)
     {
         String query ="update Reclamation set Type = '"+type+"', Description=' "+description+"',Id_Employe='"+id_employe+"',Id_Activite='"+id_activite+"',Date_Reclamation='"+date_reclamation+" where Id_Reclamation = "+id_reclamation+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteReclamation(String id_reclamation)
     {
          String query ="delete from  Reclamation  where Id_Reclamation ="+id_reclamation+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
     ////Suivie////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     public String[] getProcessusIds()
     {
         String[] ids= new String[1];
         try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Processus");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          ids = new String[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select id_processus from Processus");
        int i = 0;
        while (rs.next()) 
        {
            ids[i] = rs.getString("id_processus");
            i++;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         return ids;
     }
    
     // PROCESSUS
     
      public ProcessusModel[] getProcessuslist()
 {
     ProcessusModel[] t= new ProcessusModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Processus");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ProcessusModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Processus");
        ProcessusModel Proc;
        int i = 0;
        while (rs.next()) 
        {
            String id = rs.getString("id_processus");
            String libelle = rs.getString("libelle");
            String description = rs.getString("description");
            String exigence = rs.getString("id_exigence");
            String duree =rs.getString("duree");
            //System.out.println("Id :"+id+" Libelle : "+libelle+" Description : "+description+" Exigence : "+exigence+" Duree :"+duree);
            Proc = new ProcessusModel(id, libelle,description,exigence,duree);
            t[i]=Proc;
            i++;
            Proc=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addProcessus(String lib,String des,String idexig,String duree)
     {
         String sql ="insert into processus(Libelle,Description,Id_Exigence,Duree) values('"+lib+"','"+des+"','"+idexig+"','"+duree+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editProcessus(String id,String lib,String des,String idexig,String duree)
     {
         String sql ="update Processus set Libelle ='"+lib+"', Description='"+des+"',Id_Exigence='"+idexig+"', Duree='"+duree+"' where Id_Processus = "+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteProcessus(String id)
     {
          String sql ="delete from  Processus  where Id_Processus ="+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
   
     }
     //-------------------------------Activité-------------------------
     
     public ActiviteModel[] getActivitelist(String Id_proc)
    {
     ActiviteModel[] t= new ActiviteModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Activite where id_processus = "+Id_proc);
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ActiviteModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Activite where Id_Processus="+Id_proc);
        ActiviteModel Acti;
        int i = 0;
        while (rs.next()) 
        {
            String id = rs.getString("id_Activite");
            String libelle = rs.getString("libelle");
            String description = rs.getString("description");
            String duree =rs.getString("duree");
            String etat =rs.getString("Etat");
            Acti = new ActiviteModel(id,libelle,description,duree,etat,Id_proc);
            t[i]=Acti;
            i++;
            Acti=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public ActiviteModel[] getActivitelist()
    {
     ActiviteModel[] t= new ActiviteModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Activite ");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ActiviteModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Activite");
        ActiviteModel Acti;
        int i = 0;
        while (rs.next()) 
        {
            
            String id = rs.getString("id_Activite");
            String libelle = rs.getString("libelle");
            String description = rs.getString("description");
            String duree =rs.getString("duree");
            String etat =rs.getString("Etat");
            String Id_proc = rs.getString("Etat");
            Acti = new ActiviteModel(id,libelle,description,duree,etat,Id_proc);
            t[i]=Acti;
            i++;
            Acti=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     
     public void addActivite(String lib,String des,String duree,String etat,String idpro)
     {
         String sql ="insert into Activite(Libelle,Description,Duree,Etat,Id_Processus) values('"+lib+"','"+des+"','"+duree+"','"+etat+"','"+idpro+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editActivite(String id,String lib,String des,String duree,String etat)
     {
        String sql ="update Activite set Libelle ='"+lib+"', Description='"+des+"', Duree='"+duree+"', Etat='"+etat+"' where Id_Activite ="+id+";";

     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteActivite(String id)
     {
          String sql ="delete from Activite where Id_Activite ="+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
   
     }
     ////////////////////   ACTION   /////////////////////////////////////////
    public ActionModel[] getActionlist()
    {
     ActionModel[] t= new ActionModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM action");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ActionModel[count] ;
          st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from action");
          ActionModel action;
          int i = 0;
          while (rs.next()) 
          {
            String id_action = rs.getString("id_action");
            String libelle = rs.getString("libelle");
            String Description = rs.getString("Description");
            String id_Anomalie = rs.getString("id_Anomalie");
            String Etat = rs.getString("Etat");
            String efficacite = rs.getString("efficacite");
            String Date_Realisation = rs.getString("Date_Realisation");
            String Categorie = rs.getString("Categorie");
            String Date_Prevus = rs.getString("Date_Prevus");
            String cout = rs.getString("cout");
            
            System.out.println("id_action :"+id_action+" ,libelle : "+libelle+" ,Description : "+Description+" ,id_Anomalie : "+id_Anomalie+" ,Etat : "+Etat+" ,efficacite : "+efficacite
            +" ,Date_Realisation : "+Date_Realisation+" ,Categorie : "+Categorie+" ,Date_Prevus : "+Date_Prevus+" ,cout : "+cout);
            action = new ActionModel(id_action, libelle, Description,id_Anomalie,Etat,efficacite,Date_Realisation,Categorie,Date_Prevus,cout);
            t[i]=action;
            i++;
            action=null;
            
        }
    } catch (SQLException e ) 
    {
        System.out.println(e);
    } 
      finally 
      {
        if (st != null) 
        { 
            try 
            {
                    st.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addAction(String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
     {
        String query = "INSERT INTO `gestionprocessus`.`action` ( `libelle`, `Description`, `id_Anomalie`, `Etat`, `Efficacite`, `Date_Realisation`, `Categorie`, `Date_Prevus`, `cout`)"
                + " VALUES ( '"+ libelle+"', '"+Description+"', '"+id_Anomalie+"', '"+Etat+"', '"+efficacite+"', '"+Date_Realisation+"', '"+Categorie+"', '"+Date_Prevus+"', '"+cout+"');";
        // String query = "insert into Action values('labelle','labelle',1,1,1,'2019-09-02','cat','2019-09-02',34.7)";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         System.out.println("ERREUR");
         System.out.println(ex.getMessage());
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("ERREUR");
     }
         
     }
     public void editAction(String id_action,String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
     {
         //ERREUR REQUET
         //query = "UPDATE action set Description ='"+Description+"',id_Anomalie='"+id_Anomalie+"', Date_Realisation='"+Date_Realisation +"', Categorie = '"+Categorie+"' , Date_Prevus='"+Date_Prevus+"',cout= "+cout +",Etat= "+Etat +",efficacite= "+efficacite+"WHWRE Id_Action= "+id_action ;
        String query = "UPDATE `gestionprocessus`.`action` SET `libelle` = '"+libelle+ 
                "',`Description`='"+Description+"' ,`id_Anomalie` = '"+id_Anomalie+"', `Etat` = '"+Etat+
                "', `Efficacite` = '"+efficacite+"', `Date_Realisation` = '"+Date_Realisation+"', `Categorie` = '"+
                Categorie+"', `Date_Prevus` = '"+Date_Prevus+"', `cout` = '"+cout
                +"' WHERE `action`.`Id_Action` = "+id_action+";";
        
        System.out.println("id_action :"+id_action+" ,libelle : "+libelle+" ,Description : "+Description+" ,id_Anomalie : "+id_Anomalie+" ,Etat : "+Etat+" ,efficacite : "+efficacite
            +" ,Date_Realisation : "+Date_Realisation+" ,Categorie : "+Categorie+" ,Date_Prevus : "+Date_Prevus+" ,cout : "+cout);
    try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteAction(String id_action)
     {
          String query ="delete from  Action  where id_action ="+id_action+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(query);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
     ////////////////////////////////////////////////////////////////////////////
}
