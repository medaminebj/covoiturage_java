/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Axel
 */
public class demandes {
    
    private int idDemandes; 
    private String coorDepart; 
    private String coorArrivee; 
    private Date datePublication; 
    private Date dateDepart; 
    private Passagers createdBy;

    public demandes(int idDemandes, String coorDepart, String coorArrivee, Date datePublication, Date dateDepart, Passagers createdBy) {
        this.idDemandes = idDemandes;
        this.coorDepart = coorDepart;
        this.coorArrivee = coorArrivee;
        this.datePublication = datePublication;
        this.dateDepart = dateDepart;
        this.createdBy = createdBy;
    }

    public demandes() {
    }

    public int getIdDemandes() {
        return idDemandes;
    }

    public void setIdDemandes(int idDemandes) {
        this.idDemandes = idDemandes;
    }

    public String getCoorDepart() {
        return coorDepart;
    }

    public void setCoorDepart(String coorDepart) {
        this.coorDepart = coorDepart;
    }

    public String getCoorArrivee() {
        return coorArrivee;
    }

    public void setCoorArrivee(String coorArrivee) {
        this.coorArrivee = coorArrivee;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Passagers getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Passagers createdBy) {
        this.createdBy = createdBy;
    }
    
    
}
