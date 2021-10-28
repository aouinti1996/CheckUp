package Service;
import Connection.MyConnection;
import Entité.Evenement;
import java.sql.*;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author lotfi
 */
public class EvenementService {
    public Connection cnx;
public PreparedStatement ste;
    public EvenementService() {  
        cnx = MyConnection.getInstance().getConnection();
        
    }
     public void ajouterEvenement(Evenement e){
        try {
            String sql = "insert into evenement(titreeven,descriptioneven,datedebut,datefin,lieueven,invitees,respensable)"+"values(?,?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setString(1, e.getTitreeven());
            ste.setString(2, e.getDescriptioneven());
            ste.setDate(3, e.getDatedebut());
            ste.setDate(4, e.getDatefin());
            ste.setString(5, e.getLieueven());
            ste.setString(6, e.getInvitees());
            ste.setString(7, e.getRespensable());
            ste.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Evenement non ajoutée !!");
        System.out.println(ex.getMessage());
    }
    }
     public void supprimerEvenement(int ideven){
    try {
        String sql = "DELETE FROM evenement WHERE ideven=?" ;
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, ideven);
        ste.executeUpdate();
        System.out.println("evenement supprimer");
        } catch (SQLException ex) {
            System.out.println("echec de la suppression!!");
            System.err.println(ex.getMessage());
        
    } 
    }
      public void modifierEvenement(Evenement e)
      {          
          try 
        {
        String sql = "UPDATE evenement SET titreeven=?, descriptioneven = ?, datedebut = ?, datefin = ?,lieueven = ?,invitees = ?,respensable = ?   WHERE ideven=? " ;
        ste=cnx.prepareStatement(sql);
        ste.setString(1, e.getTitreeven());
        ste.setString(2, e.getDescriptioneven());
        ste.setDate(3, e.getDatedebut());
        ste.setDate(4, e.getDatefin());
        ste.setString(5, e.getLieueven());
        ste.setString(6, e.getInvitees());
        ste.setString(7, e.getRespensable());
        ste.setInt(8, e.getIdeven());
        ste.executeUpdate();
        System.out.println("evenement modifier");
        } catch (SQLException ex) {
          System.out.println("Updated failed !!!");
          System.err.println(ex.getMessage());
        }
    }
      public ObservableList<Evenement> afficherEvenement() {
    
        ObservableList evenements = FXCollections.observableArrayList();
     try {   
        String sql ="Select * from evenement";
        ste = cnx.prepareStatement(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        while(rs.next())
        {
            evenements.add(new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8)));
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());;
    }
     return evenements;
        
    }
    
      public ObservableList<Evenement> chercherEvenement(String value) 
    {
        ObservableList<Evenement> oblist = FXCollections.observableArrayList();
        try
        {
            String req = "SELECT * FROM evenement where titreeven=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                oblist.add(new Evenement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return oblist;
    }
     
     
     
}