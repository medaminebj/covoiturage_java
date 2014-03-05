/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;

import DAO.AdministrateurDAO;
import DAO.AuthentificationDAO;
import Entity.Administrateur;
import Entity.Authentification;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class tableModelGerrerAdmins extends javax.swing.table.AbstractTableModel{
    private List<Authentification> data;
    private String[] entetes = {"Nom", "Prénom", "Date de naissance" , "Adresse", "Téléphone", "sexe", "login", "date de création"};
    
    public tableModelGerrerAdmins(){
        try {
            data = AuthentificationDAO.getInstance().getAllByType('a');
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGerrerAdmins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Administrateur admin = (Administrateur)data.get(rowIndex).getCompte();
        switch(columnIndex){
            case 0:
                return admin.getNom();
            case 1:
                return admin.getPrenom();
            case 2:
                return admin.getDateNaissance();
            case 3:
                return admin.getAdresse();
            case 4:
                return admin.getNumeroTel();
            case 5:
                return admin.getSexe();
            case 6:
                return data.get(rowIndex).getLogin();
            case 7:
                return data.get(rowIndex).getDateCreation();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
    
    public  Authentification getRowEntity(int rowIndex){
        return data.get(rowIndex);
    }
    
    public boolean refreshData(){
        
        try {
            data = AuthentificationDAO.getInstance().getAllByType('a');
            return true;
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(tableModelGerrerAdmins.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Authentification> getData() {
        return data;
    }
    
    
}
