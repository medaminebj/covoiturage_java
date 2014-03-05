/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import javax.print.DocFlavor;

/**
 *
 * @author sabri
 */
public class Conducteurs {
    private int idConducteurs;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroTel;
    private String adresse;
    private double note;
    private boolean permisApprouver;
    private boolean numTelVerifier;
    private double ProfileCalcule;
    private Voiture idVoitures;
    private char sexe;
    private String urlImageProfil;
    private String urlImagePermis;
    private String email ; 

    public Conducteurs() {
    }

    public Conducteurs(int idConducteurs, String nom, String prenom, Date dateNaissance, String numeroTel, String adresse, double note, boolean permisApprouver, boolean numTelVerifier, double ProfileCalcule, Voiture idVoitures, char sexe, String urlImageProfil, String urlImagePermis , String email) {
        this.idConducteurs = idConducteurs;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.note = note;
        this.permisApprouver = permisApprouver;
        this.numTelVerifier = numTelVerifier;
        this.ProfileCalcule = ProfileCalcule;
        this.idVoitures = idVoitures;
        this.sexe = sexe;
        this.urlImageProfil = urlImageProfil;
        this.urlImagePermis = urlImagePermis;
        this.email= email ; 
    }

    public int getIdConducteurs() {
        return idConducteurs;
    }

    public void setIdConducteurs(int idConducteurs) {
        this.idConducteurs = idConducteurs;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public boolean getPermisApprouver() {
        return permisApprouver;
    }

    public void setPermisApprouver(boolean permisApprouver) {
        this.permisApprouver = permisApprouver;
    }

    public boolean getNumTelVerifier() {
        return numTelVerifier;
    }

    public void setNumTelVerifier(boolean numTelVerifier) {
        this.numTelVerifier = numTelVerifier;
    }

    public double getProfileCalcule() {
        return ProfileCalcule;
    }

    public void setProfileCalcule(double ProfileCalcule) {
        this.ProfileCalcule = ProfileCalcule;
    }

    public Voiture getIdVoitures() {
        return idVoitures;
    }

    public void setIdVoitures(Voiture idVoitures) {
        this.idVoitures = idVoitures;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getUrlImageProfil() {
        return urlImageProfil;
    }

    public void setUrlImageProfil(String urlImageProfil) {
        this.urlImageProfil = urlImageProfil;
    }

    public String getUrlImagePermis() {
        return urlImagePermis;
    }

    public void setUrlImagePermis(String urlImagePermis) {
        this.urlImagePermis = urlImagePermis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
