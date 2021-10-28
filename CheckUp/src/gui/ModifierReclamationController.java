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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;
import reclamation.Reclamation;
import reclamation.Reponse;
import service.ReclamationService;
import service.ReponseService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ModifierReclamationController implements Initializable {
    File selectedFile;
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
    private Button image;
    private String path;
    int id;
    @FXML
    private TextField txtReponse;
    Notifications n;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService rs = new ReclamationService();
        
       
     
        path=DetailsReclamationController.d.getScreenshot();
        txtEmail.setText(DetailsReclamationController.d.getEmail());
        
        txtUsername.setText(DetailsReclamationController.d.getUsername());
        txtObject.setText(DetailsReclamationController.d.getObject());
        imgview.setImage(new Image(DetailsReclamationController.d.getScreenshot()));
        txtDescription.setText(DetailsReclamationController.d.getDescription());
        id=DetailsReclamationController.d.getId();
        // TODO
    }    


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

    @FXML
    private void btn_Back(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsReclamation.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(" Ajouter Reclamation");
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

        
    

    @FXML
    private void btn_Envoyer(ActionEvent event) {
       String aReponse = txtReponse.getText();
       Reponse p = new Reponse(aReponse);
            System.out.println(p.toString());
        ReponseService rs =new ReponseService();
        System.out.println(id);
        rs.ajouterReponse(p,id);
         n = Notifications.create()
                    .title("Succes")
                    .text("Reponse envoyé avec succes")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(3));
            n.showInformation();

    }
    
}
