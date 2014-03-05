/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.gouvernorats;
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
public class gouvernoratsDAO implements utils.interfaces.DAO<gouvernoratsDAO>{

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static gouvernoratsDAO instancegouvernoratsDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private gouvernoratsDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static gouvernoratsDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instancegouvernoratsDAO == null) {
            instancegouvernoratsDAO = new gouvernoratsDAO();
        }
        return instancegouvernoratsDAO;
    }

    @Override
    public boolean create(gouvernoratsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(gouvernoratsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(gouvernoratsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<gouvernoratsDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public gouvernoratsDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public gouvernorats GetGouverneratById(int id) throws ProblemeTechniqueException {
          gouvernorats result = null;
        try {
            requete = "SELECT * from gouvernorats WHERE IdGouvernorats=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) 
            {
                result = new gouvernorats();
                result.setIdGouvernorats(resultRequest.getInt("IdGouvernorats"));
                result.setNomGouvernorat(resultRequest.getString("NomGouvernorat"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
    
    public gouvernorats GetGouverneratByNom(String nom) throws ProblemeTechniqueException {
          gouvernorats result = null;
        try {
            requete = "SELECT * from gouvernorats WHERE NomGouvernorat=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1,nom);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) 
            {
                result = new gouvernorats();
                result.setIdGouvernorats(resultRequest.getInt("IdGouvernorats"));
                result.setNomGouvernorat(resultRequest.getString("NomGouvernorat"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
    
     public List<gouvernorats> GetAllGouvernerat() throws ProblemeTechniqueException {
          gouvernorats result = null;
          List<gouvernorats> go = new ArrayList<>();
        try {
            requete = "SELECT * from gouvernorats";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            resultRequest = pStatement.executeQuery();
            
            while (resultRequest.next()) 
            {
                result = new gouvernorats();
                result.setIdGouvernorats(resultRequest.getInt("IdGouvernorats"));
                result.setNomGouvernorat(resultRequest.getString("NomGouvernorat"));
                go.add(result);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return go;
    }
    
}
