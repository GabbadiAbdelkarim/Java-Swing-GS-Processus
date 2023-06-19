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
public class ActionController {
    private ActionModel action;
    private ActionModel[] table_action;
    
    public ActionController()
    {
       action = new ActionModel();
       table_action = actions();
    }
    public ActionModel[] actions()
    {
        return action.getAction();
    }
     public void addAction(String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
    {
         action = new ActionModel(libelle, Description, id_Anomalie, Etat, efficacite, Date_Realisation, Categorie, Date_Prevus, cout);
         action.addAction();
    }
      public void deleteAction(String id)
   {
       action = new ActionModel(id);
       action.deleteAction();
   }
      
   public void EditAction(String id_action , String libelle, String Description, String id_Anomalie, String Etat, String efficacite, String Date_Realisation, String Categorie, String Date_Prevus, String cout) 
    {
        action = new ActionModel(id_action, libelle, Description, id_Anomalie, Etat, efficacite, Date_Realisation, Categorie, Date_Prevus, cout);
         action.updateAction();
   }
   public String getId(String libelle)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(libelle.equalsIgnoreCase(table_action[i].libelle))
           {
               return table_action[i].id_Action;
           }
       }
       return "";
   }
   public String getlibelle(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].libelle;
           }
       }
       return "";
   }
   public String getdescription(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].Description;
           }
       }
       return "";
   }
    public String getCategorie(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].Categorie;
           }
       }
       return "";
   }
     public String getdateprevus(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].Date_Prevus;
           }
       }
       return "";
   }
      public String getdaterealisation(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].Date_Realisation;
           }
       }
       return "";
   }
       public String getCout(String id)
   {
       
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].cout;
           }
       }
       return "";
   }
    public String getAnomalie(String id)
   {
       for(int i=0;i<table_action.length;i++)
       {
           if(id.equalsIgnoreCase(table_action[i].id_Action))
           {
               return table_action[i].id_Anomalie;
           }
       }
       return "";
   }
}
