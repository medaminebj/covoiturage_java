
import DAO.BanissementsDAO;
import DAO.ItineraireDAO;
import DAO.VilleItineraireDAO;
import Entity.Banissement;
import Entity.Conducteurs;
import Entity.Itineraire;
import Entity.VilleItineraire;
import Entity.delegations;
import Entity.gouvernorats;
import Entity.localites;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Axel
 */
public class test {
    
    public static void main(String args[]) throws ProblemeTechniqueException {
     
            Itineraire i= new Itineraire();
            List <Entity.VilleItineraire> v = new ArrayList<>();
            Entity.VilleItineraire vv = new VilleItineraire();
            Entity.gouvernorats g = new gouvernorats();
            Entity.delegations d = new delegations();
            Entity.localites l = new localites();
        try {
                l = DAO.localitesDAO.getInstance().GetLocalitesById(6087);
               
                /*g = DAO.gouvernoratsDAO.getInstance().GetGouverneratById(49);
                d = DAO.delegationsDAO.getInstance().GetDelegationByIdGouvernerat(g.getIdGouvernorats());
                l = DAO.localitesDAO.getInstance().GetLocalitesByIdDelegation(d.getIdDelegations());*/
                System.out.println(l.getIdDelegations().getIdGouvernorats().getNomGouvernorat());
                
                /* vv = VilleItineraireDAO.getInstance().FindVilleDepart(3);
                int id = vv.getIdLocalites().getIdLocalites();
                int idd = DAO.delegationsDAO.getInstance.;*/
                
                 /*for(int j=0;j<v.size();j++)
                 {
                   // i = ItineraireDAO.getInstance().getItineraireById(v.get(j).getIdItineraires().getIditineraire());
                     System.out.println(v.get(j).getIdLocalites().getNomLocalite());
                 }*/
                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    
    
    }
}