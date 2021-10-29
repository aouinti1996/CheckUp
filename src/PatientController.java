/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.esprit.entities.User;
import com.esprit.services.UserService;
import com.esprit.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class PatientController implements Initializable {

    @FXML
    private TableColumn<User, String> name_user_table;
    @FXML
    private TableColumn<User, String> prenom_user_table;
    @FXML
    private TableColumn<User,String> datedenaissance_email_table;
    @FXML
    private TableColumn<User,String> email_user_table;
    @FXML
    private TableColumn<User, String> adresse_user_table;
    @FXML
    private Button buton_exit_from_user;
    @FXML
    private TableView<User> table_user_affiche;
     private UserService ps = new UserService(); 
   ObservableList<User> oblist=FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> numero_user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            // TODO
            try{
         Connection mc= MyConnection.getInstance().getConnection();
         ResultSet rs=mc.createStatement().executeQuery("select *from user where specialite IS  NULL");
         while (rs.next()){
             oblist.add(new User(rs.getString("Nom"),rs.getString("Prenom"),rs.getString("datenaissance"),rs.getString("email"),rs.getString("numerotelephone"),rs.getString("adresse")));
         }
         name_user_table.setCellValueFactory(new PropertyValueFactory("Nom"));
         prenom_user_table.setCellValueFactory(new PropertyValueFactory("Prenom"));
              datedenaissance_email_table.setCellValueFactory(new PropertyValueFactory("datenaissance"));
             email_user_table.setCellValueFactory(new PropertyValueFactory("email"));
             numero_user.setCellValueFactory(new PropertyValueFactory("numerotelephone"));
             adresse_user_table.setCellValueFactory(new PropertyValueFactory("adresse"));
            
               
 
 
         table_user_affiche.setItems(ps.afficherUser());
     } catch (SQLException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
            table_user_affiche.setItems(oblist);
    }
    @FXML
    private void on_exit_user_table(ActionEvent event) {
             Stage stage = (Stage) buton_exit_from_user.getScene().getWindow();
    // do what you have to do
    stage.close();}
    }
        
    
     


    

