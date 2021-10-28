/*
 * To change this license header, choose License HeaderesultSet in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import reclamation.Reclamation;
import reclamation.User;

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
        String sql = "insert into reclamation(id_user , object , status, description, screenshot, email )"+"values(?,?,?,?,?,?)";
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, r.getUser().getId());
        ste.setString(2, r.getObject());
        ste.setString(3, r.getStatus());
        ste.setString(4, r.getDescription());
        ste.setString(5, r.getScreenshot());
        ste.setString(6, r.getEmail());
        System.out.println(r.toString());
        ste.executeUpdate();
        System.out.println("Reclamation added");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    public List<Reclamation> afficherReclamation() {
    
        List<Reclamation> myList = new ArrayList<Reclamation>();
     try {   
        String sql ="Select * from reclamation,user where reclamation.id_user=user.id";
        ste = cnx.prepareStatement(sql);
        ResultSet resultSet;
        resultSet = ste.executeQuery();
        
        while(resultSet.next())
        {Reclamation R = new Reclamation();
         
         R.setId(resultSet.getInt(1));
         R.setUsername(resultSet.getString(10));
         R.setObject(resultSet.getString(4));
         R.setStatus(resultSet.getString(5));
         R.setDescription(resultSet.getString(6));
         R.setScreenshot("file:C:\\xampp\\htdocs\\CheckUP\\web\\uploads\\images\\" + resultSet.getString(7));
         R.setEmail(resultSet.getString(8));
         myList.add(R);

        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return myList;
        
    }
    public List<Reclamation> afficherReclamationPerUserWithReponse(User user) {
    
        List<Reclamation> myList = new ArrayList<Reclamation>();
        int idUser = user.getId();
        System.out.println("Id user : "+idUser);
     try {   
        String sql ="Select * from reclamation,reponse where reclamation.id_user=? and reclamation.id_reponse = reponse.id"; 
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, idUser);
        ResultSet resultSet;
        resultSet = ste.executeQuery();
        
        while(resultSet.next())
        {Reclamation R = new Reclamation();
         R.setId(resultSet.getInt(1));
         R.setUsername(resultSet.getString(10));
         R.setObject(resultSet.getString(4));
         R.setStatus(resultSet.getString(5));
         R.setDescription(resultSet.getString(6));
         R.setScreenshot("file:C:\\xampp\\htdocs\\CheckUP\\web\\uploads\\images\\" + resultSet.getString(7));
         R.setEmail(resultSet.getString(8));
         myList.add(R);

        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return myList;
        
    }
    
    public List<Reclamation> afficherReclamationPerUserWithoutReponse(User user) {
    
        List<Reclamation> myList = new ArrayList<Reclamation>();
        int idUser = user.getId();
        System.out.println("Id user : "+idUser);
     try {   
        String sql ="Select * from reclamation where reclamation.id_user=? and reclamation.id_reponse is null;"; 
        ste = cnx.prepareStatement(sql);
        ste.setInt(1, idUser);
        ResultSet resultSet;
        resultSet = ste.executeQuery();
        
        while(resultSet.next())
        {Reclamation R = new Reclamation();
         R.setId(resultSet.getInt(1));
         
         R.setObject(resultSet.getString(4));
         R.setStatus(resultSet.getString(5));
         R.setDescription(resultSet.getString(6));
         R.setScreenshot("file:C:\\xampp\\htdocs\\CheckUP\\web\\uploads\\images\\" + resultSet.getString(7));
         R.setEmail(resultSet.getString(8));
         myList.add(R);

        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return myList;
        
    }
    
   
public void deleteReclamation(int id ){
    try {
        String sql = "DELETE FROM reclamation WHERE id=? ;";
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, id);
        ste.executeUpdate();
        System.out.println("reclamation deleted");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    public void updateReclamation(Reclamation r){
    try {
        String sql = "UPDATE reclamation SET  object=?, status=?, description=?, screenshot=?, email=? WHERE id=?";
  
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, r.getId());
        ste.setString(2, r.getObject());
        ste.setString(3, r.getStatus());
        ste.setString(4, r.getDescription());
        ste.setString(5, r.getScreenshot());
        ste.setString(6, r.getEmail());

       
        ste.executeUpdate();
        System.out.println("reclamation updeted");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
 
}    
   

    

