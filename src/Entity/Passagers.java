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
public class Passagers {
    private int idPassagers;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroTel;
    private String adresse;
    private double note;
    private double ProfileCalcule;
    private char sexe;
    private String urlImageProfil;
    private String email;

    public Passagers(int idPassagers, String nom, String prenom, Date dateNaissance, String numeroTel, String adresse, double note, double ProfileCalcule, char sexe, String urlImageProfil, String email) {
        this.idPassagers = idPassagers;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroTel = numeroTel;
        this.adresse = adresse;
        this.note = note;
        this.ProfileCalcule = ProfileCalcule;
        this.sexe = sexe;
        this.urlImageProfil = urlImageProfil;
        this.email = email;
    }
    
    
    
    public Passagers(){
        
    }

    public int getIdPassagers() {
        return idPassagers;
    }

    public void setIdPassagers(int idPassagers) {
        this.idPassagers = idPassagers;
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

    public double getProfileCalcule() {
        return ProfileCalcule;
    }

    public void setProfileCalcule(double ProfileCalcule) {
        this.ProfileCalcule = ProfileCalcule;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
