/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Connection.MyConnection;
import Entité.Evenement;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author lotfi
 */
public class EvenementService {
    public Connection cnx;
public PreparedStatement ste;
    public EvenementService() {  
        cnx = MyConnection.getInstance().getConnection();
        
    }
    
    public void ajouterEvenement(Evenement e){
        try {
            String sql = "insert into evenement(nomeven,dateeven,descriptioneven)"+"values(?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setString(1, e.getNomeven());
            ste.setString(2, e.getDateeven());
            ste.setString(3, e.getDescriptioneven());
            ste.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Evenement non ajoutée !!");
        System.out.println(ex.getMessage());
    }
    }
    
    
    
    public void supprimerEvenement(int ideven){
    try {
        String sql = "DELETE FROM evenement WHERE ideven=?" ;
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, ideven);
        ste.executeUpdate();
        System.out.println("evenement supprimer");
        } catch (SQLException ex) {
            System.out.println("echec de la suppression!!");
            System.err.println(ex.getMessage());
        
    } 
    
    }
    public void modifierEvenement(Evenement e){
    try {
        String sql = "UPDATE evenement SET dateeven = ?, descriptioneven = ?  WHERE ideven=? " ;
        ste=cnx.prepareStatement(sql);
        ste.setString(2,e.getDescriptioneven());
        ste.setString(1, e.getDateeven());
        ste.setInt(3, e.getIdeven());
        ste.executeUpdate();
        System.out.println("evenement modifier");
        } catch (SQLException ex) {
          System.out.println("Updated failed !!!");
          System.err.println(ex.getMessage());
        }
    } 
    public void afficherEvenement() {
    try {
        List<Evenement>evenements=new ArrayList<>();
        String sql ="Select * from evenement";
        ste = cnx.prepareCall(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        Evenement e = new Evenement();
        while(rs.next()){
            e.setIdeven(rs.getInt("ideven"));
            e.setNomeven(rs.getString("nomeven"));
            e.setDateeven(rs.getString("dateeven"));
            e.setDescriptioneven(rs.getString("descriptioneven"));
            evenements.add(e);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
        
    }
   
}
