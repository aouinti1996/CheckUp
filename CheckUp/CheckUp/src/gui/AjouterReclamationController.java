/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import reclamation.Reclamation;
import reclamation.User;
import service.ReclamationService;
import service.SessionService;


/**
 * FXML Controller class
 *
 * @author houss
 */
public class AjouterReclamationController implements Initializable {
    User user1 = new User(1,"diyamitra");
    SessionService session = new SessionService(user1,true);
    private String path;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtObject;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtEmail;
    @FXML
    private ImageView imgview;
    File selectedFile;
    @FXML
    private Button image;
   



    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void btn_Valider(ActionEvent event) {
        User aUsername = session.getCurrentUser();
        String aObject = txtObject.getText();
        String aDescription = txtDescription.getText();
        String aEmail = txtEmail.getText();
       
       Reclamation r = new Reclamation(aUsername,aObject,"En attente",aDescription,path,aEmail);
        ReclamationService rs =new ReclamationService();
        rs.ajouterReclamation(r);
        if (selectedFile != null) {
            try {
                
                File source = new File(selectedFile.toString());
                File dest = new File("C:\\xampp\\htdocs\\Checkup\\web\\uploads\\images");
                FileUtils.copyFileToDirectory(source, dest);
            } catch (IOException ex) {
                Logger.getLogger(AjouterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
    }

    @FXML
    private void btn_Annuler(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        

        
    }

  

    @FXML
    private void image(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);
                if (selectedFile != null) {

            try {
                path = selectedFile.getName();
imgview.setImage(new Image(selectedFile.toURI().toURL().toString()));
imgview.setFitHeight(250);
imgview.setFitWidth(150);
image.setText(path);
            } catch (MalformedURLException ex) {
                ex.getMessage();
            }
                }
    }
    
}
