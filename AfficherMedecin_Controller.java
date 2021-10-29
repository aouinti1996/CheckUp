/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.esprit.entities.User;
import com.esprit.services.UserService;
import com.esprit.tools.MyConnection;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AfficherMedecin_Controller implements Initializable {

    @FXML
    private TableView<User> table_affiche_medecin;
    @FXML
    private TableColumn<User, String> table_affiche_nom;
    @FXML
    private TableColumn<User, String> table_affiche_prenom;
    @FXML
    private TableColumn<User, String> table_affiche_datenaiss;
    @FXML
    private TableColumn<User, String> table_affiche_email;
    @FXML
    private TableColumn<User, String> table_affiche_num;
    @FXML
    private TableColumn<User, String> table_affiche_adresse;
    @FXML
    private TableColumn<User, String> table_affiche_specialite;
    @FXML
    private Button btnadd_doctor;
    @FXML
    private Button btn_delete_doctor;
      private UserService ps = new UserService(); 
   ObservableList<User> oblist=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          // TODO
                    try {
         // TODO
         Connection mc= MyConnection.getInstance().getConnection();
         ResultSet rs=mc.createStatement().executeQuery("select *from user where specialite IS NOT  NULL");
         while (rs.next()){
             oblist.add(new User(rs.getString("Nom"),rs.getString("Prenom"),rs.getString("datenaissance"),rs.getString("email"),rs.getString("numerotelephone"),rs.getString("adresse"),rs.getString("specialite")));
         }
         table_affiche_nom.setCellValueFactory(new PropertyValueFactory("Nom"));
         table_affiche_prenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
              table_affiche_datenaiss.setCellValueFactory(new PropertyValueFactory("datenaissance"));
             table_affiche_email.setCellValueFactory(new PropertyValueFactory("email"));
             table_affiche_num.setCellValueFactory(new PropertyValueFactory("numerotelephone"));
             table_affiche_adresse.setCellValueFactory(new PropertyValueFactory("adresse"));
            
                table_affiche_specialite.setCellValueFactory(new PropertyValueFactory("specialite"));
 
 
         table_affiche_medecin.setItems(ps.afficherUser());
     } catch (SQLException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
            table_affiche_medecin.setItems(oblist);
        
    }


    @FXML
    private void onclikbtnadd_doctor(ActionEvent event) {
        
              try {
           //pnlOverview.setStyle("-fx-background-color : #53639F");
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterUser.fxml"));
         Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
        // TODO
    }    


    
}
