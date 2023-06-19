/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model3;
import model.persistence.*;

/**
 *
 * @author Chaimae
 */
public class ActionModel {
   
    public String id_Action;
    public String libelle;
    public String Description;
    public String id_Anomalie;
    public String Etat;
    public String efficacite;
    public String Date_Realisation;
    public String Categorie;
    public String Date_Prevus;
    public String cout;
    public DBConnection db;
    
    public ActionModel()
    {
        db = new DBConnection();
    }
    
    public ActionModel(String id_Action, String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
    {
        this.id_Action = id_Action;
        this.libelle = libelle;
        this.Description = Description;
        this.id_Anomalie = id_Anomalie;
        this.Etat = Etat;
        this.efficacite = efficacite;
        this.Date_Realisation = Date_Realisation;
        this.Categorie = Categorie;
        this.Date_Prevus = Date_Prevus;
        this.cout = cout;
        db = new DBConnection();
    }
    public ActionModel(String id_Action)
    {
        this.id_Action = id_Action;
        db = new DBConnection();
    }
    public ActionModel(String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
    {
        this.libelle = libelle;
        this.Description = Description;
        this.id_Anomalie = id_Anomalie;
        this.Etat = Etat;
        this.efficacite = efficacite;
        this.Date_Realisation = Date_Realisation;
        this.Categorie = Categorie;
        this.Date_Prevus = Date_Prevus;
        this.cout = cout;
        db = new DBConnection();
    }
    
    public ActionModel[] getAction()
    {
        return db.getActionlist();
    }
    public void deleteAction()
    {
        db.deleteAction(id_Action);
    }
    public void updateAction()
    {
        db.editAction( id_Action, libelle, Description, id_Anomalie, Etat, efficacite, Date_Realisation, Categorie, Date_Prevus, cout);
    }
   public  void addAction()
   {
       db.addAction(libelle, Description, id_Anomalie, Etat, efficacite, Date_Realisation, Categorie, Date_Prevus, cout);
   }
   
   public String[] getAnomaliesIds()
   {
       return db.getAnomaliesIds();
   }
}
