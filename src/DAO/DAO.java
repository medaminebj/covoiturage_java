/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public class DAO {
    private String user="root";
    private String pass="" ;
    private String url="jdbc:mysql://localhost/covoiturage" ;
    //"jdbc:oracle:thin:@//localhost/xe"
    private String driver= "com.mysql.jdbc.Driver";
    
    private Connection connection;
    
    private static DAO _instance = null;
    
    private DAO() throws ProblemeTechniqueException {
        try {
            
            System.out.println("Chargement du Driever");
            Class.forName(driver);
            System.out.println("Driver chargé avec succès");
            
            connection=DriverManager.getConnection(url, user, pass);
            System.out.println("Connexion établie.");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Probleme lors du chargement du driver.");
            throw new utils.Exceptions.ProblemeTechniqueException();
        } catch (SQLException ex) {
            System.out.println("Probleme lors de l'acces à la base.");
            throw new utils.Exceptions.ProblemeTechniqueException();
        }
    }
    
    public static DAO getInstance() throws ProblemeTechniqueException
    {
        if (_instance == null)
            _instance = new DAO();
        
        return _instance;
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}
