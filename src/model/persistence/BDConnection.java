package model.persistence;
import model.model2.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BDConnection 
{
 public Connection con;
 private Statement st;
 private ResultSet rs;
 
 
 public BDConnection()
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
 //// Exigence 
 public ExigencesModel[] getexigencelist()
 {
     ExigencesModel[] t= new ExigencesModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Exigence");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new ExigencesModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Exigence");
        ExigencesModel exi;
        int i = 0;
        while (rs.next()) 
        {
            String id = rs.getString("id_exigence");
            String libelle = rs.getString("libelle");
            String description = rs.getString("description");
            System.out.println("Id :"+id+" Libelle : "+libelle+" Description : "+description);
            exi = new ExigencesModel(id, libelle, description);
            t[i]=exi;
            i++;
            exi=null;
            
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addExigence(String lib,String des)
     {
         String sql ="insert into Exigence(Libelle,Description) values('"+lib+"','"+des+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editExigence(String id,String lib,String des)
     {
         String sql ="update Exigence set Libelle = '"+lib+"', Description=' "+des+"' where Id_Exigence = "+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteExigence(String id)
     {
          String sql ="delete from  Exigence  where Id_Exigence ="+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
     ////Suivie
     public SuivieModel[] geteSuivielist()
 {
     SuivieModel[] t= new SuivieModel[1];
      try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Suivie");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          t = new SuivieModel[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Suivie");
        SuivieModel exi;
        int i = 0;
        while (rs.next()) 
        {
            String ids = rs.getString("id_suivie");
            String idp = rs.getString("id_processus");
            String ide = rs.getString("id_employe");
            String rr = rs.getString("rapport");
           // System.out.println("Id :"+id+" Libelle : "+libelle+" Description : "+description);
            exi = new SuivieModel(ids, idp, ide,rr);
            t[i]=exi;
            i++;
            exi=null;
            
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      return t;
            
 }
     public void addSuivie(String idp,String ide,String r)
     {
         String sql ="insert into Suivie(id_processus,id_employe,rapport) values('"+idp+"','"+ide+"','"+r+"'); ";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void editSuvie(String ids,String idp,String ide,String r)
     {
         String sql ="update Suivie set id_processus = '"+idp+"', id_employe=' "+ide+"', rapport ='"+r+"' where Id_Suivie = "+ids+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteuivie(String id)
     {
          String sql ="delete from  Suivie  where Id_Suivie ="+id+";";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();;
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     
     }
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         return ids;
     }
     public String[] getEmployeIds()
     {
         String[] ids= new String[1];
         try {
          
          Statement s = con.createStatement();
          ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Employe");
          r.next();
          int count = r.getInt("rowcount");
          r.close();
          s.close();
          ids = new String[count] ;
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Employe");
        int i = 0;
        while (rs.next()) 
        {
            ids[i] = rs.getString("id_Employe");
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         return ids;
     }
     
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     public void deleteActivite(String id)
     {
          String sql ="delete from Activite where Id_Activite ='"+id+"';";
     try 
     {
         st=  con.createStatement();
         st.executeUpdate(sql);
         st.close();
     } 
     catch (SQLException ex) 
     {
         Logger.getLogger(BDConnection.class.getName()).log(Level.SEVERE, null, ex);
     }
   
     }
}
