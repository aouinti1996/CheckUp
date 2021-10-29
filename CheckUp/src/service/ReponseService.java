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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reclamation.Reponse;
/**
 *
 * @author houss
 */
public class ReponseService {
      public Connection cnx;
public PreparedStatement ste;
public PreparedStatement ste2;
    public ReponseService() {  
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterReponse(Reponse p, int id_rec){
    try {
        String sql = "insert into reponse(text)"+"values(?)";
        String sql2 = "update reclamation set status = 'traité' and id_reponse = ? where reclamation.id = ?";
        ste=cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ste2=cnx.prepareStatement(sql2);
        ste.setString(1, p.getText());
          
        
        ste.executeUpdate();
      try (ResultSet generatedKeys = ste.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                System.out.println((generatedKeys.getLong(1)));
            }
            else {
                throw new SQLException("Creating reponse failed, no ID obtained.");
            }
        }
       
        ste2.setInt(1,p.getId());
        ste2.setInt(2, id_rec);
        ste2.executeUpdate();
        System.out.println("Reponse added");
    } catch (SQLException ex) {
        System.out.println("rani manajamtech n7ot fel base");
                
        System.out.println(ex.getMessage());
    }
    
    }
    /*public List<Reponse> afficherReponse() {
    
        List<Reponse> myList = new ArrayList<Reponse>();
     try {   
        String sql ="Select * from reponse";
        ste = cnx.prepareStatement(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        while(rs.next())
        {Reponse p = new Reponse();
         p.setId_ref_reclamation(rs.getInt(1));
         p.setText(rs.getString(2));
         myList.add(p);
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return myList;
        
    }*/
    public void deleteReponse(int id ){
    try {
        String sql = "DELETE FROM reponse WHERE id=? ;";
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, id);
        ste.executeUpdate();
        System.out.println("reclamation deleted");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
     public void updateReponse(Reponse p){
    try {
        String sql = "UPDATE reponsse SET  text=?  WHERE id=?";
  
        ste=cnx.prepareStatement(sql);
        ste.setString(1, p.getText());

       
        ste.executeUpdate();
        System.out.println("reclamation updeted");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
}
