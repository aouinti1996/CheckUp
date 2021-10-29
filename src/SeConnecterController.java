/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.esprit.entities.User;
import com.esprit.services.UserService;
//import com.esprit.services.JavaMail;
import com.esprit.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author msi
 */

public class SeConnecterController implements Initializable {
 private Connection cnx;
    private PreparedStatement st;
    private ResultSet rs;
    @FXML
    private TextField nom_user_connect;

    @FXML
    private Button btn_seconnecter_user;
    @FXML
    private PasswordField pwd_auth;
    @FXML
    private Button exit_out;
           // Connection mc= MyConnection.getInstance().getConnection();
         //ResultSet rs=mc.createStatement().executeQuery("select *from user");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connection mc= MyConnection.getInstance().getConnection();
    
    }    

    @FXML
    private void on_open_home(ActionEvent event) throws SQLException {
                //Connection mc= MyConnection.getInstance().getConnection();
        String email=nom_user_connect.getText();
        String password=pwd_auth.getText();
        UserService userService=new UserService();
        //   boolean test= userService.authentification(email,password);
        //String sql="select *from user where email='"+nom_user_connect.getText()+"'and password='"+mdp_user_connect.getText();
       //Connection mc= MyConnection.getInstance().getConnection();
             
boolean testauth=    userService.authentification(email,password);
    System.out.println("connected"+testauth);
    if(testauth)
    {
    
  
              try {
                   FXMLLoader loader=new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root=(Parent)loader.load();
     
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
              } catch (IOException ex) {
                  Logger.getLogger(SeConnecterController.class.getName()).log(Level.SEVERE, null, ex);
              }
    
         //    JOptionPane.showMessageDialog(null, "you are connected");
         }
    
    
    
    
    else
    {  JOptionPane.showMessageDialog(null, "Fail connected");}
   /*  try {
          String sql="select *from  user where email= '"+nom_user_connect.getText()+"' AND password= '"+pwd_auth.getText()+"'";
          Connection mc= MyConnection.getInstance().getConnection();
            ResultSet rs=mc.createStatement().executeQuery(sql);
        
            
        
       
       
         else{System.out.println("no connected");
              JOptionPane.showMessageDialog(null, "sorry connection failed");}
     } catch (SQLException ex) {
         Logger.getLogger(SeConnecterController.class.getName()).log(Level.SEVERE, null, ex);
     }
   
     */    
    }

    @FXML
    private void verifpwd(ActionEvent event) {
        
                String email=nom_user_connect.getText();
                if(email==null ||email.trim().isEmpty())
         JOptionPane.showMessageDialog(null, "inserer votre email");
        else
                {
                     UserService userService=new UserService();
               int a = userService.sendmailpwd(email);
               System.out.println("value of a"+a);
               if(a==0)
                JOptionPane.showMessageDialog(null, "sorry email not foud");
                else
                   
                JOptionPane.showMessageDialog(null, "Sending Mail");
                
                }
        
        
        
    }

    @FXML
    private void ON_btn_sginup(ActionEvent event) {
                Stage stage = (Stage) exit_out.getScene().getWindow();
    // do what you have to do
    stage.close();}
    }
    

