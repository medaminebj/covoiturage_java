/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entity.Conducteurs;
import Entity.Voiture;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class VoitureMetier 
{
    private Voiture voiture;

    public VoitureMetier() 
    {
        
    }

    public VoitureMetier(Voiture voiture) {
        this.voiture = voiture;
    }

    
    
    public Voiture getVoiture() 
    {
        return voiture;
    }
    
    
     public List<Voiture> getAllVoiture() throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     List<Voiture> tabVoiture = new ArrayList();
     tabVoiture = DAO.VoitureDAO.getInstance().getVoiture();
     if (tabVoiture==null)
         return null ; 
     else 
         return tabVoiture ; 
     
     
    }
    
     public Voiture getVoitureById(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Voiture tabVoiture = new Voiture();
     tabVoiture = DAO.VoitureDAO.getInstance().getVoitureById(id);
     if (tabVoiture==null)
         return null ; 
     else 
         return tabVoiture ; 
     
     
    }
    
    
    
}
