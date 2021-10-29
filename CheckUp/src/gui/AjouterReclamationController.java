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
import javafx.event.EventHandler;
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
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.io.FileUtils;
import org.controlsfx.control.Notifications;
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
    private TextField txtObject;
    @FXML
    private TextField txtDescription;
    private TextField txtEmail;
    @FXML
    private ImageView imgview;
    File selectedFile;
    @FXML
    private Button image;
    Notifications n;
    @FXML
    private ImageView objectCheckMark;
  String erreur;


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgview.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                } else {
                    event.consume();
                }
            }
        });

        // Dropping over surface
        imgview.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    path = null;
                    for (File file : db.getFiles()) {
                        path = file.getName();
                        selectedFile = new File(file.getAbsolutePath());
                        System.out.println("Drag and drop file done and path=" + file.getAbsolutePath());//file.getAbsolutePath()="C:\Users\X\Desktop\ScreenShot.6.png"
                        imgview.setImage(new Image("file:" + file.getAbsolutePath()));
//                        screenshotView.setFitHeight(150);
//                        screenshotView.setFitWidth(250);
                        image.setText(path);
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });

        imgview.setImage(new Image("file:\"C:\\Users\\houss\\Desktop\\EX_project\\CheckUp\\src\\Images\\drag-drop.gif\""));
        
        // TODO
    } 
    

    @FXML
    private void btn_Valider(ActionEvent event) {
        User aUsername = session.getCurrentUser();
        String aObject = txtObject.getText();
        String aDescription = txtDescription.getText();
        
       
       Reclamation r = new Reclamation(aUsername,aObject,"En attente",aDescription,path,"houssem095@gmail.com");
        ReclamationService rs =new ReclamationService();
        rs.ajouterReclamation(r);
        n = Notifications.create()
                    .title("Succes")
                    .text("Reclamation envoyé avec succes")
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
    private void btn_Annuler(ActionEvent event) {
 try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
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

