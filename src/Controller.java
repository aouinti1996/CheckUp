

import com.esprit.entities.User;
import com.esprit.services.UserService;
import com.esprit.tools.MyConnection;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.MySQLConnection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class Controller implements Initializable {
 private UserService ps = new UserService(); 
 private Connection cnx;
    private PreparedStatement ste;
    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    @FXML
    private TableView<User> table_user;
    @FXML
    private TableColumn<User, String> table_nom;
    @FXML
    private TableColumn<User, String> table_prenom;
    @FXML
    private TableColumn<User, String> table_email;
    ObservableList<User> oblist=FXCollections.observableArrayList();
   
    @FXML
    private TableColumn<User,String> table_numuser;
    @FXML
    private TableColumn<User, String> table_adress_user;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_update;
    @FXML
    private Button btnadd;
    @FXML
    private TableColumn<User, String>  tab_role;
    @FXML
    private JFXTextField filterField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

             try {
         // TODO
         Connection mc= MyConnection.getInstance().getConnection();
         ResultSet rs=mc.createStatement().executeQuery("select *from user");
         while (rs.next()){
             oblist.add(new User(rs.getString("Nom"),rs.getString("Prenom"),rs.getString("datenaissance"),rs.getString("email"), rs.getString("password"),rs.getString("numerotelephone"),rs.getString("adresse"),rs.getString("specialite"),rs.getString("role")));
         }
         table_nom.setCellValueFactory(new PropertyValueFactory("Nom"));
         table_prenom.setCellValueFactory(new PropertyValueFactory("Prenom"));
              table_email.setCellValueFactory(new PropertyValueFactory("email"));
             table_numuser.setCellValueFactory(new PropertyValueFactory("numerotelephone"));
             table_adress_user.setCellValueFactory(new PropertyValueFactory("adresse"));
                    tab_role.setCellValueFactory(new PropertyValueFactory("role"));
                    //   table_email.setCellValueFactory(new PropertyValueFactory("specialite"));
 
         table_user.setItems(ps.afficherUser());
          
         FilteredList<User> usersFiltered = new FilteredList<>(ps.afficherUser(), b-> true);
         
         filterField.textProperty().addListener((observable  , oldValue, newValue)->{

             usersFiltered.setPredicate(user  -> {
                 if(newValue.isEmpty() || newValue ==null){
                    return true;
             }
             String searchKeyword = newValue.toLowerCase();
             if (user.getEmail().toLowerCase().indexOf(searchKeyword) > -1 ){
                                  return true ;

             }else 
                 return false;
          
         });
         
                 SortedList<User> sortedData = new SortedList<>(usersFiltered);
                 sortedData.comparatorProperty().bind(table_user.comparatorProperty());
                 table_user.setItems(sortedData);
         });
     } catch (SQLException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
            table_user.setItems(oblist);
             //Search_user();
    }


    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnCustomers) {
            //pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
                                   try {

Pane newLoadedPane =   FXMLLoader.load(getClass().getResource("AjouterUser.fxml"));
  pnlOverview.getChildren().add(newLoadedPane);

     

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        //btnCustomers.ge
        }
   if(actionEvent.getSource() == btnOverview)   
   {
    try {

Pane newLoadedPane =   FXMLLoader.load(getClass().getResource("Home.fxml"));
  pnlOverview.getChildren().add(newLoadedPane);

     

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }}
       if(actionEvent.getSource()==btnSignout)
       {  Stage stage = (Stage) btnSignout.getScene().getWindow();
    // do what you have to do
    stage.close();}
      
        if (actionEvent.getSource() == btnMenus) {
            //pnlMenus.setStyle("-fx-background-color : #53639F");
            //pnlMenus.toFront();
                        try {

Pane newLoadedPane =   FXMLLoader.load(getClass().getResource("se connecter.fxml"));
  pnlOverview.getChildren().add(newLoadedPane);

     

            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
               try {
          
FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor.fxml"));
 Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
           // try {
// AnchorPane panne=FXMLLoader.load(getClass().getResource("ModifierUser.fxml"));
/*FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Controller.class.getResource("home.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            Parent root;
     root = (Parent)loader.load();
      Scene scene = new Scene(root);
        Stage stage = new Stage();
  stage.setScene(new Scene(root));
  stage.show();
                 pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();*/
/*Stage modal_stage = new Stage();
modal_stage.setScene(new Scene(root, 500, 575));
modal_stage.setTitle("modal");
modal_stage.initModality(Modality.APPLICATION_MODAL);
modal_stage.initOwner(modal_stage.getOwner());
modal_stage.setResizable(false);
modal_stage.show();
Stage parentStage = new Stage();
Stage childStage = new Stage();
childStage.initOwner(parent);*/
//Pane newLoadedPane =   FXMLLoader.load(getClass().getResource("AfficherMedecin_.fxml"));
 // pnlOverview.getChildren().add(newLoadedPane);

     /*   FXMLLoader fxmlLoader = new 
                FXMLLoader(getClass().getResource("ModifierUser.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //set what you want on your stage
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("BoardView");
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();*/

          //  } catch (IOException ex) {
           //     Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            //}
            
            
            
  
        }
 
    
        
    @FXML
    private void ondeleteuser(ActionEvent event) {
   if(table_user.getSelectionModel().getSelectedItem() != null) 
        { 
            User s= table_user.getSelectionModel().getSelectedItem();
         int i= JOptionPane.showConfirmDialog(null, "Do you want to delete thos item: "+s.getEmail(), "Message", 
                                JOptionPane.YES_NO_OPTION);
         
         if(i==0)
         {
           UserService userService=new UserService();
           userService.supprimerUser(s.getEmail());
 
table_user.getItems().remove(s);
         }
            
        }
   else
   {
       JOptionPane.showMessageDialog(null, "You must select an item");
    
   
   }
        }

    @FXML
    private void onupdateuser(ActionEvent event) {
           if(table_user.getSelectionModel().getSelectedItem() != null) 
        { 
            User s= table_user.getSelectionModel().getSelectedItem();
          try {

         
         AnchorPane panne=FXMLLoader.load(getClass().getResource("ModifierUser.fxml"));
      
          pnlOverview.setStyle("-fx-background-color : #53639F");
                FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
                Parent root=(Parent)loader.load();
          ModifierUserController modifierUserController=loader.getController();
          modifierUserController.setuser(s);
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
            
        }
   else
   {
       JOptionPane.showMessageDialog(null, "You must select an item");
    
   
   }
   
 
        
        
        
        
        
        
    }

    @FXML
    private void onclikbtnadd(ActionEvent event) {
        
          
             
     try {
           pnlOverview.setStyle("-fx-background-color : #53639F");
                FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterUser.fxml"));
         Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
      
    }

    @FXML
    private void on_medecin(ActionEvent event) {
        
                     try {
          
FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor.fxml"));
 Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }

    @FXML
    private void viewchart(ActionEvent event) {
        UserService userService=new UserService();
        int  nbmedecin=userService.nbmedecin();
          int  nbpatient=userService.nbpatient();
          ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Medecin: "+nbmedecin, nbmedecin),
                new PieChart.Data("Patient: "+nbpatient, nbpatient));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Users");
           Stage stage = new Stage();

           Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);
 
      

       ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void on_orders(ActionEvent event) {
              
                     try {
          
FXMLLoader loader=new FXMLLoader(getClass().getResource("doctor.fxml"));
 Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void on_patient(ActionEvent event) {
                           try {
          
FXMLLoader loader=new FXMLLoader(getClass().getResource("patient.fxml"));
 Parent root = (Parent)loader.load();
         
        
             Stage stage = new Stage(StageStyle.DECORATED);
  stage.setScene(new Scene(root));
  stage.show();
     } catch (IOException ex) {
         Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @FXML
    private void handleClicks(MouseEvent event) {
    }

 

   



}
