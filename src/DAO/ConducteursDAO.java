/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Authentification;
import Entity.Banissement;
import Entity.Conducteurs;
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
 * @author sabri
 */
public class ConducteursDAO implements utils.interfaces.DAO<Conducteurs>{

    private static ConducteursDAO _instance = null;
    private String requete;
    private Statement statement;
    private PreparedStatement pStatement;
    private ResultSet resultRequest;

    private ConducteursDAO() {
    }

    public static ConducteursDAO getInstance() {
        if (_instance == null) {
            _instance = new ConducteursDAO();
        }
        return _instance;
    }

    public Conducteurs getByID(int idConcucteur) throws ProblemeTechniqueException {
        Conducteurs result = null;
        try {
            requete = "SELECT * from conducteurs WHERE idConducteurs=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,idConcucteur);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) {
                result = new Conducteurs();
                result.setIdConducteurs(resultRequest.getInt("idConducteurs"));
                result.setNom(resultRequest.getString("nom"));
                result.setPrenom(resultRequest.getString("prenom"));
                result.setDateNaissance(resultRequest.getDate("dateNaissance"));
                result.setNumeroTel(resultRequest.getString("numeroTel"));
                result.setAdresse(resultRequest.getString("adresse"));
                result.setNote(resultRequest.getDouble("note"));
                result.setPermisApprouver(resultRequest.getBoolean("permisApprouver"));
                result.setNumTelVerifier(resultRequest.getBoolean("numTelVerifier"));
                result.setProfileCalcule(resultRequest.getDouble("ProfileCalcule"));
                try {
                    result.setIdVoitures(VoitureDAO.getInstance().getVoitureById(resultRequest.getInt("idVoitures")));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                result.setSexe(resultRequest.getString("sexe").charAt(0));
                result.setEmail(resultRequest.getString("email"));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }
    
     public Conducteurs getByEmail(String email) throws ProblemeTechniqueException {
        Conducteurs result = null;
        try {
            requete = "SELECT * from conducteurs WHERE email=?";

            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setString(1,email);
            resultRequest = pStatement.executeQuery();
            
            if (resultRequest.next()) {
                result = new Conducteurs();
                result.setIdConducteurs(resultRequest.getInt("idConducteurs"));
                result.setNom(resultRequest.getString("nom"));
                result.setPrenom(resultRequest.getString("prenom"));
                result.setDateNaissance(resultRequest.getDate("dateNaissance"));
                result.setNumeroTel(resultRequest.getString("numeroTel"));
                result.setAdresse(resultRequest.getString("adresse"));
                result.setNote(resultRequest.getDouble("note"));
                result.setPermisApprouver(resultRequest.getBoolean("permisApprouver"));
                result.setNumTelVerifier(resultRequest.getBoolean("numTelVerifier"));
                result.setProfileCalcule(resultRequest.getDouble("ProfileCalcule"));
                try {
                    result.setIdVoitures(VoitureDAO.getInstance().getVoitureById(resultRequest.getInt("idVoitures")));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                result.setSexe(resultRequest.getString("sexe").charAt(0));
                result.setEmail(resultRequest.getString("email"));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by id.");
        }
       
        return result;
    }

    public List<Conducteurs> getAll() throws ProblemeTechniqueException {
        List<Conducteurs> result = new ArrayList<>();
        Conducteurs conducteur= new Conducteurs();;
        try {
            requete = "select * from authentifications where idConducteurs = ?";
            
            statement = DAO.getInstance().getConnection().createStatement();
            resultRequest = statement.executeQuery(requete);
            while (resultRequest.next()) {
               
                conducteur.setIdConducteurs(resultRequest.getInt("idConducteurs"));
                conducteur.setNom(resultRequest.getString("nom"));
                conducteur.setNom(resultRequest.getString("prenom"));
                conducteur.setDateNaissance(resultRequest.getDate("dateNaissance"));
                conducteur.setNumeroTel(resultRequest.getString("numeroTel"));
                conducteur.setAdresse(resultRequest.getString("adresse"));
                conducteur.setNote(resultRequest.getDouble("note"));
                conducteur.setPermisApprouver(resultRequest.getBoolean("permisApprouver"));
                conducteur.setNumTelVerifier(resultRequest.getBoolean("numTelVerifier"));
                conducteur.setProfileCalcule(resultRequest.getDouble("ProfileCalcule"));
                conducteur.setEmail(resultRequest.getString("email"));
                try {
                    conducteur.setIdVoitures(VoitureDAO.getInstance().getVoitureById(resultRequest.getInt("idVoitures")));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                //result.setSexe(resultRequest.getString("sexe"));
                result.add(conducteur);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }
    

    @Override
    public boolean create(Conducteurs obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Conducteurs conducteur) throws ProblemeTechniqueException {
        try {
             requete = "UPDATE conducteurs SET nom=? ,prenom=? ,dateNaissance=? ,numeroTel=? ,"
                     + "adresse=? ,note=? ,permisApprouver=? ,numTelVerifier=? ,ProfileCalcule=?  ,"
                     + "sexe=? ,urlImageProfil=? ,urlImagePermis=? , email=? WHERE idConducteurs=? ";
             pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
             pStatement.setString(1,conducteur.getNom());
             pStatement.setString(2,conducteur.getPrenom());
             pStatement.setDate(3,new java.sql.Date(conducteur.getDateNaissance().getTime()));
             pStatement.setString(4, conducteur.getNumeroTel());
             pStatement.setString(5, conducteur.getAdresse());
             pStatement.setDouble(6, conducteur.getNote());
             pStatement.setBoolean(7, conducteur.getPermisApprouver());
             pStatement.setBoolean(8, conducteur.getNumTelVerifier());
             pStatement.setDouble(9, conducteur.getProfileCalcule());
             //pStatement.setInt(10, conducteur.getIdVoitures());
             pStatement.setString(10, conducteur.getSexe()+"");
             pStatement.setString(11, conducteur.getUrlImageProfil());
             pStatement.setString(12, conducteur.getUrlImagePermis());
             pStatement.setString(13, conducteur.getEmail());
             pStatement.setInt(14, conducteur.getIdConducteurs());
             
             if (pStatement.executeUpdate() == -1)
                        return false;
             
            
        } catch (SQLException ex) {
            Logger.getLogger(ConducteursDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
         return true;
    }

    @Override
    public boolean delete(Conducteurs obj) throws ProblemeTechniqueException {
        try {
            requete = "DELETE FROM conducteurs where idConducteurs = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, obj.getIdConducteurs());
            
            if (pStatement.executeUpdate() == -1)
                return false;
            else
                return true;
        } catch (SQLException ex) {
            System.out.println("probleme lors de la suppression d'un conducteur.");
            return false;
        }
    }

    @Override
    public Conducteurs findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public double getBeneficeByidConcducteur(int idConducteur, int year) throws ProblemeTechniqueException{
        requete = "SELECT " +
                    "case " +
                    "when (sum(prix) is null) then 0 " +
                    "else sum(prix) " +
                    "end as total " +
                    "FROM `itineraires` WHERE idConducteurs = ? ";
        
        //si year = 0, on retourne la somme totale de benefices
        if (year != 0)
            requete += " and extract(year from dateItineraire) =? ";
        
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, idConducteur);
            if (year != 0)
                pStatement.setInt(2, year);
            
            resultRequest = pStatement.executeQuery();
            
            resultRequest.next();
            return resultRequest.getInt("total");
            
        } catch (SQLException ex) {
            System.out.println("probleme lors getBeneficeByidConcducteur");
        }
        return 0;
    }
    
     public double getBeneficeByidConcducteurInMonth(int idConducteur, int year, int month) throws ProblemeTechniqueException{
        requete = "SELECT " +
                    "case " +
                    "when (sum(prix) is null) then 0 " +
                    "else sum(prix) " +
                    "end as total " +
                    "FROM `itineraires` WHERE idConducteurs = ? "+
                    " and extract(year from dateItineraire) =? "+
                    " and extract(month from dateItineraire) =? ";
        
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, idConducteur);
            pStatement.setInt(2, year);
            pStatement.setInt(3, month);
            
            resultRequest = pStatement.executeQuery();
            
            resultRequest.next();
            return resultRequest.getInt("total");
            
        } catch (SQLException ex) {
            System.out.println("probleme lors getBeneficeByidConcducteur");
        }
        return 0;
    }
    
    public double getBeneficeByidConcducteurInYearAndMonth(int idConducteur, int year, int month) throws ProblemeTechniqueException{
        requete = "SELECT " +
                    "case " +
                    "when (sum(prix) is null) then 0 " +
                    "else sum(prix) " +
                    "end as total " +
                    "FROM `itineraires` WHERE idConducteurs = ? "+
                    "and extract(year from dateItineraire) =? "+
                    "and extract(month from dateItineraire) =? ";
        
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, idConducteur);
            pStatement.setInt(2, year);
            pStatement.setInt(3, month);
            
            resultRequest = pStatement.executeQuery();
            
            resultRequest.next();
            return resultRequest.getInt("total");
            
        } catch (SQLException ex) {
            System.out.println("probleme lors getBeneficeByidConcducteur");
        }
        return 0;
    }
    
    public double getBeneficeByidConcducteurInYearAndMonthAndDay(int idConducteur, int year, int month, int day) throws ProblemeTechniqueException{
        requete = "SELECT " +
                    "case " +
                    "when (sum(prix) is null) then 0 " +
                    "else sum(prix) " +
                    "end as total " +
                    "FROM `itineraires` WHERE idConducteurs = ? "+
                    "and extract(year from dateItineraire) =? "+
                    "and extract(month from dateItineraire) =? "+
                    "and extract(day from dateItineraire) =? ";
        
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, idConducteur);
            pStatement.setInt(2, year);
            pStatement.setInt(3, month);
            pStatement.setInt(4, day);
            
            resultRequest = pStatement.executeQuery();
            
            resultRequest.next();
            return resultRequest.getInt("total");
            
        } catch (SQLException ex) {
            System.out.println("probleme lors getBeneficeByidConcducteur");
        }
        return 0;
    }
    
}
