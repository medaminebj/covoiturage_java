/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Administrateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Amine
 */
public class AdministrateurDAO implements utils.interfaces.DAO<Administrateur>{
    
    private static AdministrateurDAO _instance = null;
    private Statement statement;
    private PreparedStatement pStatement;
    private String requete;
    private ResultSet resultRequest;  
    
    private AdministrateurDAO(){
        
    }
    
    public static AdministrateurDAO getInstance(){
        if (_instance == null)
            _instance = new AdministrateurDAO();
        return _instance;
    }

    @Override
    public boolean create(Administrateur obj) throws ProblemeTechniqueException {
        try {
               
            requete = "INSERT INTO administrateurs (nom, prenom,dateNaissance,adresse,numeroTel,sexe,email) VALUES (?,?,?,?,?,?,?)";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setString(1, obj.getNom());
            pStatement.setString(2, obj.getPrenom());
            pStatement.setDate(3, new java.sql.Date(obj.getDateNaissance().getTime()));
            pStatement.setString(4, obj.getAdresse());
            pStatement.setString(5, obj.getNumeroTel());
            pStatement.setString(6, obj.getSexe()+"");
            pStatement.setString(7, obj.getEmail());
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création.");
        }
        
        return true;
    }

    @Override
    public boolean update(Administrateur obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Administrateur obj) throws ProblemeTechniqueException {
        try {
            requete = "DELETE FROM administrateurs where idAdministrateurs = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, obj.getIdAdministrateurs());
            
            if (pStatement.executeUpdate() == -1)
                return false;
            
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la supression d'un administrateur");
        }
        return false ; 
    }

    @Override
    public List<Administrateur> getAll() throws ProblemeTechniqueException {
        List<Administrateur> result = new ArrayList<>();
        
        try {
            statement = DAO.getInstance().getConnection().createStatement();
            requete = "select * from administrateurs";
        
            resultRequest = statement.executeQuery(requete);
        
            while(resultRequest.next())
            result.add
            (new Administrateur(resultRequest.getInt(1), resultRequest.getString(2), resultRequest.getString(3),resultRequest.getString(4),resultRequest.getString(5),resultRequest.getDate(6),resultRequest.getString(7).charAt(0) ,resultRequest.getString(8)));
        
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la liste des Administrateurs.");
        }
        
        return result;
    }

    @Override
    public Administrateur findById(int id) throws ProblemeTechniqueException {
        Administrateur result = null;
        
        requete = "select * from administrateurs where idAdministrateurs = ?";
        
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1 , id);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next())
            {
                result = new Administrateur();
                
                result.setIdAdministrateurs(resultRequest.getInt("idAdministrateurs"));
                result.setNom(resultRequest.getString("nom"));
                result.setPrenom(resultRequest.getString("prenom"));
                result.setAdresse(resultRequest.getString("adresse"));
                result.setNumeroTel(resultRequest.getString("numeroTel"));
                result.setDateNaissance(resultRequest.getDate("dateNaissance"));
                result.setEstSuper(resultRequest.getInt("estSuper"));
                result.setSexe(resultRequest.getString("sexe").charAt(0));
                result.setEmail(resultRequest.getString("email"));
                
            }
        } catch (SQLException ex) {
            System.out.println("probleme lors récupération de l'admin par id.");
        }
        
        return result;
    }
}
