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
public class EmployeModel {
    
    public String id_employe;
    public String id_profile;
    public String nom;
    public String prenom;
    public String cin;
    public String date_recrutement;
    public String date_naissance;
    private DBConnection db;
    
     public EmployeModel()
    {
        db = new DBConnection();
    }
      public EmployeModel(String id_employe, String id_profile, String nom, String prenom,String cin,String date_recrutement,String date_naissance)
    {
        this.id_employe = id_employe;
        this.id_profile = id_profile;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.date_recrutement = date_recrutement;
        this.date_naissance = date_naissance;
        db = new DBConnection();
    }
    public EmployeModel(String id_employe)
    {
        this.id_employe = id_employe;
        db = new DBConnection();
    }
    public EmployeModel( String id_profile, String nom, String prenom,String cin,String date_recrutement,String date_naissance)
    {
        this.id_profile = id_profile;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.date_recrutement = date_recrutement;
        this.date_naissance = date_naissance;
        db = new DBConnection();
    }
     public EmployeModel[] getEmploye()
    {
        return db.getEmployelist();
    }
     public void deleteEmploye()
    {
        db.deleteEmploye(id_employe);
    }
    public void updateEmploye()
    {
        db.editEmploye(id_employe,id_profile,nom,prenom,cin,date_recrutement,date_naissance);
    }
   public  void addEmploye()
   {
       db.addEmploye(id_profile,nom,prenom,cin,date_recrutement,date_naissance);
   }
}
