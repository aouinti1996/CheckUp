/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Connection.MyConnection;
import Entité.Evenement;
import Service.EvenementService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lotfi
 */
public class Gestioneven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
            Evenement e1 = new Evenement( 1,"aaaaaaa","02-08-2221", "tres dangereux");
            Evenement e2 = new Evenement( 2,"bbbbbb","03-06-2009", "dangereux");
            Evenement e3 = new Evenement( 3,"saratan","03-05-1990", "dangereux");
            Evenement e4 = new Evenement( 4,"sida","03-08-1999", "dangereux");
            
            EvenementService es = new EvenementService();
            es.ajouterEvenement(e1);
           es.ajouterEvenement(e2);
           es.ajouterEvenement(e3);
           es.ajouterEvenement(e4);
           es.supprimerEvenement(2);
           e2.setIdeven(3);
           e2.setDateeven("30-07-2015");
           e2.setDescriptioneven("cette malade est tres dangereux et mortal");
           es.modifierEvenement(e2);
             es.afficherEvenement();
        
        
        
        
        
        
        
        
        
    }
    
}
