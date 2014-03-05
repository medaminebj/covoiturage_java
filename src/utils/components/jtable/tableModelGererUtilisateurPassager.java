/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;

import DAO.AuthentificationDAO;
import Entity.Administrateur;
import Entity.Authentification;
import Entity.Passagers;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author sabri
 */
public class tableModelGererUtilisateurPassager extends javax.swing.table.AbstractTableModel{
           private List<Authentification> data;
    private String[] entetes = {"Nom", "Prénom", "Date de naissance" , "Adresse", "Téléphone", "sexe", "login", "date de création" , "E-mail"};
    
    public tableModelGererUtilisateurPassager(){
        try {
            data = AuthentificationDAO.getInstance().getAllByType('p');
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGererUtilisateurPassager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
    
    public int getColumnCount() {
        return entetes.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Passagers passager = (Passagers)data.get(rowIndex).getCompte();
        switch(columnIndex){
            case 0:
                return passager.getNom();
            case 1:
                return passager.getPrenom();
            case 2:
                return passager.getDateNaissance();
            case 3:
                return passager.getAdresse();
            case 4:
                return passager.getNumeroTel();
            case 5:
                return passager.getSexe();
            case 6:
                return data.get(rowIndex).getLogin();
            case 7:
                return data.get(rowIndex).getDateCreation();
            case 8:
                return passager.getEmail();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public  Authentification getRowEntity(int rowIndex){
        return data.get(rowIndex);
    }
    
    public boolean refreshData(){
        
        try {
            data = AuthentificationDAO.getInstance().getAllByType('p');
            return true;
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGererUtilisateurPassager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
}
