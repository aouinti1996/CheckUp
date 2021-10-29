/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import reclamation.Reclamation;
import reclamation.User;
import service.ReclamationService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class DetailsReclamationController implements Initializable {

    @FXML
    private TableView<Reclamation> tableview_Reclamation;
    @FXML
    private TableColumn<Reclamation, Integer> table_Id;
    @FXML
    private TableColumn<Reclamation, String> table_Username;
    @FXML
    private TableColumn<Reclamation, String> table_Object;
    @FXML
    private TableColumn<Reclamation, String> table_Description;
    @FXML
    private TableColumn<Reclamation, String> table_Screenshot;
    @FXML
    private TableColumn<Reclamation, String> table_Email;
    @FXML
    private TableColumn<Reclamation, String> table_Status;
    ReclamationService rs = new ReclamationService();
    static Stage stageModifier;
    static Reclamation d;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        table_Id.setCellValueFactory(new PropertyValueFactory("id"));
        table_Username.setCellValueFactory(new PropertyValueFactory("username"));
        table_Object.setCellValueFactory(new PropertyValueFactory("object"));
        table_Status.setCellValueFactory(new PropertyValueFactory("status"));
        table_Description.setCellValueFactory(new PropertyValueFactory("description"));
        table_Screenshot.setCellValueFactory(new PropertyValueFactory("screenshot"));
        table_Email.setCellValueFactory(new PropertyValueFactory("email"));
        rs.afficherReclamation();
        
        
        ReclamationService rs = new ReclamationService();
       ArrayList arrayList = (ArrayList) rs.afficherReclamation();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tableview_Reclamation.setItems(observableList);
        tableview_Reclamation.getColumns().addAll(table_Id, table_Username,table_Object,table_Description,table_Screenshot,table_Email,table_Status);

                Callback<TableColumn<Reclamation, String>, TableCell<Reclamation, String>> cellFactoryImage
                = 
                new Callback<TableColumn<Reclamation, String>, TableCell<Reclamation, String>>() {
            String path;

@Override
public TableCell call(final TableColumn<Reclamation, String> param) {
                final TableCell<Reclamation, String> cell = new TableCell<Reclamation, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
} else {
                            path = item;

                            ImageView imagev = new ImageView(new Image(item));
                            imagev.setFitHeight(100);
                            imagev.setFitWidth(100);
                            setGraphic(imagev);
                            setText(null);
                            System.out.println(item);
                        }
                    }
                };

                cell.setOnMouseClicked((MouseEvent event2)
                        -> {
                    if (event2.getClickCount() == 1) {
                        if (tableview_Reclamation.getSelectionModel().getSelectedItem() != null && !tableview_Reclamation.getSelectionModel().getSelectedItem().getScreenshot().contains("null")) {
                            Stage window = new Stage();

                            window.setMinWidth(250);
                            ImageView imagevPOPUP = new ImageView(new Image(tableview_Reclamation.getSelectionModel().getSelectedItem().getScreenshot()));
                            imagevPOPUP.setFitHeight(576);
                            imagevPOPUP.setFitWidth(1024);

                            VBox layout = new VBox(10);
                            layout.getChildren().addAll(imagevPOPUP);
                            layout.setAlignment(Pos.CENTER);

                            //Display window and wait for it to be closed before returning
                            Scene scene = new Scene(layout);
                            window.setScene(scene);
                           window.show();

                       }
                   }


              });

                return cell;
            }

        };

        table_Screenshot.setCellFactory(cellFactoryImage);
              
    }   
  
        public void list() {
        ReclamationService rs = new ReclamationService();
        ArrayList arrayList = (ArrayList) rs.afficherReclamation();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tableview_Reclamation.setItems(observableList);
        
        }
        
    @FXML
    private void btn_update_reclamation_table(ActionEvent event) throws IOException {
        
                if (tableview_Reclamation.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        } else {
            d = tableview_Reclamation.getSelectionModel().getSelectedItem();
            
        Parent root = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
        Scene scene = new Scene(root);
        stageModifier = new Stage();
        stageModifier.setScene(scene);
        stageModifier.show();
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();    
            

        }
    }

    @FXML
    private void btn_delete_reclamation_table(ActionEvent event) {
                if (tableview_Reclamation.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        } else {
            List<Reclamation> reclamation = tableview_Reclamation.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer cette reclamation");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new ReclamationService().deleteReclamation(reclamation.get(0).getId());
                System.out.println(reclamation.get(0).getId());
            }
        }
        list();
    }

    @FXML
    private void btn_quitter(ActionEvent event) {
  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Main Menu");
            stage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    } 
    
}





    
