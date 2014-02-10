/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Amine
 */
public class DAO {
    private String user="root";
    private String pass="" ;
    private String url="jdbc:mysql://localhost/gggg" ;
    //"jdbc:oracle:thin:@//localhost/xe"
    private String driver= "com.mysql.jdbc.Driver";
    
    private Connection connection;
    
    private static DAO _instance = null;
    
    private DAO() throws ClassNotFoundException, SQLException{
        System.out.println("Chargement du Driever");
        Class.forName(driver);
        System.out.println("Driver chargé avec succès");
        
        connection=DriverManager.getConnection(url, user, pass);
        System.out.println("Connexion établie.");
    }
    
    public static DAO getInstance() throws ClassNotFoundException, SQLException
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
