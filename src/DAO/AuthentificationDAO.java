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
    
    public List<Authentification> getAllByType(char type) throws ProblemeTechniqueException {
        List<Authentification> result = new ArrayList<>();
        
        try {
            statement = DAO.getInstance().getConnection().createStatement();
            requete = "select * from authentifications where type = '"+type+"'";
        
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
                        authentification.setCompte(AdministrateurDAO.getInstance().findById(resultRequest.getInt("idCompte")));
                        break;
                }
            
                result.add(authentification);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la liste des users.");
        }
        
        return result;
    }
    
    public int getNumberByType(char type) throws ProblemeTechniqueException{
        try {       
            requete = "select count(idAuthentification) from authentifications where type = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1, type+"");
            
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next())
                return resultRequest.getInt(1);
            return -1;
        } catch (SQLException ex) {
            System.out.println("Probleme lors du getNumberByType.");
            throw new ProblemeTechniqueException();
        }
        
    }
    
    public int getNumberByTypeAndYear(int year, char type) throws ProblemeTechniqueException{
        try {       
            requete = "select count(idAuthentification) from authentifications where type = ? and extract(year from dateCreation) = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1, type+"");
            pStatement.setInt(2, year);
            
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next())
                return resultRequest.getInt(1);
            return -1;
        } catch (SQLException ex) {
            System.out.println("Probleme lors du getNumberByType.");
            throw new ProblemeTechniqueException();
        }
        
    }
    
    public int getNumberByDateCreationInMonth(int year, int monthNumber, char type) throws ProblemeTechniqueException{
        try {
            
            requete = "SELECT count(idAuthentification) FROM authentifications WHERE extract(year from dateCreation) = ? and extract(month from dateCreation) = ?";
            
            if (type != ' ')
            {
                requete += " AND type = ?";
            }
            
            
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, year);
            pStatement.setInt(2, monthNumber);
            
            if (type != ' ')
            {
                pStatement.setString(3, type+"");
            }
            
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next())
                return resultRequest.getInt(1);
            else
                return 0;
            
        }catch (SQLException ex) {
            System.out.println("probleme getNumberByDateCreationInMonth");
        }
        return 0;
    }
    
    public int getNumberByDateCreationInDay(Date date, char type) throws ProblemeTechniqueException{
        try {
            
            requete = "SELECT count(idAuthentification) FROM authentifications WHERE dateCreation = ? ";
            
            if (type != ' ')
            {
                requete += " AND type = ?";
            }
            
            
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setDate(1, date);
            
            if (type != ' ')
            {
                pStatement.setString(2, type+"");
            }
            
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next())
                return resultRequest.getInt(1);
            else
                return 0;
            
        }catch (SQLException ex) {
            System.out.println("probleme getNumberByDateCreationInDay");
        }
        return 0;
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
                        result.setCompte(AdministrateurDAO.getInstance().findById(resultRequest.getInt("idCompte")));
                        break;
                }
               
               
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
            throw new ProblemeTechniqueException();
        }
        
        return result;
    }
    
    @Override
    public boolean create(Authentification obj) throws ProblemeTechniqueException {
        try {
            int id=0;
            
            //on ajout le compte relative a l'authentification
            switch(obj.getType()){
                case 's':
                case 'a':
                    Entity.Administrateur admin = (Entity.Administrateur) obj.getCompte();
                    requete = "INSERT INTO administrateurs(nom, prenom, adresse, numeroTel, dateNaissance, sexe) VALUES (?, ?, ?, ?, ?, ?)";
                    pStatement = DAO.getInstance().getConnection().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
                    pStatement.setString(1, admin.getNom());
                    pStatement.setString(2, admin.getPrenom());
                    pStatement.setString(3, admin.getAdresse());
                    pStatement.setString(4, admin.getNumeroTel());
                    pStatement.setDate(5, new Date(new java.util.Date().getTime()));
                    pStatement.setString(6, admin.getSexe()+"");
                    
                    break;
                case 'p':
                    Entity.Passager passager = (Entity.Passager) obj.getCompte();
                    
                    requete = "INSERT INTO passagers(nom, prenom, email, sexe) VALUES (?, ?, ?, ?)";
                    pStatement = DAO.getInstance().getConnection().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
                    
                    pStatement.setString(1, passager.getNom());
                    pStatement.setString(2, passager.getPrenom());
                    pStatement.setString(3, passager.getEmail());
                    pStatement.setString(4, passager.getSexe()+"");
                    break;
                case 'c':
                    Entity.Conducteur conducteur = (Entity.Conducteur) obj.getCompte();
                    
                    requete = "INSERT INTO conducteurs(nom, prenom, email, sexe) VALUES (?, ?, ?, ?)";
                    pStatement = DAO.getInstance().getConnection().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
                    
                    pStatement.setString(1, conducteur.getNom());
                    pStatement.setString(2, conducteur.getPrenom());
                    pStatement.setString(3, conducteur.getEmail());
                    pStatement.setString(4, conducteur.getSexe()+"");
                    break;
            }
            
            if (pStatement.executeUpdate() != 0)
                    {
                        ResultSet ids = pStatement.getGeneratedKeys();
                        if (ids.next()) 
                            id = ids.getInt(1);
                        else 
                            return false;
                        
                    }
                    else
                        return false;
            
            
            requete = "INSERT INTO authentifications(login, password, type, idCompte, dateCreation) VALUES (?, ?, ?, ?, ?)";
                        
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);

            pStatement.setString(1, obj.getLogin());
            pStatement.setString(2, obj.getPassword());
            pStatement.setString(3, obj.getType()+"");
            pStatement.setInt(4, id);
            pStatement.setDate(5, obj.getDateCreation());
            
            if (pStatement.executeUpdate() != -1)
                
                return true;
            
            return false;
            
        } catch (SQLException ex) {
            System.out.println("probleme lors de l'ajout d'une authentification.");
            return false;
        }
    }

    @Override
    public boolean update(Authentification obj) throws ProblemeTechniqueException {
        try {
            int id=0;
            
            //on ajout le compte relative a l'authentification
            switch(obj.getType()){
                case 's':
                case 'a':
                    Entity.Administrateur admin = (Entity.Administrateur) obj.getCompte();
                    
                    requete = "UPDATE administrateurs SET nom=? ,prenom=? ,adresse=?,numeroTel=?, sexe= ? WHERE idAdministrateurs= ?";
                    pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                    pStatement.setString(1, admin.getNom());
                    pStatement.setString(2, admin.getPrenom());
                    pStatement.setString(3, admin.getAdresse());
                    pStatement.setString(4, admin.getNumeroTel());
                    //pStatement.setDate(5, new Date(admin.getDateNaissance().getTime()));
                    pStatement.setString(5, admin.getSexe()+"");
                    pStatement.setInt(6, admin.getIdAdministrateurs());
                    
                    
                    
                    if (pStatement.executeUpdate() == -1)
                        return false;
                    break;
            }
            
            requete = "UPDATE authentifications SET login=?,password=? WHERE idAuthentification=?";
                        
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);

            pStatement.setString(1, obj.getLogin());
            pStatement.setString(2, obj.getPassword());
            System.out.println(obj.getIdAuthentification());
            pStatement.setInt(3, obj.getIdAuthentification());
            
            if (pStatement.executeUpdate() != -1)
                return true;
            
            return false;
            
        } catch (SQLException ex) {
            System.out.println("probleme lors de la modification d'une authentification.");
            return false;
        }
    }

    @Override
    public boolean delete(Authentification obj) throws ProblemeTechniqueException {
        try {
            statement = DAO.getInstance().getConnection().createStatement();
            requete = "DELETE FROM authentifications where idAuthentification="+obj.getIdAuthentification();
            
            if (statement.executeUpdate(requete) != -1)
                return true;
            else 
                return false;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la rÃ©cupÃ©ration de la liste des Administrateurs.");
            return false ;
        }   
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
                        authentification.setCompte(AdministrateurDAO.getInstance().findById(resultRequest.getInt("idCompte")));
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
                        result.setCompte(AdministrateurDAO.getInstance().findById(resultRequest.getInt("idCompte")));
                        break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }
    //selectionner la ligne qui contient le login type de retour Idauthentification
    public int findIdBylogin(String login) throws ProblemeTechniqueException {
        
        
        try {
            requete = "select IdAuthentification from authentifications where login = ?";
            
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1, login);
            resultRequest = pStatement.executeQuery();
            if (resultRequest.next())
            {
              return resultRequest.getInt("IdAuthentification") ;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return 0;
    }
    

}
