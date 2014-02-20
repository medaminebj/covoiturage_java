/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.AuthentificationDAO;
import DAO.BanissementsDAO;
import Entity.Authentification;
import Entity.Session;
import Entity.Banissement;
import java.math.BigInteger;
import java.security.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;
/**
 *
 * @author Amine
 */
public class AuthentificationMetier {
    
    private Authentification user;

    public Authentification getUser() {
        return user;
    }
    
    
    
    public AuthentificationMetier(){
        user = new Authentification();
    }
    
    public boolean verifierAccee(String login, String pwd) throws ProblemeTechniqueException{
        
        //conditions
            if (login.equals("") || pwd.equals(""))
                return false;
        
        
            user = AuthentificationDAO.getInstance().getByLogin(login);
            
            
            if (user == null)
                return false;
            else
            {                
                if (user.getPassword().equals(utils.Functions.ConvertToMd5(pwd)))
                    return true;
                else
                    return false;
                 
            }
    }
    
    public boolean verifierBan(int idAuthentification) throws ProblemeTechniqueException{
        Date myDate = new Date();
            
        Banissement ban = BanissementsDAO.getInstance().getByIdAuthentificationAndDate(idAuthentification, new java.sql.Date(myDate.getTime()));
        
        if (ban == null)
            return false;
        
        Session.getInstance().setMessage("Vous êtes banni jusqu'au "+ ban.getDateFin() + ".\nLa cause: "+ban.getCause());
        return true;
    }
    
    public boolean loginExistant(String login) throws ProblemeTechniqueException{
        
        if (AuthentificationDAO.getInstance().getByLogin(login) == null)
            return false;
        else 
            return true;
    }
}
