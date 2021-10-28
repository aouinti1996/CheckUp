/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button addReclamation;
    @FXML
    private Button ReclamationDetails;
    @FXML
    private Button EspacePatient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_AddReclamation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
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
    private void btn_ReclamatioDetails(ActionEvent event) {
    try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailsReclamation.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(" Reclamation Details");
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btn_EspacePation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamatientPatient.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(" Espace Patient");
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
    
}
