/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.ReclamatientPatientController.d;
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
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ModifierReclamationPatientController implements Initializable {

    @FXML
    private TextField txtObject;
    @FXML
    private TextField txtDescription;
    @FXML
    private ImageView imgview;
    @FXML
    private Button image;
    @FXML
    private ImageView objectCheckMark;
    File selectedFile;
    private String path;
    
    int id;
    Notifications n;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 ReclamationService rs = new ReclamationService();
        
       
     
        path=ReclamatientPatientController.d.getScreenshot();

        txtObject.setText(ReclamatientPatientController.d.getObject());
        imgview.setImage(new Image(ReclamatientPatientController.d.getScreenshot()));
        txtDescription.setText(ReclamatientPatientController.d.getDescription());
        id=ReclamatientPatientController.d.getId();
        
    }    

    @FXML
    private void btn_Valider_Modifier(ActionEvent event) {
       String aObject = txtObject.getText();
    String aDescription = txtDescription.getText();
        ReclamatientPatientController.d.setObject(aObject);
        ReclamatientPatientController.d.setDescription(aDescription);
        ReclamatientPatientController.d.setScreenshot(path);
        
        System.out.println(ReclamatientPatientController.d.toString());
       //Reclamation r = new Reclamation(aObject,"En attente",aDescription,path);
       Reclamation r = ReclamatientPatientController.d;
        System.out.println("Testing getRec"+r.toString());
       
        ReclamationService rs =new ReclamationService();
        rs.updateReclamation(r);
        n = Notifications.create()
                    .title("Succes")
                    .text("Reclamation modifier avec succes")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(3));
            n.showInformation();

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
    private void btn_Annuler_modifier(ActionEvent event) {
                    try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamatientPatient.fxml"));
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
