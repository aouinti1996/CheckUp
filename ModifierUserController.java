/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.esprit.entities.User;
import com.esprit.services.UserService;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ModifierUserController implements Initializable {

    @FXML
    private JFXTextField name_update_user;
    private User s;
    public String testname;
    @FXML
    private JFXTextField prenom_update;
    @FXML
    private JFXTextField email_user;
    @FXML
    private JFXTextField adresse_user;
    @FXML
    private Button btn_annuler;
    @FXML
    private JFXTextField mdp_user;
    @FXML
    private JFXTextField numtelephoneuser;
    @FXML
    private JFXDatePicker datenaiss_user_update;
    @FXML
    private Button btn_update;
    @FXML
    private Label label_spec_update;
    @FXML
    private ComboBox specialite_cbx_update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              ObservableList<String> list=FXCollections.observableArrayList("biologiste","gynecologue");
                specialite_cbx_update.setItems(list);
             email_user.setEditable(false);
          specialite_cbx_update.setVisible(false);
                 label_spec_update.setVisible(false);
    }    
    
    
    
    public void setuser(User s)
    {name_update_user.setText(s.getNom());
    prenom_update.setText(s.getPrenom());
     email_user.setText(s.getEmail());
     adresse_user.setText(s.getAdresse());
     mdp_user.setText(s.getPassword());
     numtelephoneuser.setText(s.getNumerotelephone());
  System.out.println(s.getRole());

//ZonedDateTime d = ZonedDateTime.parse(dateTime);
datenaiss_user_update.setValue(LOCAL_DATE(s.getDate_naissance()));
  if(s.getRole().equals("medecin"))
  {        specialite_cbx_update.setVisible(true);
                 label_spec_update.setVisible(true);
   specialite_cbx_update.setValue(s.getSpecialite());
  }
    }

    @FXML
    private void onclickannuler(ActionEvent event) {
          Stage stage = (Stage)  btn_annuler.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void onclickupdate(ActionEvent event) {
        
        String nom=name_update_user.getText();
        String prenom= prenom_update.getText();
        String mdp=mdp_user.getText();
        String numerotel=numtelephoneuser.getText();
        String date=datenaiss_user_update.getValue().toString();
        String adresse=adresse_user.getText();
   
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Update");
        alert.setHeaderText(null);
        if(nom == null ||nom.trim().isEmpty()||  prenom==null ||prenom.trim().isEmpty()||numerotel==null ||numerotel.trim().isEmpty() ||mdp==null ||mdp.trim().isEmpty()||adresse==null ||adresse.trim().isEmpty())
        {
          alert.setContentText("Item is empty");
          alert.show();
             //JOptionPane.showMessageDialog(null, "Item is empty");
      
    }
        else
        {
            
            
                User n=new User();
        System.out.println("Cas 1");
        n.setNom(nom);
        n.setPrenom(prenom);
        n.setPassword(mdp);
        n.setAdresse(adresse);
        n.setNumerotelephone( numerotel);
        n.setEmail(email_user.getText());
        n.setDate_naissance(date);
       
        
         if (  specialite_cbx_update.getSelectionModel().getSelectedItem()!=null){  
                           specialite_cbx_update.setVisible(false);
    label_spec_update.setVisible(false);
             String specialite=  specialite_cbx_update.getSelectionModel().getSelectedItem().toString();
        n.setSpecialite(specialite);}
   
        
            UserService userService=new UserService();
          boolean test=  userService.modifierUser(n);
        if(test)
        {
        JOptionPane.showMessageDialog(null, "Success Update");
          System.out.println("Cas 2");
        }
        
        else 
            
        { JOptionPane.showMessageDialog(null, "Echec Update");
          System.out.println("Cas 3");
        
        }
        }  
            

        }



public static final LocalDate LOCAL_DATE (String dateString){
    
    String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
    .appendPattern(DATE_TIME_FORMAT_PATTERN)
    // optional decimal point followed by 1 to 6 digits
    .optionalStart()
    .appendPattern(".")
    .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, false)
    .optionalEnd()
    .toFormatter();
        String dateTime = dateString+'T'+"12:06:58";
    LocalDate localDate = LocalDate.parse(dateTime, formatter1);
    return localDate;
}
}
