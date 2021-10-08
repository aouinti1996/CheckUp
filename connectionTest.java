/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectiontest;

import Myconnection.MyConnection;
import formulaireServices.formulaireServices;
import java.sql.SQLException;
import projetpidev.formulaire;



/**
 *
 * @author LENOVO
 */
public class connectionTest {
     public static void main(String[] args) throws SQLException{
         MyConnection mc= MyConnection.getInstance();
         formulaire f1 =new formulaire(55,"nakbi","yassine","15/09/1996","monastir",225852);
       formulaireServices fo= new formulaireServices();
       //fo.ajouterFormulaire(f1);
       //fo.supprimerFormulaire(3);
       fo.modifierFormulaire(55, "hasan", "bagh", "13/10/22", "tunis", 20589741);
        fo.rechercherFormulaire(55);
                 }
}
