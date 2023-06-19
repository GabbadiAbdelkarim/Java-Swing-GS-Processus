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
public class AnomalieController {
    private AnomalieModel anomalie;
    private AnomalieModel[] table_anomalie;
    
     public AnomalieController()
   {
      anomalie = new AnomalieModel();
      table_anomalie = anomalies();
   }
    public AnomalieModel[] anomalies()
   {
       return anomalie.getAnomalie();
   }
    public void addAnomalie(String lib,String Detaille,String duree,String id_processus)
   {
        anomalie = new AnomalieModel(lib,Detaille,duree,id_processus);
        anomalie.addAnomalie();
   }
   public void deleteAnomalie(String id)
   {
       anomalie = new AnomalieModel(id);
       anomalie.deleteAnomalie();
   }
   public void EditAnomalie(String id ,String lib,String Detaille,String duree,String id_processus)
   {
        anomalie = new AnomalieModel(id,lib,Detaille,duree,id_processus);
        anomalie.updateAnomalie();
   }
   public String getlibelle(String id)
   {
       
       for(int i=0;i<table_anomalie.length;i++)
       {
           if(id.equalsIgnoreCase(table_anomalie[i].Id_Anomalie))
           {
               return table_anomalie[i].Libelle;
           }
       }
       return "";
   }
    public String getId(String libelle)
   {
       
       for(int i=0;i<table_anomalie.length;i++)
       {
           if(libelle.equalsIgnoreCase(table_anomalie[i].Libelle))
           {
               return table_anomalie[i].Id_Anomalie;
           }
       }
       return "";
   }
   public String getdetail(String id)
   {
       for(int i=0;i<table_anomalie.length;i++)
       {
           if(id.equalsIgnoreCase(table_anomalie[i].Id_Anomalie))
           {
               return table_anomalie[i].Detaille;
           }
       }
       return "";
   }
    public String getduree(String id)
   {
       for(int i=0;i<table_anomalie.length;i++)
       {
           if(id.equalsIgnoreCase(table_anomalie[i].Id_Anomalie))
           {
               return table_anomalie[i].duree;
           }
       }
       return "";
   }
    public String getprocessus(String id)
   {
       for(int i=0;i<table_anomalie.length;i++)
       {
           if(id.equalsIgnoreCase(table_anomalie[i].Id_Anomalie))
           {
               return table_anomalie[i].Id_Processus;
           }
       }
       return "";
   }
}
