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
public class ReclamationModel {
    
    public String id_reclamation;
    public String type;
    public String description;
    public String id_employe ;
    public String id_activite;
    public String date_reclamation;
    private DBConnection db;
     public ReclamationModel()
    {
        db = new DBConnection();
    }
    public ReclamationModel(String id_reclamation, String type, String description, String id_employe,String id_activite,String date_reclamation)
    {
        this.id_reclamation = id_reclamation;
        this.type = type;
        this.description = description;
        this.id_employe = id_employe;
        this.id_activite = id_activite;
        this.date_reclamation = date_reclamation;
        db = new DBConnection();
    }
    public ReclamationModel(String id_reclamation)
    {
        this.id_reclamation = id_reclamation;
        db = new DBConnection();
    }
     public ReclamationModel( String type,String description,String id_employe,String id_activite,String date_reclamation)
    {
        this.type = type;
        this.description = description;
        this.id_employe = id_employe;
        this.id_activite = id_activite;
        this.date_reclamation = date_reclamation;
        db = new DBConnection();
    }
     public ReclamationModel[] getReclamation()
    {
        return db.getReclamationlist();
    }
     public void deleteReclamation()
    {
        db.deleteReclamation(id_reclamation);
    }
    public void updateAnomalie()
    {
        db.editReclamation(id_reclamation, type, description,id_employe,id_activite,date_reclamation);
    }
   public  void addAnomalie()
   {
       db.addReclamation( type, description,id_employe,id_activite,date_reclamation);
   }
}
