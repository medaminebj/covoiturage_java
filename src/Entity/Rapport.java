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
public class Rapport 
{
    private int idrapport;
    private Date daterapport;
    private String cause;
    private boolean rapporterConducteur;
    private boolean rapporterPassager;
    private Passagers idPassager;
    private Itineraire iditineraire;
    private boolean traiter;

    public Rapport() {
    }

    public Rapport(int idrapport, Date daterapport, String cause, boolean rapporterConducteur, boolean rapporterPassager, Passagers idPassager, Itineraire iditineraire,boolean traiter) {
        this.idrapport = idrapport;
        this.daterapport = daterapport;
        this.cause = cause;
        this.rapporterConducteur = rapporterConducteur;
        this.rapporterPassager = rapporterPassager;
        this.idPassager = idPassager;
        this.iditineraire = iditineraire;
        this.traiter=traiter;
    }

    public int getIdrapport() {
        return idrapport;
    }

    public void setIdrapport(int idrapport) {
        this.idrapport = idrapport;
    }

    public Date getDaterapport() {
        return daterapport;
    }

    public void setDaterapport(Date daterapport) {
        this.daterapport = daterapport;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public boolean isRapporterConducteur() {
        return rapporterConducteur;
    }

    public void setRapporterConducteur(boolean rapporterConducteur) {
        this.rapporterConducteur = rapporterConducteur;
    }

    public boolean isRapporterPassager() {
        return rapporterPassager;
    }

    public void setRapporterPassager(boolean rapporterPassager) {
        this.rapporterPassager = rapporterPassager;
    }

    public Passagers getIdPassager() {
        return idPassager;
    }

    public void setIdPassager(Passagers idPassager) {
        this.idPassager = idPassager;
    }

    public Itineraire getIditineraire() {
        return iditineraire;
    }

    public void setIditineraire(Itineraire iditineraire) {
        this.iditineraire = iditineraire;
    }

    public boolean isTraiter() {
        return traiter;
    }

    public void setTraiter(boolean traiter) {
        this.traiter = traiter;
    }
   
    
}