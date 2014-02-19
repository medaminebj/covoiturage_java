/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Administrateur;

/**
 *
 * @author Amine
 */
public class AdministrateurDAO {
    
    private static AdministrateurDAO _instance = null;
    
    private AdministrateurDAO(){
        
    }
    
    public static AdministrateurDAO getInstance(){
        if (_instance == null)
            _instance = new AdministrateurDAO();
        return _instance;
    }
    
    public Administrateur getAdministrateurById(int idAdministrateur)
    {
        return new Administrateur();
    }
}
