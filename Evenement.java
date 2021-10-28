package Entité;

import java.sql.Date;

/**
 *
 * @author lotfi
 */
public class Evenement {
   private int ideven;
   private String titreeven;
    private String descriptioneven;
    private Date datedebut;
    private Date datefin;
    private String lieueven;
    private String invitees;
    private String respensable;
    
    
    public Evenement()
    {
        //Empty Constructor
    }
    public Evenement(String titreeven, String descriptioneven, Date datedebut,Date datefin,String lieueven,String invitees,String respensable) {
   
        this.titreeven = titreeven;
        this.descriptioneven = descriptioneven;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.lieueven = lieueven;
        this.invitees = invitees;
        this.respensable = respensable;
    }
    
     
    public Evenement(int ideven, String titreeven, String descriptioneven, Date datedebut,Date datefin,String lieueven,String invitees,String respensable) {
        this.ideven = ideven;
        this.titreeven = titreeven;
        this.descriptioneven = descriptioneven;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.lieueven = lieueven;
        this.invitees = invitees;
        this.respensable = respensable;
    }

    public int getIdeven() {
        return ideven;
    }

    public void setIdeven(int ideven) {
        this.ideven = ideven;
    }

    public String getTitreeven() {
        return titreeven;
    }

    public void setTitreeven(String titreeven) {
        this.titreeven = titreeven;
    }

    public String getDescriptioneven() {
        return descriptioneven;
    }

    public void setDescriptioneven(String descriptioneven) {
        this.descriptioneven = descriptioneven;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getLieueven() {
        return lieueven;
    }

    public void setLieueven(String lieueven) {
        this.lieueven = lieueven;
    }

    public String getInvitees() {
        return invitees;
    }

    public void setInvitees(String invitees) {
        this.invitees = invitees;
    }

    public String getRespensable() {
        return respensable;
    }

    public void setRespensable(String respensable) {
        this.respensable = respensable;
    }

    @Override
    public String toString() {
        return "Evenement{" + "ideven=" + ideven + ", titreeven=" + titreeven + ", descriptioneven=" + descriptioneven + ", datedebut=" + datedebut + ", datefin=" + datefin + ", lieueven=" + lieueven + ", invitees=" + invitees + ", respensable=" + respensable + '}';
    }
    
    
    
    
    
    
    
}
