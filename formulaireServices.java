/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaireServices;

import Myconnection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetpidev.formulaire;



/**
 *
 * @author LENOVO
 */
public class formulaireServices {
    public Connection cnx;
    private PreparedStatement ste;

    public formulaireServices(){
    cnx = MyConnection.getInstance().getConnection();
}
    public void ajouterFormulaire(formulaire f) throws SQLException{
        String req ="INSERT INTO formulaire (id,nom,prenom,dateNaissance,addresse,numtel "
                + ") "
                 + "VALUES (?,?,?,?,?,?)";
       ste = cnx.prepareStatement(req);
         
             ste.setInt(1,f.getId());
            ste.setString(2, f.getNom());
            ste.setString(3,f.getPrenom());
            ste.setString(4, f.getDateNaissance());
            ste.setString(5, f.getAdresse());
            ste.setInt(6,f.getNumtel());
            ste.executeUpdate();
            System.out.println("formulaire ajoutéé");
         
          
           
        }
            
public void supprimerFormulaire(int id){
try{
String req = "DELETE FROM formulaire WHERE id=? ;";
        ste=cnx.prepareStatement(req);
ste.setInt(1,id);
ste.executeUpdate();

}catch(SQLException ex){
    System.out.println(ex.getMessage());
    }
}
public void modifierFormulaire(int id,String nom,String prenom,String dateNaissance,String addresse , int numtel) throws SQLException{
   try{
    String req = "update formulaire set id='"+id+"',"+"nom='"+nom+"',"+"prenom='"+prenom+"',"+"dateNaissance='"+dateNaissance+"',"+"addresse='"+addresse+"',"+"numtel='"+numtel+"'where id='"+id+"'";
            ste = cnx.prepareStatement(req);
            ste.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(formulaireServices.class.getName()).log(Level.SEVERE, null, ex);
}

}
public void rechercherFormulaire(int id){
        
        try {
            List<formulaire>formulaire = new ArrayList<>();
            ste = cnx.prepareStatement("select * from formulaire where id='"+id+"'");
            formulaire f = new formulaire();
            ResultSet rs = ste.executeQuery();
            while(rs.next()){
                f.setId(id);
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setDateNaissance(rs.getString("dateNaissance"));
                f.setAddresse(rs.getString("addresse"));
                f.setNumtel(rs.getInt("numtel"));
                formulaire.add(f);
            }
            System.out.println(formulaire);
        } catch (SQLException ex) {
            Logger.getLogger(formulaireServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }}
