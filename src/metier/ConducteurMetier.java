/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entity.Conducteurs;
import Entity.Itineraire;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class ConducteurMetier 
{
    private Conducteurs conducteur;

    public Conducteurs getConducteurs() 
    {
        return conducteur;
    }
    
    public List<Conducteurs> getAllConducteurs() throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     List<Conducteurs> tabConducteurs = new ArrayList();
     tabConducteurs= DAO.ConducteursDAO.getInstance().getAll();
     if (tabConducteurs==null)
         return null ; 
     else 
         return tabConducteurs ; 
     
     
    }
    
     public Conducteurs getConducteursById(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Conducteurs tabConducteurs = new Conducteurs();
     tabConducteurs = DAO.ConducteursDAO.getInstance().getByID(id);
     if (tabConducteurs==null)
         return null ; 
     else 
         return tabConducteurs ; 
     
     
    }
    
}
