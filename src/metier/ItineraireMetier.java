/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entity.Itineraire;
import Entity.Passagers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class ItineraireMetier 
{
    private Itineraire itineraire;

     public ItineraireMetier()
    {
    
    }
    
    public Itineraire getItineraire() 
    {
        return itineraire;
    }
    
   public List<Itineraire> getAllItineraire() throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     List<Itineraire> tabItineraire = new ArrayList();
     tabItineraire = DAO.ItineraireDAO.getInstance().getItineraire();
     if (tabItineraire==null)
         return null ; 
     else 
         return tabItineraire ; 
     
     
    }
    
     public Itineraire getItineraireById(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Itineraire tabItineraire = new Itineraire();
     tabItineraire = DAO.ItineraireDAO.getInstance().getItineraireById(id);
     if (tabItineraire==null)
         return null ; 
     else 
         return tabItineraire ; 
     
     
    }
     
    public boolean VerfierAncienItineraire(int id) throws ProblemeTechniqueException
    {
      boolean test = false ; 
      Itineraire itineraire = new Itineraire();
        try {
                itineraire = DAO.ItineraireDAO.getInstance().getAncienItineraireByID(id);
                if (itineraire.getDateitineraire()==null)
                    return false;
                else return true ;
        } catch (SQLException ex) {
            return false;
          } catch (ClassNotFoundException ex) {
            return false;
        }
     }
    
     public boolean VerfierNewItineraire(int id) throws ProblemeTechniqueException
    {
      boolean test = false ; 
      Itineraire itineraire = new Itineraire();
        try {
                itineraire = DAO.ItineraireDAO.getInstance().getNewItineraireByID(id);
                if (itineraire.getDateitineraire()==null) 
                    return false;
                else return true ;
        } catch (SQLException ex) {
            return false;
          } catch (ClassNotFoundException ex) {
            return false;
        }
     }
}
