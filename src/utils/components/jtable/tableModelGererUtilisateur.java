/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;

import DAO.AuthentificationDAO;
import Entity.Administrateur;
import Entity.Authentification;
import Entity.Conducteurs;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author sabri
 */
public class tableModelGererUtilisateur extends javax.swing.table.AbstractTableModel{
       private List<Authentification> data;
    private String[] entetes = {"Nom", "Prénom", "Date de naissance" , "Adresse", "Téléphone", "sexe", "login", "date de création" ,"E-mail"};
    
    public tableModelGererUtilisateur(){
        try {
            data = AuthentificationDAO.getInstance().getAllByType('c');
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGerrerAdmins.class.getName()).log(Level.SEVERE, null, ex);
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
        
        Conducteurs conducteur = (Conducteurs)data.get(rowIndex).getCompte();
        switch(columnIndex){
            case 0:
                return conducteur.getNom();
            case 1:
                return conducteur.getPrenom();
            case 2:
                return conducteur.getDateNaissance();
            case 3:
                return conducteur.getAdresse();
            case 4:
                return conducteur.getNumeroTel();
            case 5:
                return conducteur.getSexe();
            case 6:
                return data.get(rowIndex).getLogin();
            case 7:
                return data.get(rowIndex).getDateCreation();
            case 8:
                return conducteur.getEmail();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public  Authentification getRowEntity(int rowIndex){
        return data.get(rowIndex);
    }
    
    public boolean refreshData(){
        
        try {
            data = AuthentificationDAO.getInstance().getAllByType('c');
            return true;
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGererUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
}
