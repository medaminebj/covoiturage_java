/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import Entity.Banissement;
import DAO.BanissementsDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class BanissementMetier 
{
    private Banissement banir;

    public Banissement getBanir() {
        return banir;
    }
    
    
    public BanissementMetier()
    {
        banir= new Banissement();
    }
    
    public boolean InsererBann(Banissement obj)
    {
        try {
            return BanissementsDAO.getInstance().create(obj);
            
        } catch (ProblemeTechniqueException ex)
        {
            System.out.println("problem");
            return false;
        }
    }
    
    public  boolean  MajBann(Banissement obj)
    {
        try 
        {
            return BanissementsDAO.getInstance().update(obj);
        } 
        catch (ProblemeTechniqueException ex) 
        {
            System.out.println("problem");
            return false;
        }
       
    }
    
}
   