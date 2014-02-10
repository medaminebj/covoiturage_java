/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Amine
 */
public class User {
    private String login;
    private String password;
    private char type;
    
    public User()
    {
        
    }
    
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    
    public User(String login, String password, char type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    
}
