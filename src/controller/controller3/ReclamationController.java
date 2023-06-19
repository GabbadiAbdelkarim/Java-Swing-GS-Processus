/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.controller3;
import model.model3.*;
/**
 *
 * @author Chaimae
 */
public class ReclamationController {
    private ReclamationModel reclamation;
    private ReclamationModel[] table_reclamation;
    
    public ReclamationController()
    {
       reclamation = new ReclamationModel();
       table_reclamation = reclamations();
    }
     public ReclamationModel[] reclamations()
   {
       return reclamation.getReclamation();
   }
      public void addReclamation(String type,String description,String id_employe,String id_activite,String date_reclamation)
   {
        reclamation = new ReclamationModel( type, description,id_employe,id_activite,date_reclamation);
        reclamation.addAnomalie();
   }
   public void deleteReclamation(String id)
   {
       reclamation = new ReclamationModel(id);
       reclamation.deleteReclamation();
   }
   public void EditReclamation(String id_reclamation,String type,String description,String id_employe,String id_activite,String date_reclamation)
   {
        reclamation = new ReclamationModel(id_reclamation,type, description,id_employe,id_activite,date_reclamation);
        reclamation.updateAnomalie();
   }
}
