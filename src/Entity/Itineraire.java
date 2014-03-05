/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;


/**
 *
 * @author user
 */
public class Itineraire 
{
    private int iditineraire;
    private Conducteurs idConducteur;
    private String description;
    private boolean estpublic;
    private Date dateitineraire;
    private double prix;
    private boolean estconfirmer;
    private double distanceitineraire;
    private Date datepublication;

    public Itineraire() {
    }

    public Itineraire(int iditineraire, Conducteurs idConducteur, String description, boolean estpublic, Date dateitineraire, double prix, boolean estconfirmer, double distanceitineraire, Date datepublication) {
        this.iditineraire = iditineraire;
        this.idConducteur = idConducteur;
        this.description = description;
        this.estpublic = estpublic;
        this.dateitineraire = dateitineraire;
        this.prix = prix;
        this.estconfirmer = estconfirmer;
        this.distanceitineraire = distanceitineraire;
        this.datepublication = datepublication;
    }

    public Itineraire(int iditineraire) {
        this.iditineraire = iditineraire;
    }

    
    public int getIditineraire() {
        return iditineraire;
    }

    public void setIditineraire(int iditineraire) {
        this.iditineraire = iditineraire;
    }

    public Conducteurs getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Conducteurs idConducteur) {
        this.idConducteur = idConducteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEstpublic() {
        return estpublic;
    }

    public void setEstpublic(boolean estpublic) {
        this.estpublic = estpublic;
    }

    public Date getDateitineraire() {
        return dateitineraire;
    }

    public void setDateitineraire(Date dateitineraire) {
        this.dateitineraire = dateitineraire;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isEstconfirmer() {
        return estconfirmer;
    }

    public void setEstconfirmer(boolean estconfirmer) {
        this.estconfirmer = estconfirmer;
    }

    public double getDistanceitineraire() {
        return distanceitineraire;
    }

    public void setDistanceitineraire(double distanceitineraire) {
        this.distanceitineraire = distanceitineraire;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }
 

   
   
    
}
