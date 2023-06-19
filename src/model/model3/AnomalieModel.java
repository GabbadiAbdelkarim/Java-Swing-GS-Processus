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
public class AnomalieModel {
    
    public String Id_Anomalie;
    public String Libelle;
    public String Detaille;
    public String Id_Processus;
    public String duree;
    private DBConnection db;
    
    public AnomalieModel()
    {
        db = new DBConnection();
    }
    public AnomalieModel(String Id_Anomalie, String Libelle, String Detaille, String duree, String Id_Processus)
    {
        this.Id_Anomalie = Id_Anomalie;
        this.Libelle = Libelle;
        this.Detaille = Detaille;
        this.Id_Processus = Id_Processus;
        this.duree = duree;
        db = new DBConnection();
    }
    public AnomalieModel(String Id_Anomalie)
    {
        this.Id_Anomalie = Id_Anomalie;
        db = new DBConnection();
    }
     public AnomalieModel( String Libelle,String Detaille ,String duree,String Id_Processus)
    {
        this.Libelle = Libelle;
        this.Detaille = Detaille;
        this.Id_Processus = Id_Processus;
        this.duree = duree;
        db = new DBConnection();
    }
    public AnomalieModel[] getAnomalie()
    {
        return db.getAnomalielist();
    }
     public void deleteAnomalie()
    {
        db.deleteAnomalie(Id_Anomalie);
    }
    public void updateAnomalie()
    {
        db.editAnomalie(Id_Anomalie, Libelle, Detaille, duree,Id_Processus);
    }
   public  void addAnomalie()
   {
       db.addAnomalie(Libelle,  Detaille ,duree, Id_Processus);
   }
}
