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
public class EmployeController {
    private EmployeModel employe;
    private EmployeModel[] table_employe;
    public EmployeController()
   {
      employe = new EmployeModel();
      table_employe = employes();
   }
    public EmployeModel[] employes()
   {
       return employe.getEmploye();
   }
    public String getlibelle(String id)
   {
       
       for(int i=0;i<table_employe.length;i++)
       {
           if(id.equalsIgnoreCase(table_employe[i].id_employe))
           {
               return table_employe[i].nom;
           }
       }
       return "";
   }
    public String getId(String nom)
   {
       
       for(int i=0;i<table_employe.length;i++)
       {
           if(nom.equalsIgnoreCase(table_employe[i].nom))
           {
                System.out.println("///////////"+table_employe[i].id_employe+table_employe[i].nom+"///////////");
               return table_employe[i].id_employe;
               
           }
       }
       return "";
   }
}
