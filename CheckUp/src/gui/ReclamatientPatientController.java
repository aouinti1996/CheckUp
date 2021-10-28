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
import service.SessionService;

/**
 * FXML Controller class
 *
 * @author houss
 */
public class ReclamatientPatientController implements Initializable {
 User user1 = new User(1,"diyamitra");
    SessionService session = new SessionService(user1,true);
    static Stage stageConsulter;
    static Reclamation d;
    @FXML
    private TableView<Reclamation> TableView_P;
    @FXML
    private TableColumn<Reclamation,Integer> id_P;
    @FXML
    private TableColumn<Reclamation, String> username_p;
    @FXML
    private TableColumn<Reclamation, String> object_P;
    @FXML
    private TableColumn<Reclamation, String> description_P;
    @FXML
    private TableColumn<Reclamation, String> Screenshot_P;
    @FXML
    private TableColumn<Reclamation, String> email_P;
    @FXML
    private TableColumn<Reclamation, String> status_P;
    @FXML
    private TableView<Reclamation> TableView_patient;
    @FXML
    private TableColumn<Reclamation,Integer> id_patient;
    @FXML
    private TableColumn<Reclamation, String> object_patient;
    @FXML
    private TableColumn<Reclamation, String>status_patient;
    @FXML
    private TableColumn<Reclamation, String>description_patient;
    @FXML
    private TableColumn<Reclamation, String> screenshot_patient;
    @FXML
    private TableColumn<Reclamation, String> email_patient;
ReclamationService rs = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affiche1();
affiche2();
    }    

    public void affiche1(){
            id_P.setCellValueFactory(new PropertyValueFactory("id"));
        username_p.setCellValueFactory(new PropertyValueFactory("username"));
        object_P.setCellValueFactory(new PropertyValueFactory("object"));
        status_P.setCellValueFactory(new PropertyValueFactory("status"));
        description_P.setCellValueFactory(new PropertyValueFactory("description"));
        Screenshot_P.setCellValueFactory(new PropertyValueFactory("screenshot"));
        email_P.setCellValueFactory(new PropertyValueFactory("email"));
                ReclamationService rs = new ReclamationService();
       ArrayList arrayList = (ArrayList) rs.afficherReclamationPerUserWithReponse(user1);
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
TableView_P.setItems(observableList);
        TableView_P.getColumns().addAll(id_P, username_p,object_P,status_P,description_P,Screenshot_P,email_P);
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
                        if (TableView_P.getSelectionModel().getSelectedItem() != null && !TableView_P.getSelectionModel().getSelectedItem().getScreenshot().contains("null")) {
                            Stage window = new Stage();

                            window.setMinWidth(250);
                            ImageView imagevPOPUP = new ImageView(new Image(TableView_P.getSelectionModel().getSelectedItem().getScreenshot()));
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

        Screenshot_P.setCellFactory(cellFactoryImage);
    }
    
    
        public void affiche2(){
        id_patient.setCellValueFactory(new PropertyValueFactory("id"));
        object_patient.setCellValueFactory(new PropertyValueFactory("object"));
        status_patient.setCellValueFactory(new PropertyValueFactory("status"));
        description_patient.setCellValueFactory(new PropertyValueFactory("description"));
        screenshot_patient.setCellValueFactory(new PropertyValueFactory("screenshot"));
        email_patient.setCellValueFactory(new PropertyValueFactory("email"));
        
        
        
        ReclamationService rs = new ReclamationService();
       ArrayList arrayList = (ArrayList) rs.afficherReclamationPerUserWithoutReponse(user1);
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
TableView_patient.setItems(observableList);
        TableView_patient.getColumns().addAll(id_patient,object_patient,status_patient,description_patient,screenshot_patient,email_patient);

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
                        if (TableView_patient.getSelectionModel().getSelectedItem() != null && !TableView_patient.getSelectionModel().getSelectedItem().getScreenshot().contains("null")) {
                            Stage window = new Stage();

                            window.setMinWidth(250);
                            ImageView imagevPOPUP = new ImageView(new Image(TableView_patient.getSelectionModel().getSelectedItem().getScreenshot()));
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

        screenshot_patient.setCellFactory(cellFactoryImage);
    }
    @FXML
    private void btn_Consulter(ActionEvent event) throws IOException {
         if (TableView_P.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        } else {
            d = TableView_P.getSelectionModel().getSelectedItem();

        Parent root = FXMLLoader.load(getClass().getResource("ConsulterPatient.fxml"));
        Scene scene = new Scene(root);
        stageConsulter = new Stage();
        stageConsulter.setScene(scene);
        stageConsulter.show();
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    
}
            public void list() {
        ReclamationService rs = new ReclamationService();
        ArrayList arrayList = (ArrayList) rs.afficherReclamationPerUserWithReponse(user1);
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        TableView_P.setItems(observableList);
        
        }
            
                        public void list2() {
        ReclamationService rs = new ReclamationService();
        ArrayList arrayList = (ArrayList) rs.afficherReclamationPerUserWithoutReponse(user1);
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        TableView_patient.setItems(observableList);
        
        }
      @FXML
    private void btn_Supprimer(ActionEvent event) {
        
                      if (TableView_P.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        } else {
            List<Reclamation> reclamation = TableView_P.getSelectionModel().getSelectedItems();
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
    private void btn_Supprimer2(ActionEvent event) {
          if (TableView_patient.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning();
        } else {
            List<Reclamation> reclamation = TableView_patient.getSelectionModel().getSelectedItems();
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
        list2();
    }

    @FXML
    private void btn_Quitter(ActionEvent event) {
        
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
    }
      
    
