/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.localites;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class localitesDAO implements utils.interfaces.DAO<localitesDAO>{

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static localitesDAO instancelocalitesDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private localitesDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static localitesDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instancelocalitesDAO == null) {
            instancelocalitesDAO = new localitesDAO();
        }
        return instancelocalitesDAO;
    }

    @Override
    public boolean create(localitesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(localitesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(localitesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<localitesDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public localitesDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public localites GetLocalitesById(int id) throws ProblemeTechniqueException { 
    localites result = new localites();
        try {
            requete = "SELECT * from localites WHERE idLocalites=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            Entity.delegations delegation ;
            if (resultRequest.next()) 
            {
                result = new localites();
                result.setIdLocalites(resultRequest.getInt("idLocalites"));
                result.setNomLocalite(resultRequest.getString("NomLocalite"));
                delegation = new Entity.delegations();
                try {
                    delegation = delegationsDAO.getInstance().GetDelegationById(resultRequest.getInt("idDelegations")) ;
                    result.setIdDelegations(delegation);
                } catch (ClassNotFoundException ex) {
                   System.out.println("Probleme de recuperation dune delegation");
                } 
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
     }
   
   public List<localites> GetAllLocalites(int id) throws ProblemeTechniqueException { 
    localites result = new localites();
    List<localites> ls = new ArrayList<>();
        try {
            requete = "SELECT * from localites WHERE idDelegations=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            Entity.delegations delegation ;
          while(resultRequest.next()) 
            {
                result = new localites();
                result.setIdLocalites(resultRequest.getInt("idLocalites"));
                result.setNomLocalite(resultRequest.getString("NomLocalite"));
                 delegation = new Entity.delegations();
                try {
                    delegation = delegationsDAO.getInstance().GetDelegationById(resultRequest.getInt("idDelegations")) ;
                    result.setIdDelegations(delegation);
                    ls.add(result);
                } catch (ClassNotFoundException ex) {
                   System.out.println("Probleme de recuperation dune delegation");
                } 
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return ls;
     }
   
   public localites GetLocalitesByIdDelegation(int id) throws ProblemeTechniqueException { 
    localites result = new localites();
        try {
            requete = "SELECT * from localites WHERE idDelegations=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            Entity.delegations delegation ;
            if (resultRequest.next()) 
            {
                result = new localites();
                result.setIdLocalites(resultRequest.getInt("idLocalites"));
                result.setNomLocalite(resultRequest.getString("NomLocalite"));
                 delegation = new Entity.delegations();
                try {
                    delegation = delegationsDAO.getInstance().GetDelegationById(resultRequest.getInt("idDelegations")) ;
                    result.setIdDelegations(delegation);
                } catch (ClassNotFoundException ex) {
                   System.out.println("Probleme de recuperation dune delegation");
                } 
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
     }
}
