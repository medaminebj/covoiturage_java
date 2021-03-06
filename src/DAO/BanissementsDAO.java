/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.List;
import Entity.Banissement;
import Entity.Authentification;
import java.util.ArrayList;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public class BanissementsDAO implements utils.interfaces.DAO<Banissement>{
    private static BanissementsDAO _instance = null;
    
    private Statement statement;
    private PreparedStatement pStatement;
    private String requete;
    private ResultSet resultRequest;
    
    private BanissementsDAO() {
        
    }
    
    public static BanissementsDAO getInstance(){
        if (_instance == null)
            _instance = new BanissementsDAO();
        
        return _instance;
    }
    
    public List<Banissement> getByIdAuthentification(int idAuthentification) throws ProblemeTechniqueException{
        List<Banissement> result = new ArrayList<>();
        
        requete = "Select * from banissements where idAuthentification = ?";
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, idAuthentification);
            resultRequest = pStatement.executeQuery();
            
            Authentification user = AuthentificationDAO.getInstance().findById(idAuthentification);
            Banissement ban;
            while (resultRequest.next()) {
                
                ban = new Banissement();
                
                ban.setIdBanissements(resultRequest.getInt("idBanissements"));
                ban.setDateDebut(resultRequest.getDate("dateDebut"));
                ban.setDateFin(resultRequest.getDate("dateFin"));
                ban.setCause(resultRequest.getString("cause"));
                ban.setUser(user);
                ban.setIdAdministrateurs(resultRequest.getInt("idAdministrateurs"));
                
                System.out.println(ban.getIdBanissements() + " cause : "+ban.getCause());
                result.add(ban);
            }
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la liste des ban.");
        }
        
        
        return result;
    }
    
    public Banissement getByIdAuthentificationAndDate(int idAuthentification, Date date) throws ProblemeTechniqueException{
        Banissement result = null;
        
        requete = "Select * from banissements where idAuthentification = ? and dateFin > ?";
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, idAuthentification);
            pStatement.setDate(2, date);
            resultRequest = pStatement.executeQuery();
            
            Authentification user = AuthentificationDAO.getInstance().findById(idAuthentification);
            if (resultRequest.next()) {
                result = new Banissement();
                
                result.setIdBanissements(resultRequest.getInt("idBanissements"));
                result.setDateDebut(resultRequest.getDate("dateDebut"));
                result.setDateFin(resultRequest.getDate("dateFin"));
                result.setCause(resultRequest.getString("cause"));
                result.setUser(user);
                result.setIdAdministrateurs(resultRequest.getInt("idAdministrateurs"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la liste des ban." + ex.getMessage());
        }
        
        
        return result;
    }

    @Override
    public boolean create(Banissement obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Banissement obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Banissement obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Banissement> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banissement findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
