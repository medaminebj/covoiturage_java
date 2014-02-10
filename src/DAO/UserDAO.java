/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.List;
import Entity.User;
import java.util.ArrayList;
/**
 *
 * @author Amine
 */
public class UserDAO{
    
    private static UserDAO _instance = null;
    
    private Statement statement;
    private String requete;
    private ResultSet resultRequest;
    
    private UserDAO() throws ClassNotFoundException, SQLException
    {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static UserDAO getInstance() throws ClassNotFoundException, SQLException{
        if (_instance == null)
            _instance = new UserDAO();
        
        return _instance;
    }
    
    public List<User> getUsers() throws SQLException{
        List<User> result = new ArrayList<>();
        
        requete = "select * from authentifications";
        resultRequest = statement.executeQuery(requete);
        
        while(resultRequest.next())
        {
            //System.out.println("Login:" + resultRequest.getString(1) + " pwd: " + resultRequest.getString(2) + " type: "+ resultRequest.getString(3));
            result.add(new User(resultRequest.getString(1), resultRequest.getString(2), resultRequest.getString(3).charAt(0)));
        }
        
        return result;
    }
    
    public User getUserByLogin(String login) throws SQLException
    {
        User result = null;
        
        requete = "select * from authentifications where Login = '" + login + "'";
        resultRequest = statement.executeQuery(requete);
        
        if (resultRequest.next())
        {
           result = new User(resultRequest.getString(1), resultRequest.getString(2), resultRequest.getString(3).charAt(0));
        }
        
        return result;
    }
}
