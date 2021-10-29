/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class ConnexionController implements Initializable {

    @FXML
    private Button btn_event_gestion;
    @FXML
    private Button btn_rdv_gestion;
    @FXML
    private Button btn_formulaire_gestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void on_gestion_event(ActionEvent event) {
    }

    @FXML
    private void on_gestion_rdv(ActionEvent event) {
    }

    @FXML
    private void on_gestion_formulaire(ActionEvent event) {
    }
    
}
