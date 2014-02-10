/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.UserDAO;
import Entity.User;
import java.math.BigInteger;
import java.sql.SQLException;
import java.security.*;
/**
 *
 * @author Amine
 */
public class AuthentificationMetier {
    
    private User user;

    public User getUser() {
        return user;
    }
    
    
    
    public AuthentificationMetier(){
        
    }
    
    public boolean verifierAccee(String login, String pwd) throws NoSuchAlgorithmException{
        try {
            user = UserDAO.getInstance().getUserByLogin(login);
            
            if (user == null)
                return false;
            else
            {
                 MessageDigest m= MessageDigest.getInstance("MD5");
             m.update(pwd.getBytes(),0,pwd.length());
             
                if (user.getPassword().equals(new BigInteger(1,m.digest()).toString(16)))
                    return true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("p1");
        }
        catch (SQLException ex2)
        {
            System.out.println("p2");
        }
        
        return false;
    }
}
