
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
     
                 String matche = "2000/10/10";
		//Pattern p2=Pattern.compile("^(29/02/((19|20)(0[48]|[2468][048]|[13579][26])|2000))|" +
		//"(((0[1-9]|1\\d|2[0-8])/(0[1-9]|1[0-2])/)|((29|30)/(0[13-9]|1[0-2])/)|(31/(0[13578]|1[02]))/((19|20)\\d\\d))$");
                
                
                Pattern p=Pattern.compile("^(29/02/((19|20)(0[48]|[2468][048]|[13579][26])|2000))|(31/(0[13578]|1[02])/(19|20)\\d\\d)|((29|30)/(0[13-9]|1[0-2])/(19|20)\\d\\d)|((0[1-9]|1\\d|2[0-8])/(0[1-9]|1[0-2])/(19|20)\\d\\d)$");
                
                
                
		Matcher m=p.matcher(matche);
                if (m.matches()){
			                 System.out.println("Date correct");
		}
		else {
			System.out.println("Date incorrect");
		}
        
    
    
    }
}