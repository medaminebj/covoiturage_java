/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entity.Passagers;
import Entity.Rapport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class PassagerMetier 
{
    private Passagers passager;

    public Passagers getPassagers() 
    {
        return passager;
    }
    public List<Passagers> getAllPassagers() throws SQLException, ClassNotFoundException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     List<Passagers> tabPassagers = new ArrayList();
     tabPassagers = DAO.PassagersDAO.getInstance().getAll();
     if (tabPassagers==null)
         return null ; 
     else 
         return tabPassagers ; 
     
     
    }
    
     public Passagers getPassagersById(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Passagers tabPassagers = new Passagers();
     tabPassagers = DAO.PassagersDAO.getInstance().getPassagerById(id);
     if (tabPassagers==null)
         return null ; 
     else 
         return tabPassagers ; 
     
     
    }
}
