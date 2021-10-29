/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ConsulterPatientController implements Initializable {

    @FXML
    private TextField txtUsernamep;
    @FXML
    private TextField txtObjectp;
    @FXML
    private TextField txtDescriptionp;
    @FXML
    private TextField txtEmailp;
    @FXML
    private ImageView imgview;
    @FXML
    private TextField txtReponsep;
    File selectedFile;
    private String path;
int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         ReclamationService rs = new ReclamationService();
        
       
     
        path=ReclamatientPatientController.d.getScreenshot();
        txtEmailp.setText(ReclamatientPatientController.d.getEmail());
        
        txtUsernamep.setText(ReclamatientPatientController.d.getUsername());
        txtObjectp.setText(ReclamatientPatientController.d.getObject());
        imgview.setImage(new Image(ReclamatientPatientController.d.getScreenshot()));
        txtDescriptionp.setText(ReclamatientPatientController.d.getDescription());
        id=ReclamatientPatientController.d.getId();
    }   
    
    

    @FXML
    private void btn_Back(ActionEvent event) {
    }
    
}
