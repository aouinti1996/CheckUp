/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import java.sql.Date;

/**
 *
 * @author lotfi
 */
public class Evenement {
   private int ideven;
   private String nomeven;
   private String dateeven;
    private String descriptioneven;
    
public Evenement() {};
/*public Evenement(Integer ideven) {
        this.ideven = ideven;
    }
public Evenement(String dateeven, String descriptioneven) {
        this.dateeven = dateeven;
        this.descriptioneven = descriptioneven;
    }*/
public Evenement(String nomeven,String dateeven, String descriptioneven) {
   
        this.nomeven = nomeven;
        this.dateeven = dateeven;
        this.descriptioneven = descriptioneven;
    }
     public Evenement(Integer ideven,String nomeven, String dateeven, String descriptioneven) {
         
        
        this.ideven = ideven;
        this.nomeven = nomeven;
        this.dateeven = dateeven;
        this.descriptioneven = descriptioneven;
}

    public int getIdeven() {
        return ideven;
    }

    public String getNomeven() {
        return nomeven;
    }

    public String getDateeven() {
        return dateeven;
    }

    public String getDescriptioneven() {
        return descriptioneven;
    }

    public void setIdeven(int ideven) {
        this.ideven = ideven;
    }

    public void setNomeven(String nomeven) {
        this.nomeven = nomeven;
    }

    public void setDateeven(String dateeven) {
        this.dateeven = dateeven;
    }

    public void setDescriptioneven(String descriptioneven) {
        this.descriptioneven = descriptioneven;
    }

    @Override
    public String toString() {
        return "Evenement{" + "ideven=" + ideven + ", nomeven=" + nomeven + ", dateeven=" + dateeven + ", descriptioneven=" + descriptioneven + '}';
    }
 
}

