/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Authentification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class DemandesDAO implements utils.interfaces.DAO<DemandesDAO> {

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static DemandesDAO instanceDemandesDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private DemandesDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static DemandesDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceDemandesDAO == null) {
            instanceDemandesDAO = new DemandesDAO();
        }
        return instanceDemandesDAO;
    }
    
    
    @Override
    public boolean create(DemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(DemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DemandesDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DemandesDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
