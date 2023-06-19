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
public class ProcessusController {
     private ProcessusModel Processus;
    
   public ProcessusController()
   {
      Processus = new ProcessusModel();
   }
   public ProcessusModel[] Processus()
   {
       return Processus.getProcessus();
   }
   public void addProcessus(String lib,String des,String idexig,String duree)
   {
        Processus = new ProcessusModel(lib,des,idexig,duree);
        Processus.addProcessus();
   }
   public void deleteProcessus(String id)
   {
       Processus = new ProcessusModel(id);
       Processus.deleteProcesus();
   }
   public void EditProcessus(String id,String lib,String des,String idexig,String duree)
   {
        Processus = new ProcessusModel(id,lib,des,idexig,duree);
        Processus.updateProcessus();
   }
   public String getlibelle(String id)
   {
       ProcessusModel[] ex = Processus();
       for(int i=0;i<ex.length;i++)
       {
           if(id.equalsIgnoreCase(ex[i].Id_Processus))
           {
               return ex[i].Libelle;
           }
       }
       return "";
   }
   public String getdescription(String id)
   {
       ProcessusModel[] ex = Processus();
       for(int i=0;i<ex.length;i++)
       {
           if(id.equalsIgnoreCase(ex[i].Id_Processus))
           {
               return ex[i].Description;
           }
       }
       return "";
   }
   public String getduree(String id)
   {
       ProcessusModel[] ex = Processus();
       for(int i=0;i<ex.length;i++)
       {
           if(id.equalsIgnoreCase(ex[i].Id_Processus))
           {
               return ex[i].Duree;
           }
       }
       return "";
   }
   public String getexigence(String id)
   {
       ProcessusModel[] ex = Processus();
       for(int i=0;i<ex.length;i++)
       {
           if(id.equalsIgnoreCase(ex[i].Id_Processus))
           {
               return ex[i].Id_exigence;
           }
       }
       return "";
   }
   public ExigencesModel[] exigences()
   {
       return Processus.exigences();
   }
}
