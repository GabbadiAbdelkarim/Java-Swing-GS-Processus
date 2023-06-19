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
public class ActiviteModel {
    public String Id_Activite;
    public String Libelle;
    public String Description;
    public String Duree;
    public String Etat;
    public String Id_Processus;
    private DBConnection db;
    
    
    public ActiviteModel()
    {
        db = new DBConnection();
    }
    public ActiviteModel(String id, String lib,String des,String duree,String etat,String idpro)
    {
        Id_Activite = id;
        Libelle=lib;
        Description=des;
        Duree=duree;
        Etat=etat;
        Id_Processus =idpro;
        db = new DBConnection();
    }
    public ActiviteModel(String id)
    {
        Id_Activite = id;
        db = new DBConnection();
    }
    public ActiviteModel( String lib,String des,String duree,String etat,String idpro)
    {
        Libelle=lib;
        Description=des;
        Duree=duree;
        Etat=etat;
        Id_Processus =idpro;
        db = new DBConnection();
    }
    public ActiviteModel[] getActivite(String id)
    {
        return db.getActivitelist(id);
    }
   public ActiviteModel[] getActivite()
    {
        return db.getActivitelist();
    }
    public void deleteActivite()
    {
        db.deleteProcessus(Id_Activite);
    }
    public void updateActivite()
    {
        db.editActivite(Id_Activite, Libelle, Description,Duree,Etat);
    }
   public  void addActivite()
   {
       db.addActivite(Libelle, Description,Duree,Etat,Id_Processus);
   }
   
   public String[] getProcessus()
   {
       return db.getProcessusIds();
   }
    
}
