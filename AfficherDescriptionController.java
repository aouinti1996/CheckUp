/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionevenement.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class AfficherDescriptionController implements Initializable {

    @FXML
    private TextArea Descriptionevenement;
    @FXML
    private Button btnretour;
    @FXML
    private AnchorPane sceneDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
            Descriptionevenement.setText(AjouterEvenementController.desc);     
    }    

    @FXML
    private void btn_retour_decription(ActionEvent event) throws IOException
    {
        AnchorPane sceneAjouterEvenement = FXMLLoader.load(getClass().getResource("AjouterEvenement.fxml"));
        sceneDescription.getChildren().removeAll();
        sceneDescription.getChildren().setAll(sceneAjouterEvenement);
    }
    
}
