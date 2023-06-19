/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model3;
import model.persistence.*;

/**
 *
 * @author ibrahim
 */
public class ProcessusModel {
     public String Id_Processus;
    public String Libelle;
    public String Description;
    public String Id_exigence;
    public String Duree;
    private DBConnection db;
    
    
    public ProcessusModel()
    {
        db = new DBConnection();
    }
    public ProcessusModel(String id, String lib,String des,String exig,String duree)
    {
        Id_Processus = id;
        Libelle=lib;
        Description=des;
        Id_exigence =exig;
        Duree=duree;
        db = new DBConnection();
    }
    public ProcessusModel(String id)
    {
        Id_Processus = id;
        db = new DBConnection();
    }
    public ProcessusModel( String lib,String des,String exig,String duree)
    {
        Libelle=lib;
        Description=des;
        Id_exigence =exig;
        Duree=duree;
        db = new DBConnection();
    }
    public ProcessusModel[] getProcessus()
    {
        return db.getProcessuslist();
    }
    public void deleteProcesus()
    {
        db.deleteProcessus(Id_Processus);
    }
    public void updateProcessus()
    {
        db.editProcessus(Id_Processus, Libelle, Description,Id_exigence,Duree);
    }
   public  void addProcessus()
   {
       db.addProcessus(Libelle, Description,Id_exigence,Duree);
   }

   
   
}
