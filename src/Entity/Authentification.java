/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Amine
 */
public class Authentification {
    private int idAuthentification ;
    private String login;
    private String password;
    private char type;
    private Object Compte;
    private Date dateCreation;
    private Date dateDernierModification ; 
    
    
    public Authentification()
    {
        
    }

    public Authentification(int idAuthentification, String login, String password, char type, Object compte, Date dateCreation, Date dateDernierModification) {
        this.idAuthentification = idAuthentification;
        this.login = login;
        this.password = password;
        this.type = type;
        switch (type){
            case 's':
            case 'a':
                this.Compte = (Administrateur)compte;
                break;
        }
        this.dateCreation = dateCreation;
        this.dateDernierModification = dateDernierModification;
    }
    
    public Authentification(String login, String password ) {
        this.login = login;
        this.password = password;
    }
    
    public Authentification(String login, String password, char type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    
    public String getLogin() {
        return login;
    }

    public int getIdAuthentification() {
        return idAuthentification;
    }

    public void setIdAuthentification(int idAuthentification) {
        this.idAuthentification = idAuthentification;
    }

    public Object getCompte() {
        return Compte;
    }

    public void setCompte(Object compte) {
        switch(type){
            case 's':
            case 'a':
                this.Compte = (Administrateur)compte;
                break;
        }
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDernierModification() {
        return dateDernierModification;
    }

    public void setDateDernierModification(Date dateDernierModification) {
        this.dateDernierModification = dateDernierModification;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    
}