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
import DAO.RapportDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class RapportMetier 
{
     private Rapport rapport;
 
 public Rapport getRapport()
 {
     return rapport;
 }
 public RapportMetier()
 {
 
 }
 
 public List<Rapport> getAllRaport() throws SQLException, ClassNotFoundException, ProblemeTechniqueException
 {
     boolean test = false ; 
     List<Rapport> tabRapport = new ArrayList();
     tabRapport = DAO.RapportDAO.getInstance().getRapport();
     if (tabRapport==null)
         return null ; 
     else 
         return tabRapport ; 
 }
 
   public Rapport getRapportByIdRapport(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Rapport tabRapport = new Rapport();
     tabRapport = DAO.RapportDAO.getInstance().getRapportByIdRapport(id);
     if (tabRapport==null)
         return null ; 
     else 
         return tabRapport ; 
    }
 
   public boolean majRapport(Rapport obj) throws ClassNotFoundException, SQLException, ProblemeTechniqueException 
   {
         try 
         {         
             return RapportDAO.getInstance().update(obj);
         } 
         catch (ClassNotFoundException ex)
         {
              System.out.println("problem");
             return false;
         }
   }
}

