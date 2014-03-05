/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Conducteurs;
import Entity.Passagers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Rjiba
 */
public class PassagersDAO implements utils.interfaces.DAO<Passagers> {

    private static PassagersDAO _instance = null;
    private Statement statement;
    private String requete;
    private ResultSet resulrequest;
    private PreparedStatement pStatement;

    private PassagersDAO() {
    }

    public static PassagersDAO getInstance() {
        if (_instance == null) {
            _instance = new PassagersDAO();
        }
        return _instance;

    }

    public List<Passagers> getPassager() throws ProblemeTechniqueException {
        List<Passagers> result = new ArrayList<>();
        requete = "select * from passagers";
        try {
            resulrequest = statement.executeQuery(requete);
            Passagers passager = new Passagers();

            while (resulrequest.next()) {

                passager.setIdPassagers(resulrequest.getInt("idPassagers"));
                passager.setNom(resulrequest.getString("nom"));
                passager.setPrenom(resulrequest.getString("prenom"));
                passager.setDateNaissance(resulrequest.getDate("dateNaissance"));
                passager.setNumeroTel(resulrequest.getString("numeroTel"));
                passager.setAdresse(resulrequest.getString("adresse"));
                passager.setNote(resulrequest.getDouble("note"));
                passager.setProfileCalcule(resulrequest.getDouble("ProfileCalcule"));
                passager.setSexe(resulrequest.getString("sexe").charAt(0));
                passager.setEmail(resulrequest.getString("email"));
                result.add(passager);
            }}  catch (SQLException ex) {
            System.out.println("erreur lors de l'affichage l'affichage des passagers");
        }




        return result;
    }

    public Passagers getPassagerById(int idpassager) throws ProblemeTechniqueException {
        Passagers passager = new Passagers();
        try {
            requete = "select * from passagers where idPassagers=" + idpassager;
            statement = DAO.getInstance().getConnection().createStatement();
            resulrequest = statement.executeQuery(requete);


            while (resulrequest.next()) {

                passager.setIdPassagers(resulrequest.getInt("idPassagers"));
                passager.setNom(resulrequest.getString("nom"));
                passager.setPrenom(resulrequest.getString("prenom"));
                passager.setDateNaissance(resulrequest.getDate("dateNaissance"));
                passager.setNumeroTel(resulrequest.getString("numeroTel"));
                passager.setAdresse(resulrequest.getString("adresse"));
                passager.setNote(resulrequest.getDouble("note"));
                passager.setProfileCalcule(resulrequest.getDouble("ProfileCalcule"));
                passager.setSexe(resulrequest.getString("sexe").charAt(0));
                passager.setEmail(resulrequest.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'affichage d'un passager byId");
        }

        return passager;
    }
    
    public Passagers getPassagerByEmail(String Email) throws ProblemeTechniqueException {
        Passagers passager = new Passagers(); ;
        try {
            requete = "select * from passagers where email=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1,Email);
            resulrequest = pStatement.executeQuery();
            
            if (resulrequest.next()) {
                passager.setIdPassagers(resulrequest.getInt("idPassagers"));
                passager.setNom(resulrequest.getString("nom"));
                passager.setPrenom(resulrequest.getString("prenom"));
                passager.setDateNaissance(resulrequest.getDate("dateNaissance"));
                passager.setNumeroTel(resulrequest.getString("numeroTel"));
                passager.setAdresse(resulrequest.getString("adresse"));
                passager.setNote(resulrequest.getDouble("note"));
                passager.setProfileCalcule(resulrequest.getDouble("ProfileCalcule"));
                passager.setSexe(resulrequest.getString("sexe").charAt(0));
                passager.setEmail(resulrequest.getString("email"));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return passager;
    }

    public boolean update(Passagers passager) throws ProblemeTechniqueException {
        try {
            requete = "UPDATE passagers SET nom=? ,prenom=? ,dateNaissance=? ,numeroTel=? ,adresse=? ,note=?  ,ProfileCalcule=?  ,sexe=? ,urlImageProfil=? ,email=? WHERE idPassagers=? ";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1, passager.getNom());
            pStatement.setString(2, passager.getPrenom());
            pStatement.setDate(3, (java.sql.Date) passager.getDateNaissance());
            pStatement.setString(4, passager.getNumeroTel());
            pStatement.setString(5, passager.getAdresse());
            pStatement.setDouble(6, passager.getNote());
            pStatement.setDouble(7, passager.getProfileCalcule());
            pStatement.setString(8, passager.getSexe() + "");
            pStatement.setString(9, passager.getUrlImageProfil());
            pStatement.setString(10, passager.getEmail());
            pStatement.setInt(11, passager.getIdPassagers());

            if (pStatement.executeUpdate() == -1) {
                return false;
            }


        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise a jour d'un passager");
            return false;
        }

        return true;
    }
    
    

    @Override
    public boolean create(Passagers obj) throws ProblemeTechniqueException {
        
        try {
               
            requete = "INSERT INTO passagers (nom, prenom,dateNaissance,adresse,numeroTel,sexe,email) VALUES (?,?,?,?,?,?,?)";
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
    public boolean delete(Passagers obj) throws ProblemeTechniqueException {
        try {
            requete = "DELETE FROM passagers where idPassagers = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);

            pStatement.setInt(1, obj.getIdPassagers());
            

            if (pStatement.executeUpdate() == -1) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("probleme lors de la suppression d'un passager.");
            return false;
        }
    }

    @Override
    public List<Passagers> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Passagers findById(int id) throws ProblemeTechniqueException {
          Passagers passager = new Passagers();
        try {
            requete = "select * from passagers where idPassagers=" + id;
            statement = DAO.getInstance().getConnection().createStatement();
            resulrequest = statement.executeQuery(requete);


            while (resulrequest.next()) {

                passager.setIdPassagers(resulrequest.getInt("idPassagers"));
                passager.setNom(resulrequest.getString("nom"));
                passager.setPrenom(resulrequest.getString("prenom"));
                passager.setDateNaissance(resulrequest.getDate("dateNaissance"));
                passager.setNumeroTel(resulrequest.getString("numeroTel"));
                passager.setAdresse(resulrequest.getString("adresse"));
                passager.setNote(resulrequest.getDouble("note"));
                passager.setProfileCalcule(resulrequest.getDouble("ProfileCalcule"));
                passager.setSexe(resulrequest.getString("sexe").charAt(0));
                passager.setEmail(resulrequest.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'affichage d'un passager byId");
        }

        return passager;
    }
}
