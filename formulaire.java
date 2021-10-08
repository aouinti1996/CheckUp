/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetpidev;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class formulaire {
     public int id;
     public String nom;
    public String prenom;
   public String dateNaissance;
    public String addresse;
    private int numtel;
    
    
    public formulaire(){

}
public formulaire(int id , String nom, String prenom , String dateNaissance,String addresse,int numtel){
this.id =id;
this.nom=nom;
this.prenom=prenom;
this.dateNaissance= dateNaissance;
this.addresse=addresse;
this.numtel=numtel;


}
public formulaire( String nom, String prenom , String dateNaissance,String addresse,int numtel){

    this.nom=nom;
    this.prenom=prenom;
    this.dateNaissance= dateNaissance;
    this.addresse=addresse;
    this.numtel=numtel;
}
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateNaissance
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    
    public String getAdresse() {
        return addresse;
    }

   
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }
    
    @Override
    public String toString() {
        return "formulaire{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +",numtel=" + numtel+", addresse=" + addresse+",dateNaissance=" +dateNaissance+'}';
    }
    
    
    
}


