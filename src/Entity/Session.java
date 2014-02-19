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
    
    private Authentification user;
    private boolean estConnecté;
    
    public String message;
    
    private Session()
    {
        estConnecté = false;
    }
    
    public static Session getInstance()
    {
        if (_instance == null)
            _instance = new Session();
        
        return _instance;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Authentification getUser() {
        return user;
    }

    public void setUser(Authentification user) {
        this.user = user;
    }

    public boolean isEstConnecté() {
        return estConnecté;
    }

    public void setEstConnecté(boolean estConnecté) {
        this.estConnecté = estConnecté;
    }
    
    public void connexion(Authentification user)
    {
        this.user = user;
        estConnecté = true;
    }
    
    public void deconnexion()
    {
        this.user = null;
        estConnecté = false;
    }
    
}
