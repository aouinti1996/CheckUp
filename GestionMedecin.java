
package Edu.esprit.services;

import Edu.esprit.entities.Medecin;
import Edu.esprit.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionMedecin {
    private Connection cnx;
    private PreparedStatement ste;

    public GestionMedecin() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public void ajouterMedecin(Medecin m){
        String req ="INSERT INTO medecin (nom,prenom,specialite)"+"values (?,?,?)";
        try {
ste = cnx.prepareStatement(req);
ste.setString(1, m.getNom());
ste.setString(2, m.getPrenom());
ste.setString(3, m.getSpecialite());

ste.executeUpdate();
System.out.println("medecin ajoutée");

        } catch (SQLException ex) {
            
        }}
 public void supprimerMedecin(int id  ){
    try {
        String sql = "DELETE FROM medecin WHERE id=?;";
        ste=cnx.prepareStatement(sql);
        ste.setInt(1, id);
        ste.executeUpdate();
        System.out.println("medecin supprimé");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }

    /**
     *
     * @param m
     */
    public void modifierMedecin(Medecin m){
    try {
        String sql = "UPDATE medecin SET  nom=?, specialite=? WHERE id=?";
  
        ste=cnx.prepareStatement(sql);
        ste.setInt(3, m.getId());
        ste.setString(1, m.getNom());
        ste.setString(2, m.getSpecialite());
       
        ste.executeUpdate();
        System.out.println("medecin modifié");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    } 
     public List<Medecin> afficherMedecin() {
        List<Medecin>medecin=new ArrayList<>();
    try {
        
        String sql ="Select * from medecin";
        ste = cnx.prepareCall(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        Medecin m = new Medecin();
        while(rs.next()){
            m.setId(rs.getInt("id"));
            m.setNom(rs.getString("nom"));
            m.setPrenom(rs.getString("prenom"));
            m.setSpecialite(rs.getString("specialite"));
            medecin.add(m);
            
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());;
    }
       return medecin;
    }
    }
  
