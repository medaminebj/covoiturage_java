/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitaires;

import Entity.Authentification;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public class Authentifications {
    Authentification authentification;
    
    public Authentifications() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        authentification = null;
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void test1() {
        try{
        authentification = DAO.AuthentificationDAO.getInstance().findById(-1);
        assertEquals(null, authentification);
        }catch (ProblemeTechniqueException ex){
            System.out.println("Probleme lors du test de la fonction test1");
        }
     }
     
     @Test
     public void rechercheById(){
        try {
            authentification = DAO.AuthentificationDAO.getInstance().findById(1);
            assertEquals("l'id est egale a 1", 1, authentification.getIdAuthentification());
            
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(Authentifications.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     @Test
     public void getNumberByTypeErr1()
     {
        try {
            assertEquals("il n'y pas un type b", DAO.AuthentificationDAO.getInstance().getNumberByType('b'),0);
        } catch (ProblemeTechniqueException ex) {
            Logger.getLogger(Authentifications.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /*@Test
     public void modification() {
         authentification = new Authentification();
     }*/
}