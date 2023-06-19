/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controller2;

import model.model2.*;

/**
 *
 * @author ibrahim
 */
public class ActiviteController {
     private ActiviteModel Activite;
   public ActiviteController()
   {
      Activite = new ActiviteModel();
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
}
