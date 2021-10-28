package gestionevenement.gui;

import Entité.Evenement;
import Service.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import utils.JavaMail;

/**
 * FXML Controller class
 *
 * @author lotfi
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private TextField evenementTitre;
    @FXML
    private TextArea evenementDescription;
    @FXML
    private DatePicker evenementDatedebut;
    @FXML
    private DatePicker evenementDatefin;
    @FXML
    private TextField evenementInvitees;
    @FXML
    private TextField evenementRespensable;
    @FXML
    private TextField evenementLieu;
     private EvenementService sc = new EvenementService();
    @FXML
    private TableColumn<Evenement, String> table_titre;
    @FXML
    private TableColumn<Evenement, String> table_description;
    @FXML
    private TableColumn<Evenement, String> table_datedebut;
    @FXML
    private TableColumn<Evenement, String> table_datefin;
    @FXML
    private TableColumn<Evenement, String> table_lieu;
    @FXML
    private TableColumn<Evenement, String> table_invitees;
    @FXML
    private TableColumn<Evenement, String> table_respensable;
    @FXML
    private TableView<Evenement> tableview_Evenement;
    @FXML
    private javafx.scene.control.TextField rechercher_field;
    @FXML
    private Button btncréer;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    //@FXML
    //private TextField rechercher_field;
    @FXML
    private Button btnafficher;
    @FXML
    private AnchorPane sceneAjouterEvenement;

    public static String desc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO
      refreshTableView();
        
    }

    @FXML
    private void btn_add_evenement(ActionEvent event) throws MessagingException 
    {
          sc.ajouterEvenement( new Evenement(evenementTitre.getText(), evenementDescription.getText(),
                  Date.valueOf(evenementDatedebut.getValue()), Date.valueOf(evenementDatefin.getValue()),
                  evenementLieu.getText(), evenementInvitees.getText(), evenementRespensable.getText()) );
        
            JOptionPane.showMessageDialog(null, "confirmation d'ajout");
            JavaMail.sendMail("lotfihammoudi384@gmail.com");
            refreshTableView();
    }
    
    private void refreshTableView()
    {
        table_titre.setCellValueFactory(new PropertyValueFactory("titreeven"));
        table_description.setCellValueFactory(new PropertyValueFactory("descriptioneven"));
        table_datedebut.setCellValueFactory(new PropertyValueFactory("datedebut"));
        table_datefin.setCellValueFactory(new PropertyValueFactory("datefin"));
        table_lieu.setCellValueFactory(new PropertyValueFactory("lieueven"));
        table_invitees.setCellValueFactory(new PropertyValueFactory("invitees"));
        table_respensable.setCellValueFactory(new PropertyValueFactory("respensable"));
        tableview_Evenement.setItems(sc.afficherEvenement());
    }

    @FXML
    private void btn_update_evenement(ActionEvent event) 
    {
        Evenement e = tableview_Evenement.getSelectionModel().getSelectedItem();
        sc.modifierEvenement(new Evenement(e.getIdeven(), evenementTitre.getText(), evenementDescription.getText(),
                  Date.valueOf(evenementDatedebut.getValue()), Date.valueOf(evenementDatefin.getValue()),
                  evenementLieu.getText(), evenementInvitees.getText(), evenementRespensable.getText()) );
        
            JOptionPane.showMessageDialog(null, "confirmation de modification");
            refreshTableView();
    }

    @FXML
    private void btn_delete_evenement(ActionEvent event)
    {
         Evenement evenement = tableview_Evenement.getSelectionModel().getSelectedItem();
        sc.supprimerEvenement(evenement.getIdeven());
        refreshTableView();
    }

    @FXML
    private void btn_get_evenement(ActionEvent event)
    {
        Evenement evenement = tableview_Evenement.getSelectionModel().getSelectedItem();
        evenementTitre.setText(evenement.getTitreeven());
        evenementDescription.setText(evenement.getDescriptioneven());
        evenementDatedebut.setValue(evenement.getDatedebut().toLocalDate());
        evenementDatefin.setValue(evenement.getDatefin().toLocalDate());
        evenementLieu.setText(evenement.getLieueven());
        evenementInvitees.setText(evenement.getInvitees());
        evenementRespensable.setText(evenement.getRespensable());
    }

    @FXML
    private void btn_rechercher(ActionEvent event)
    {
       
        table_titre.setCellValueFactory(new PropertyValueFactory("titreeven"));
        table_description.setCellValueFactory(new PropertyValueFactory("descriptioneven"));
        table_datedebut.setCellValueFactory(new PropertyValueFactory("datedebut"));
        table_datefin.setCellValueFactory(new PropertyValueFactory("datefin"));
        table_lieu.setCellValueFactory(new PropertyValueFactory("lieueven"));
        table_invitees.setCellValueFactory(new PropertyValueFactory("invitees"));
        table_respensable.setCellValueFactory(new PropertyValueFactory("respensable"));
        tableview_Evenement.setItems(sc.chercherEvenement(rechercher_field.getText()));
    }

    @FXML
    private void btn_afficher_description(ActionEvent event) throws IOException 
    {
        Evenement evenement = tableview_Evenement.getSelectionModel().getSelectedItem();
        if(evenement != null)
        {
            AjouterEvenementController.desc = evenement.getDescriptioneven();
            AnchorPane sceneDescription = FXMLLoader.load(getClass().getResource("AfficherDescription.fxml"));
            sceneAjouterEvenement.getChildren().removeAll();
            sceneAjouterEvenement.getChildren().setAll(sceneDescription);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vous devez sélectionner un evenement");
        }
        
        
    }
    
}
