
package com.esprit.tools;

import com.esprit.entities.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


public class MyConnection {
    public String url ="jdbc:mysql://localhost:3306/esprit";
    public String login="root";
    public String pwd ="";
    public Connection cnx;
    public static MyConnection ct;

    private MyConnection() {
        try {
           cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Cnx etablie");
        } catch (SQLException ex) {
            System.out.println("Problème de cnx");
            System.out.println(ex.getMessage());
        }
    
    }
    public Connection getConnection(){
        return cnx;
    }
    public static MyConnection getInstance(){
        if(ct == null)
            ct = new MyConnection();
        return ct;
        
    } 
    public static Connection connectDb(){
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnx=DriverManager.getConnection("jdbc:mysql:3306//localhost/esprit","root","");
            
            JOptionPane.showMessageDialog(null, "cnx etablie");
            return cnx;
        } catch(Exception e){
            
     JOptionPane.showMessageDialog(null, e);
     return null;
            
        }
   
    }
   
    
}
