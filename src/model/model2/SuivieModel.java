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
public class SuivieModel {
    
    public String ID_Suivie;
    public String ID_Processus;
    public String ID_Employe;
    public String Rapport;
    
    private BDConnection db ;
    public SuivieModel()
    {
        db = new BDConnection();
    }
    public SuivieModel(String ids,String idp,String ide,String r)
    {
        ID_Suivie = ids;
        ID_Processus=  idp;
        ID_Employe = ide;
        Rapport = r;
        db = new BDConnection();
    }
    public void addSuivie()
    {
     db.addSuivie(ID_Processus, ID_Employe, Rapport);
        
    }
    public void updateSuivie()
    {
        db.editSuvie(ID_Suivie, ID_Processus, ID_Employe, Rapport);
        
    }
    public void deleteSuivie()
    {
        db.deleteuivie(ID_Suivie);
    }
    public SuivieModel[] getSuivie()
    {
        return db.geteSuivielist();
    }
    public String[] getpids()
    {
        return db.getProcessusIds();
    }
    public String[] geteids()
    {
        return db.getEmployeIds();
    }
}
