/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkup;

import Connection.MyConnection;
import reclamation.Reclamation;
import service.ReclamationService;

/**
 *
 * @author houss
 */
public class CheckUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            MyConnection mc = MyConnection.getInstance();
            Reclamation p1 = new Reclamation( 1,"houssem123", "i have problem ", "ajajgajzf,a;zdd");
            Reclamation p2 = new Reclamation( 2,"sief1", "i have problem ", "aazertyujhgfd");
            Reclamation p3 = new Reclamation( 3,"ahmedAZE", "i have problem ", ":;,nbvcxdfgh");
            ReclamationService ps = new ReclamationService();
             
            ps.ajouterReclamation(p1);
            ps.ajouterReclamation(p2);
            ps.ajouterReclamation(p3);
            ps.deleteReclamation(42);
            p3.setId(57);
            p3.setDescription("houssem is akfnfvakneva;,zval,a");
            p3.setObject("balbalbalbalbadl");
            ps.updateReclamation(p3);
            System.out.println(ps.afficherReclamation());
            
           
    }
    
}
