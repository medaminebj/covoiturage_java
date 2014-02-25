/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;
import DAO.AdministrateurDAO;
import DAO.AuthentificationDAO;
import Entity.Administrateur;
import Entity.Authentification;
import java.math.BigInteger;
import java.sql.SQLException;
import java.security.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;
/**
 *
 * @author Axel
 */
public class AdministrateurMetier {
    
     private Administrateur admins;
   

    public Administrateur getAdmins() {
        return admins;
    }
   

    public AdministrateurMetier() 
    {
       admins = new  Administrateur();
      
    }
    
    
    public List GetAdmins()
    {
       List <Administrateur> TabAdmins = new ArrayList<> ();
         try {
             TabAdmins =  AdministrateurDAO.getInstance().getAll(); 
         } catch (ProblemeTechniqueException ex) {
             System.out.println("erreur");
         }
       if (admins == null)
                return null;
        else
        {
           return TabAdmins ; 
        }
       
       
    }
    
    public boolean VerifierAdminsInser(String nom , String prenom , String adresse , String numTel  , char Sexe)
    {
        if (nom.equals("") || prenom.equals("") || adresse.equals("") || numTel.equals("") )
            return false ;
        else
            return true ;
    }
    
    public boolean InsererAdmin (Authentification obj) 
    {
      
        try {
                AdministrateurDAO.getInstance().create((Administrateur)obj.getCompte());
            } catch (ProblemeTechniqueException ex) {
               System.out.println("problem");
               return false ; 
            }
         
        return true;
        
        }
        
    
    
    public boolean DeleteAdmin (Administrateur obj) throws ProblemeTechniqueException
    {
        return AdministrateurDAO.getInstance().delete(obj) ; 
    }
    
}
