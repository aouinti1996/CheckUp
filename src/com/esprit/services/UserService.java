
package com.esprit.services;

import com.esprit.entities.User;
import com.esprit.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserService {
    private Connection cnx;
    private PreparedStatement ste;
    JavaMail mail = new JavaMail();

    /**
     *
     */
    public UserService() {
        cnx = MyConnection.getInstance().getConnection();
    }
    
    public boolean  ajouterUser(User u, int indice){
       
        
         
         String req;
        boolean test=false;
         if(indice==1)
        {
        
       req ="INSERT INTO user(Nom,Prenom,datenaissance,email,password,numerotelephone,adresse,specialite,role)"+"values (?,?,?,?,?,?,?,?,?)";
        try {
ste = cnx.prepareStatement(req);
ste.setString(1, u.getNom());
ste.setString(2, u.getPrenom());
ste.setString(3, u.getDate_naissance());
ste.setString(4, u.getEmail());
ste.setString(5, u.getPassword());
ste.setString(6, u.getNumerotelephone());
ste.setString(7, u.getAdresse());
/*ste.setString(5, u.getPassword());
ste.setString(5, u.getNumerotelephone());
ste.setString(5, u.getAdresse());*/
ste.setString(8,u.getSpecialite());
ste.setString(9, "patient");
/*ste.setString(5, u.getNumerotelephone());
ste.setString(6, u.getAdresse());

ste.setString(8, u.getSpecialite());*/
int a=ste.executeUpdate();
if(a==1){test= true;System.out.println("Patient ajoutée");}

 
        } 
        
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
       
        }}
        else{
        
        req ="INSERT INTO user(Nom,Prenom,datenaissance,email,password,numerotelephone,adresse,specialite,role)"+"values (?,?,?,?,?,?,?,?,?)";
        try {
ste = cnx.prepareStatement(req);
ste.setString(1, u.getNom());
ste.setString(2, u.getPrenom());
ste.setString(3, u.getDate_naissance());
ste.setString(4, u.getEmail());
ste.setString(5, u.getPassword());
ste.setString(6, u.getNumerotelephone());
ste.setString(7, u.getAdresse());
ste.setString(8,u.getSpecialite());
/*ste.setString(5, u.getPassword());
ste.setString(5, u.getNumerotelephone());
ste.setString(5, u.getAdresse());
ste.setString(5, u.getSpecialite());*/
ste.setString(9, "medecin");

/*ste.setString(5, u.getNumerotelephone());
ste.setString(6, u.getAdresse());

ste.setString(8, u.getSpecialite());*/
int a=ste.executeUpdate();
if(a==1){test= true;System.out.println("medecin ajoutée");}

 
        } 
        
        catch (SQLException ex) {
             System.out.println(ex.getMessage());
       
        }

                }
  
    return test;
    }
 public void supprimerUser(int id  ){
    try {
        String sql = "DELETE FROM user WHERE id=?;";
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
    /*public void modifierUser(User m){
    try {
        String sql = "UPDATE user SET  nom=?, specialite=? WHERE id=?";
  
        ste=cnx.prepareStatement(sql);
        //ste.setInt(3, m.getId());
        ste.setString(1, m.getNom());
        ste.setString(2, m.getSpecialite());
       
        ste.executeUpdate();
        System.out.println("medecin modifié");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }*/ 
     public ObservableList<User> afficherUser() {
     ObservableList user = FXCollections.observableArrayList();;
    try {
        
        String sql ="Select * from user";
        ste = cnx.prepareCall(sql);
        ResultSet rs;
        rs = ste.executeQuery();
        User u = new User();
        
    
       while(rs.next())
        {
          user.add(new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
        }
    } 
    catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
     return user;
        
    }
     
     
      public void supprimerUser(String Email  ){
    try {
        String sql = "DELETE FROM user WHERE email=?;";
        ste=cnx.prepareStatement(sql);
        ste.setString(1, Email);
        ste.executeUpdate();
        System.out.println("medecin supprimé");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
     
      
         public boolean  modifierUser(User m){
    try {
      String sql = "UPDATE user SET  nom=?,prenom=?,datenaissance=?,password=?,numerotelephone=?,adresse=?,specialite=?  WHERE email=?";
  
        ste=cnx.prepareStatement(sql);
       
            ste.setString(1, m.getNom());
        ste.setString(2, m.getPrenom());
        ste.setString(3,m.getDate_naissance());
         ste.setString(4, m.getPassword());
          ste.setString(5,m.getNumerotelephone());
        ste.setString(6,m.getAdresse());
           ste.setString(7,m.getSpecialite());
        ste.setString(8, m.getEmail());
        
     
      
       // ste.setString(5,m.getNumerotelephone());
       /* ste.setString(6,m.getAdresse());
        ste.setString(7,m.getSpecialite());*/
       int test=ste.executeUpdate();
        System.out.println("valeur"+test+m.getEmail());
      //  System.out.println("medecin modifié");
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }
         
         
         
          public boolean checkMailUser(String email) {
   boolean test=false;
    try {
        
        String sql ="Select * from user where email=?;";
        ste = cnx.prepareCall(sql);
            ste.setString(1, email);
        ResultSet rs;
        rs = ste.executeQuery();
     
        
    
       while(rs.next())
        {
            System.out.println(rs.getInt(1));
            test=true;
       }
    } 
    catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
     return test;
        
    }

        public boolean authentification(String email, String password ){
      User a=null;
  boolean test=false;
        try
        {
            String req = "SELECT *from compte where email='"+email+"'AND pwd='"+password+ "'"; 
            PreparedStatement ps = cnx.prepareStatement(req);
           // ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
    rs.last();
    int nb=rs.getRow();
    if(nb==1)
    {test=true;
    //mail.send("theoptimizers7@gmail.com", "Aouinti007", "arwa.douiri@esprit.tn", "", "vous etes connectez");

    } 
    else {
            
            System.out.println("not found ");
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
return test;
}


public int sendmailpwd(String email)
{
int a =0;
String pwd="";
 try
        {
            String req = "SELECT pwd from compte where email='"+email+"'"; 
            PreparedStatement ps = cnx.prepareStatement(req);
           // ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
             while(rs.next())
        {
            pwd=rs.getString(1);
            System.out.println("pwd"+rs.getString(1));
      
       }
    rs.last();
    int nb=rs.getRow();
    if(nb==1)
    {a=1;
    String msg="welcome to our  application: Your password: "+pwd;
   mail.send("theoptimizers7@gmail.com", "Aouinti007", email, "Authentification", msg);
 //mail.send("theoptimizers7@gmail.com", "Aouinti007", "arwa.douiri@esprit.tn", "", "hhhhh");
   
    
    } 
    else {
            
            System.out.println("not found ");
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }



return a;
}


public int nbmedecin()
{int nb=0;

  try {
        
        String sql ="Select count(*) from user where role=?;";
        ste = cnx.prepareCall(sql);
            ste.setString(1, "medecin");
        ResultSet rs;
        rs = ste.executeQuery();
     
        
    
       while(rs.next())
        {
            System.out.println("nb medecin "+rs.getInt(1));
    nb=rs.getInt(1);
       }
    } 
    catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }




return nb;

}

public int nbpatient()
{int nb=0;

  try {
        
        String sql ="Select count(*) from user where role=?;";
        ste = cnx.prepareCall(sql);
            ste.setString(1, "patient");
        ResultSet rs;
        rs = ste.executeQuery();
     
        
    
       while(rs.next())
        {
            System.out.println("nb medecin "+rs.getInt(1));
    nb=rs.getInt(1);
       }
    } 
    catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }




return nb;

}


}
    
  
