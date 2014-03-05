/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class participerdemandesDAO implements utils.interfaces.DAO<participerdemandesDAO>{

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static participerdemandesDAO instanceparticiperdemandesDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private participerdemandesDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static participerdemandesDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceparticiperdemandesDAO == null) {
            instanceparticiperdemandesDAO = new participerdemandesDAO();
        }
        return instanceparticiperdemandesDAO;
    }
    @Override
    public boolean create(participerdemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(participerdemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(participerdemandesDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<participerdemandesDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public participerdemandesDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
