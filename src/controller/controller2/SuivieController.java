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
public class SuivieController {
     private SuivieModel suivie;
    private SuivieModel[] suivietable;
    
   public SuivieController()
   {
      suivie = new SuivieModel();
      suivietable = suivies();
   }
   public SuivieModel[] suivies()
   {
       return suivie.getSuivie();
   }
   public void addSuivie(String idp,String ide,String r)
   {
         suivie = new SuivieModel("",idp,ide,r);
         suivie.addSuivie();
   }
   public void deleteSuivie(String id)
   {
        suivie = new SuivieModel(id,"","","");
        suivie.deleteSuivie();
   }
   public void EditSuivie(String ids,String idp,String ide,String r)
   {
        suivie = new SuivieModel(ids,idp,ide,r);
        suivie.updateSuivie();
   }
   public String getIdProcessus(String id)
   {
       
       for(int i=0;i<suivietable.length;i++)
       {
           if(id.equalsIgnoreCase(suivietable[i].ID_Suivie))
           {
               return suivietable[i].ID_Processus;
           }
       }
       return "";
   }
   public String getIdEmploye(String id)
   {
       for(int i=0;i<suivietable.length;i++)
       {
           if(id.equalsIgnoreCase(suivietable[i].ID_Suivie))
           {
               return suivietable[i].ID_Employe;
           }
       }
       return "";
   }
   public String getRapport(String id)
   {
       for(int i=0;i<suivietable.length;i++)
       {
           if(id.equalsIgnoreCase(suivietable[i].ID_Suivie))
           {
               return suivietable[i].Rapport;
           }
       }
       return "";
   }
   public String[] getProcessusids()
   {
       return suivie.getpids();
   }
   public String[] getEployeids()
   {
       return suivie.geteids();
   }
}
