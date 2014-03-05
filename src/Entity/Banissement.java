/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Amine
 */
public class Banissement {
    private int idBanissements;
    private Date dateDebut;
    private Date dateFin;
    private String cause;
    private Authentification user;
    private Administrateur idAdministrateurs;
    
    public Banissement(){
        
    }
    
    public Banissement(int idBanissements, Date dateDebut, Date dateFin, String cause, Authentification user, Administrateur idAdministrateurs) {
        this.idBanissements = idBanissements;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cause = cause;
        this.user = user;
        this.idAdministrateurs = idAdministrateurs;
    }

    public int getIdBanissements() {
        return idBanissements;
    }

    public void setIdBanissements(int idBanissements) {
        this.idBanissements = idBanissements;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Authentification getUser() {
        return user;
    }

    public void setUser(Authentification user) {
        this.user = user;
    }

    public Administrateur getIdAdministrateurs() {
        return idAdministrateurs;
    }

    public void setIdAdministrateurs(Administrateur idAdministrateurs) {
        this.idAdministrateurs = idAdministrateurs;
    }
    
    
}
