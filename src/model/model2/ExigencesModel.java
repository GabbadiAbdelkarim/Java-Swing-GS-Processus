/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model2;

import model.persistence.BDConnection;

/**
 *
 * @author AnasEl
 */
public class ExigencesModel {
    
    public String Id_Exigence;
    public String Libelle;
    public String Description;
    private BDConnection db;
    
    
    public ExigencesModel()
    {
        db = new BDConnection();
    }
    public ExigencesModel(String id, String lib,String des)
    {
        Id_Exigence = id;
        Libelle=lib;
        Description=des;
        db = new BDConnection();
    }
    public ExigencesModel(String id)
    {
        Id_Exigence = id;
        db = new BDConnection();
    }
    public ExigencesModel( String lib,String des)
    {
        Libelle=lib;
        Description=des;
        db = new BDConnection();
    }
    public ExigencesModel[] getExigence()
    {
        return db.getexigencelist();
    }
    public void deleteExigence()
    {
        db.deleteExigence(Id_Exigence);
    }
    public void updateExigence()
    {
        db.editExigence(Id_Exigence, Libelle, Description);
    }
   public  void addExigence()
   {
       db.addExigence(Libelle, Description);
   }
   
   
}
