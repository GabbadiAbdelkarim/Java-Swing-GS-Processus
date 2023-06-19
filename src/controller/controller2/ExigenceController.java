/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controller2;

import model.model2.*;

/**
 *
 * @author AnasEl
 */
public class ExigenceController 
{
    private ExigencesModel exigence;
    private ExigencesModel[] exitable;
    
   public ExigenceController()
   {
      exigence = new ExigencesModel();
      exitable = exigences();
   }
   public ExigencesModel[] exigences()
   {
       return exigence.getExigence();
   }
   public void addExigence(String lib,String des)
   {
        exigence = new ExigencesModel(lib,des);
        exigence.addExigence();
   }
   public void deleteExigence(String id)
   {
       exigence = new ExigencesModel(id);
       exigence.deleteExigence();
   }
   public void EditExigence(String id,String lib,String des)
   {
        exigence = new ExigencesModel(id,lib,des);
        exigence.updateExigence();
   }
   public String getlibelle(String id)
   {
       
       for(int i=0;i<exitable.length;i++)
       {
           if(id.equalsIgnoreCase(exitable[i].Id_Exigence))
           {
               return exitable[i].Libelle;
           }
       }
       return "";
   }
   public String getdescription(String id)
   {
       for(int i=0;i<exitable.length;i++)
       {
           if(id.equalsIgnoreCase(exitable[i].Id_Exigence))
           {
               return exitable[i].Description;
           }
       }
       return "";
   }
}
