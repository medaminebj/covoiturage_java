/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Amine
 */
public class Session {
    
    private static Session _instance = null;
    
    private User user;
    
    private Session()
    {
        
    }
    
    public static Session getInstance()
    {
        if (_instance == null)
            _instance = new Session();
        
        return _instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
