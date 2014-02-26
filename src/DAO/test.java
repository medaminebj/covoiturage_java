/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public class test {
    public static void main(String[] args) {
        try {
            Calendar c = Calendar.getInstance();
            c.set(2014, 0, 18);
            System.out.println(""+AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new Date(c.getTime().getTime()), 'c'));
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
