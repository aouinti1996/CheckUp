
package com.esprit.entities;
/**
 *
 * @author msi
 */
public class User {
   
    private String nom;
    private String prenom;
 private String   password;
private String numerotelephone;
private String adresse;
private String email;
private int id;
private String date_naissance;
private String role;
private String specialite;
   


    public User() {
    }

    public User(int id,String nom, String prenom, String date_naissance,String email, String password, String numerotelephone, String adresse, String specialite,String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance=date_naissance;
        this.password = password;
        this.numerotelephone = numerotelephone;
        this.adresse = adresse;
       this.date_naissance=date_naissance;
         this.specialite=specialite;
        this.email = email;
        this.id=id;
        this.email=email;
    }

    public User(String nom, String prenom,String date_naissance,String email, String password, String numerotelephone, String adresse, String specialite,String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.numerotelephone = numerotelephone;
        this.adresse = adresse;
        this.email = email;
        this.date_naissance=date_naissance;
      
     this.role=role;
        this.specialite = specialite;
    }

    public User(String nom, String prenom, String date_naissance, String email, String numerotelephone, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.numerotelephone = numerotelephone;
        this.adresse = adresse;
        this.email = email;
    
        this.date_naissance = date_naissance;
    }


    public User(String nom, String prenom, String date_naissance,  String email,String numerotelephone, String adresse, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.numerotelephone = numerotelephone;
        this.adresse = adresse;
        this.email = email;
        this.date_naissance = date_naissance;
        this.specialite = specialite;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumerotelephone() {
        return numerotelephone;
    }

    public void setNumerotelephone(String numerotelephone) {
        this.numerotelephone = numerotelephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}