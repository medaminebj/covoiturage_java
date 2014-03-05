/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.delegations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class delegationsDAO implements utils.interfaces.DAO<delegationsDAO>{
    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static delegationsDAO instancedelegationsDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private delegationsDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static delegationsDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instancedelegationsDAO == null) {
            instancedelegationsDAO = new delegationsDAO();
        }
        return instancedelegationsDAO;
    }
    
    @Override
    public boolean create(delegationsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(delegationsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(delegationsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<delegationsDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public delegationsDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public delegations GetDelegationById(int id) throws ProblemeTechniqueException {
          delegations result = null;
        try {
            requete = "SELECT * from delegations WHERE idDelegations=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) 
            {
                result = new delegations();
                result.setIdDelegations(resultRequest.getInt("idDelegations"));
                result.setNomDelegation(resultRequest.getString("NomDelegation"));
                Entity.gouvernorats gouvernerat = new Entity.gouvernorats();
                try { 
                    gouvernerat = gouvernoratsDAO.getInstance().GetGouverneratById(resultRequest.getInt("idGouvernorats")) ;
                    result.setIdGouvernorats(gouvernerat);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Probleme de récuperation de l'id dun gouvernerat");
                } 
                result.setIdGouvernorats(gouvernerat);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
    
    
    
     public delegations GetDelegationByIdGouvernerat(int id) throws ProblemeTechniqueException {
          delegations result = null;
        try {
            requete = "SELECT * from delegations WHERE idGouvernorats=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) 
            {
                result = new delegations();
                result.setIdDelegations(resultRequest.getInt("idDelegations"));
                result.setNomDelegation(resultRequest.getString("NomDelegation"));
                Entity.gouvernorats gouvernerat = new Entity.gouvernorats();
                try { 
                    gouvernerat = gouvernoratsDAO.getInstance().GetGouverneratById(resultRequest.getInt("idGouvernorats")) ;
                } catch (ClassNotFoundException ex) {
                    System.out.println("Probleme de récuperation de l'id dun gouvernerat");
                } 
                result.setIdGouvernorats(gouvernerat);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
     
       public List<delegations> GetAllDelegationByIdGouvernerat(int id) throws ProblemeTechniqueException {
          delegations result = null;
          List<delegations> de = new ArrayList<>();
        try {
            requete = "SELECT * from delegations WHERE idGouvernorats=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            
            while (resultRequest.next()) 
            {
                result = new delegations();
                result.setIdDelegations(resultRequest.getInt("idDelegations"));
                result.setNomDelegation(resultRequest.getString("NomDelegation"));
                Entity.gouvernorats gouvernerat = new Entity.gouvernorats();
                try { 
                    gouvernerat = gouvernoratsDAO.getInstance().GetGouverneratById(resultRequest.getInt("idGouvernorats")) ;
                } catch (ClassNotFoundException ex) {
                    System.out.println("Probleme de récuperation de l'id dun gouvernerat");
                } 
                result.setIdGouvernorats(gouvernerat);
                de.add(result);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return de;
    }
    
    public List<delegations> GetAllDelegationBy() throws ProblemeTechniqueException {
          List<delegations>  result = new ArrayList<>();
          delegations d = null ;
        try {
            requete = "SELECT * from delegations";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            resultRequest = pStatement.executeQuery();
            
            while (resultRequest.next()) 
            {
                d = new delegations();
                d.setIdDelegations(resultRequest.getInt("idDelegations"));
                d.setNomDelegation(resultRequest.getString("NomDelegation"));
                Entity.gouvernorats gouvernerat = new Entity.gouvernorats();
                try { 
                    gouvernerat = gouvernoratsDAO.getInstance().GetGouverneratById(resultRequest.getInt("idGouvernorats")) ;
                } catch (ClassNotFoundException ex) {
                    System.out.println("Probleme de récuperation de l'id dun gouvernerat");
                } 
                d.setIdGouvernorats(gouvernerat);
                result.add(d);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
    
}
