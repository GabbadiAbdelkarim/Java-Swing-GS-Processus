/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controller3;
import model.model3.*;


/**
 *
 * @author ibrahim
 */
public class ActiviteController {
     private ActiviteModel Activite;
     private ActiviteModel[] table_activite;
   public ActiviteController()
   {
      Activite = new ActiviteModel();
      table_activite = Activite();
   }
   public ActiviteModel[] Activite()
   {
       return Activite.getActivite();
   }
   public ActiviteModel[] Activite(String id)
   {
       return Activite.getActivite(id);
   }
  
   public String[] getprocessus()
   {
       return Activite.getProcessus();
   }
   public void addActivite(String lib,String des,String duree,String etat,String idpro)
   {
        Activite = new ActiviteModel(lib,des,duree,etat,idpro);
        Activite.addActivite();
   }
   public void deleteActivite(String id)
   {
       Activite = new ActiviteModel(id);
       Activite.deleteActivite();
   }
   public void EditActivite(String id,String lib,String des,String duree,String etat)
   {
        Activite = new ActiviteModel(id,lib,des,duree,etat);
        Activite.updateActivite();
   }
   public String getId(String libelle)
   {
       
       for(int i=0;i<table_activite.length;i++)
       {
           if(libelle.equalsIgnoreCase(table_activite[i].Libelle))
           {
               return table_activite[i].Id_Activite;
           }
       }
       return "";
   }
    public String getlibelle(String id)
   {
       
       for(int i=0;i<table_activite.length;i++)
       {
           if(id.equalsIgnoreCase(table_activite[i].Id_Activite))
           {
               return table_activite[i].Libelle;
           }
       }
       return "";
   }
}
