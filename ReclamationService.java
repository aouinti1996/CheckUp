/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import reclamation.Reclamation;

/**
 *
 * @author houss
 */
public class ReclamationService {
    public Connection cnx;
public PreparedStatement ste;
    public ReclamationService() {  
        cnx = MyConnection.getInstance().getConnection();
        
    }
    
    public void ajouterReclamation(Reclamation r){
    try {
        String sql = "insert into reclamation(username , object , description)"+"values(?,?,?)";
        ste=cnx.prepareStatement(sql);
        ste.setString(1, r.getUsername());
        ste.setString(2, r.getObject());
        ste.setString(3, r.getDescription());
        ste.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    public List<Reclamation> afficherReclamation() {
        List<Reclamation>reclamation=new ArrayList<>();
    try {
        
        String sql ="Select * from reclamation";
        ste = cnx.prepareCall(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        Reclamation r = new Reclamation();
        while(rs.next()){
            r.setId(rs.getInt("id"));
            r.setUsername(rs.getString("username"));
            r.setObject(rs.getString("object"));
            r.setDescription(rs.getString("description"));
            reclamation.add(r);
            
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());;
    }
       return reclamation;
    }
public void deleteReclamation(int id ){
    try {
        String sql = "DELETE FROM reclamation WHERE id=? ;";
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, id);
        ste.executeUpdate();
        System.out.println("reclamation deleted");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    public void updateReclamation(Reclamation r){
    try {
        String sql = "UPDATE reclamation SET  object=?, description=? WHERE id=?";
  
        ste=cnx.prepareStatement(sql);
        ste.setInt(3, r.getId());
        ste.setString(1, r.getObject());
        ste.setString(2, r.getDescription());
       
        ste.executeUpdate();
        System.out.println("reclamation updeted");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
 
}    
   

    

