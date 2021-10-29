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
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class AddUserController implements Initializable {

    @FXML
    private JFXTextField prenom_add;
    @FXML
    private JFXTextField email_user_add;
    @FXML
    private JFXTextField mdp_user_add;
    @FXML
    private JFXTextField adresse_user_add;
    @FXML
    private JFXTextField numtelephoneuser_add;
    @FXML
    private JFXDatePicker datenaiss_user_add;
    @FXML
    private JFXTextField name_add_user;
    @FXML
    private Button btn_annuler_add;
    @FXML
    private Button btn_add;
    @FXML
    private RadioButton radio_medecin;
    @FXML
    private RadioButton radio_patient;
    @FXML
    private ComboBox cbx_specialite;
    @FXML
    private Label labelspecialite;
 private int type=1;//patient
 private boolean selected=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      ObservableList<String> list=FXCollections.observableArrayList("biologiste","gynecologue");
               cbx_specialite.setItems(list);
                  cbx_specialite.setVisible(false);
       labelspecialite.setVisible(false);
       ToggleGroup group = new ToggleGroup();
       radio_medecin.setToggleGroup(group);
       radio_patient.setToggleGroup(group);
      
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
               // Has selection.
                      cbx_specialite.setVisible(false);
       labelspecialite.setVisible(false);
               if (group.getSelectedToggle() != null) {
                   RadioButton button = (RadioButton) group.getSelectedToggle();
                 //  System.out.println("Button: " + button.getText());
                 //  labelInfo.setText("You are " + button.getText());
                 selected=true;
                 
                  if( button.getText().equals("Je suis un medecin"))
            {type=0;
                         cbx_specialite.setVisible(true);
       labelspecialite.setVisible(true);
            }
               }
              
           }
           
       });
    
    
    
    email_user_add.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { // when focus lost
          
                if (!email_user_add.getText().matches("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                    // when it not matches the pattern (1.0 - 6.0)
                    // set the textField empty
                     email_user_add.setText("");
                }
            }
        });
    
    
    numtelephoneuser_add.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { // when focus lost
       
                if (!numtelephoneuser_add.getText().matches("^[0-9]+")|| (numtelephoneuser_add.getText().length()!=8) ) {
                    // when it not matches the pattern (1.0 - 6.0)
                    // set the textField empty
                    numtelephoneuser_add.setText("");
                }
            }
        });
    
    }    

    @FXML
    private void onclickannuleradd(ActionEvent event) {
        
               Stage stage = (Stage)  btn_annuler_add.getScene().getWindow();
    stage.close();
        
        
    }

    @FXML
    private void onclickadd(ActionEvent event) {
  
       

        //A ajouter les condition sur le foiirmat mail+ empty
          Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Add");
        alert.setHeaderText(null);
              if(selected==false)
              {  alert.setContentText("You must select the type of user");
          alert.show();}
              else
              {
      String nom=  name_add_user.getText();
      String prenom=prenom_add.getText();
         String email =email_user_add.getText(); 
         String mdp=mdp_user_add.getText();
      String password  =mdp_user_add.getText();
 String numerotelephone=numtelephoneuser_add.getText();
    String adresse=adresse_user_add.getText();
      String date_naissance= datenaiss_user_add.getValue().toString();

   //  Date date naissance=datenaiss_user_add.getText();

  // {String specialite=cbx_specialite.getSelectionModel().getSelectedItem().toString();}
   
   
  //System.out.println(specialite);
     
     
      if(nom.trim().isEmpty()||nom == null||prenom.trim().isEmpty()||prenom == null||email.trim().isEmpty()||email == null||password.trim().isEmpty()||date_naissance.trim().isEmpty()||date_naissance == null||prenom.trim().isEmpty()||password == null||numerotelephone.trim().isEmpty()||numerotelephone== null||adresse.trim().isEmpty()||adresse== null)
      {// String numerodetelephone  =mdp_user_add.getText(); 
          
     alert.setContentText("Champs manquants");
          alert.show();     
          
          
      }
      else
      {UserService userService=new UserService();
       boolean test= userService.checkMailUser(email);
       System.out.println("test:"+test);
       if(test)
       {          alert.setContentText("User exist deja");
          alert.show();
       
       }
       else
       { 
        if(radio_patient.isSelected()){type=1;}
       else if (radio_medecin.isSelected()){type=0;}
       User a=new User();
                     
       a.setEmail(email);
       a.setNom(nom);
       a.setPrenom(prenom);
       a.setDate_naissance( date_naissance);
       a.setNumerotelephone(numerotelephone);
       a.setPassword(password);
       a.setAdresse(adresse);
      if (cbx_specialite.getSelectionModel().getSelectedItem()!=null){      String specialite=cbx_specialite.getSelectionModel().getSelectedItem().toString();
        a.setSpecialite(specialite);}
//cbx_specialite.setValue("specialite");
       a.setNumerotelephone(numerotelephone);
       
String testrole="";
if(type==1) testrole="patient";
  if(type==0) testrole="medecin";     
  
      boolean  testfinal=  userService.ajouterUser(a,type);
        System.out.println("test:"+testfinal);
        if(testfinal==true)
      
       {          alert.setContentText("Add "+testrole+" Success");
          alert.show();
       
       }
       if(testfinal==false)
       { 
       alert.setContentText("Fail "+testrole+  " Add");
          alert.show();
       
       }
       }
        
        
    }}
        }
    
    
    
    
    
    
}
