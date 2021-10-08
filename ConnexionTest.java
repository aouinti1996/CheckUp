
package Edu.esprit.tests;

import Edu.esprit.entities.Medecin;
import Edu.esprit.services.GestionMedecin;
import Edu.esprit.tools.MyConnection;


public class ConnexionTest {
    public static void main(String[] args) {
        MyConnection mc= MyConnection.getInstance();
        GestionMedecin per = new GestionMedecin();
        Medecin m1 = new Medecin(14,"Foulen","Ben foulen","dentiste");
         Medecin m2 = new Medecin(1,"douiri","arwa","generaliste");
         per.ajouterMedecin(m1);
         per.ajouterMedecin(m2);
         per.supprimerMedecin(1);
        
         m2.setId(2);
            m2.setNom("mabrouk");
            m2.setSpecialite("biologiste");
            per.modifierMedecin(m2);
        System.out.println(per.afficherMedecin()); 
    }
    
}
