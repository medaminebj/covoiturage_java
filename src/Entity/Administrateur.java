/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
/**
 *
 * @author Axel
 */
public class Administrateur {
    private int idAdministrateurs ; 
    private String nom ;
    private String prenom ; 
    private String adresse ; 
    private String numeroTel ; 
    private Date dateNaissance ; 
    private int estSuper ; 
    private char sexe ; 
    private String email ; 

    public Administrateur(int idAdministrateurs, String nom, String prenom, String adresse, String numeroTel, Date dateNaissance, int estSuper, char sexe,String email) {
        this.idAdministrateurs = idAdministrateurs;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
        this.dateNaissance = dateNaissance;
        this.estSuper = estSuper;
        this.sexe = sexe;
        this.email = email ; 
    }
    
    public Administrateur()
    {
        
    }

    public Administrateur(int idAdministrateurs, String nom, String prenom, String adresse, String numeroTel, Date dateNaissance, char sexe , String email) {
        this.idAdministrateurs = idAdministrateurs;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTel = numeroTel;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.email = email ; 
    }

   
    
    public int getIdAdministrateurs() {
        return idAdministrateurs;
    }

    public void setIdAdministrateurs(int idAdministrateurs) {
        this.idAdministrateurs = idAdministrateurs;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getEstSuper() {
        return estSuper;
    }

    public void setEstSuper(int estSuper) {
        this.estSuper = estSuper;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
