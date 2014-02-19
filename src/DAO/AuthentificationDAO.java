/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.List;
import Entity.Authentification;
import java.util.ArrayList;
import utils.Exceptions.ProblemeTechniqueException;
/**
 *
 * @author Amine
 */
public class AuthentificationDAO implements utils.interfaces.DAO<Authentification>{
    
    private static AuthentificationDAO _instance = null;
    
    private Statement statement;
    private PreparedStatement pStatement;
    private String requete;
    private ResultSet resultRequest;
    
    private AuthentificationDAO() 
    {
    }
    
    public static AuthentificationDAO getInstance(){
        if (_instance == null)
            _instance = new AuthentificationDAO();
        
        return _instance;
    }
    
    public Authentification getByLogin(String login) throws ProblemeTechniqueException 
    {
        Authentification result = null;
        
        try {
            requete = "select * from authentifications where login = ?";
            
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1, login);
            resultRequest = pStatement.executeQuery();
            if (resultRequest.next())
            {   
                result = new Authentification();
                
                result.setIdAuthentification(resultRequest.getInt("idAuthentification"));
                result.setLogin(resultRequest.getString("login"));
                result.setPassword(resultRequest.getString("password"));
                result.setType(resultRequest.getString("type").charAt(0));
                result.setDateCreation(resultRequest.getDate("dateCreation"));
                result.setDateDernierModification(resultRequest.getDate("dateDernierModification"));
                
                switch(result.getType()){
                    case 's':
                    case 'a':
                        result.setCompte(AdministrateurDAO.getInstance().getAdministrateurById(resultRequest.getInt("idCompte")));
                        break;
                }
               
               
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }
    
    @Override
    public boolean create(Authentification obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Authentification obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Authentification obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Authentification> getAll() throws ProblemeTechniqueException {
        List<Authentification> result = new ArrayList<>();
        
        try {
            statement = DAO.getInstance().getConnection().createStatement();
            requete = "select * from authentifications";
        
            resultRequest = statement.executeQuery(requete);
            
            Authentification authentification ;
            while(resultRequest.next()){
                authentification = new Authentification();
                
                authentification.setIdAuthentification(resultRequest.getInt("idAuthentification"));
                authentification.setLogin(resultRequest.getString("login"));
                authentification.setPassword(resultRequest.getString("password"));
                authentification.setType(resultRequest.getString("type").charAt(0));
                authentification.setDateCreation(resultRequest.getDate("dateCreation"));
                authentification.setDateDernierModification(resultRequest.getDate("dateDernierModification"));
                
                switch(authentification.getType()){
                    case 's':
                    case 'a':
                        authentification.setCompte(AdministrateurDAO.getInstance().getAdministrateurById(resultRequest.getInt("idCompte")));
                        break;
                }
            
                result.add(authentification);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la liste des users.");
        }
        
        return result;
    }

    @Override
    public Authentification findById(int id) throws ProblemeTechniqueException {
        Authentification result = null;
        
        try {
            requete = "select * from authentifications where idAuthentification = ?";
            
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, id);
            resultRequest = pStatement.executeQuery();
            if (resultRequest.next())
            {
               result = new Authentification();
                
                result.setIdAuthentification(resultRequest.getInt("idAuthentification"));
                result.setLogin(resultRequest.getString("login"));
                result.setPassword(resultRequest.getString("password"));
                result.setType(resultRequest.getString("type").charAt(0));
                result.setDateCreation(resultRequest.getDate("dateCreation"));
                result.setDateDernierModification(resultRequest.getDate("dateDernierModification"));
                
                switch(result.getType()){
                    case 's':
                    case 'a':
                        result.setCompte(AdministrateurDAO.getInstance().getAdministrateurById(resultRequest.getInt("idCompte")));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }

}
