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
public class Conducteur 
{
    private int idconducteur;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String numerotel;
    private String adresse;
    private double note;
    private boolean permisapprouver;
    private boolean numtelverifier;
    private double profilecalcule;
    private Voiture idvoiture;
    private char sexe;
    private String urlImageProfil;
    private String urlImagePermis;
    private String email;

    public Conducteur() {
    }

    public Conducteur(int idconducteur, String nom, String prenom, Date datenaissance, String numerotel, String adresse, double note, boolean permisapprouver, boolean numtelverifier, double profilecalcule, Voiture idvoiture, char sexe) {
        this.idconducteur = idconducteur;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.numerotel = numerotel;
        this.adresse = adresse;
        this.note = note;
        this.permisapprouver = permisapprouver;
        this.numtelverifier = numtelverifier;
        this.profilecalcule = profilecalcule;
        this.idvoiture = idvoiture;
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

    public int getIdconducteur() {
        return idconducteur;
    }

    public void setIdconducteur(int idconducteur) {
        this.idconducteur = idconducteur;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(String numerotel) {
        this.numerotel = numerotel;
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

    public boolean isPermisapprouver() {
        return permisapprouver;
    }

    public void setPermisapprouver(boolean permisapprouver) {
        this.permisapprouver = permisapprouver;
    }

    public boolean isNumtelverifier() {
        return numtelverifier;
    }

    public void setNumtelverifier(boolean numtelverifier) {
        this.numtelverifier = numtelverifier;
    }

    public double getProfilecalcule() {
        return profilecalcule;
    }

    public void setProfilecalcule(double profilecalcule) {
        this.profilecalcule = profilecalcule;
    }

    public Voiture getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(Voiture idvoiture) {
        this.idvoiture = idvoiture;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    

    
    
}
