/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Itineraire;
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
public class ItineraireDAO {
    
    private static ItineraireDAO instanceDAOItinieraire = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    private static ConducteursDAO _instance = null;
    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    
    
    private ItineraireDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static ItineraireDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceDAOItinieraire == null) {
            instanceDAOItinieraire = new ItineraireDAO();
        }
        return instanceDAOItinieraire;
    }

   
    
    
    public List<Itineraire> getItineraire() throws SQLException, ClassNotFoundException, ProblemeTechniqueException {
        List<Itineraire> result = new ArrayList<>();
        requete = "select * from itineraires";
        resultRequete = statement.executeQuery(requete);
        Itineraire itineraire;
        
        while (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            result.add(itineraire);
            
        }
        return result;
    }
    
    public Itineraire getItineraireById(int iditineraire) throws ProblemeTechniqueException {
   
         requete = "select * from itineraires where idItineraires=?";
         Itineraire itineraire = new Itineraire();
    try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,iditineraire);
            resultRequete = pStatement.executeQuery();
            if (resultRequete.next()) {
                 
                itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
                itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
                itineraire.setDescription(resultRequete.getString("Description"));
                itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
                itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
                itineraire.setPrix(resultRequete.getDouble("prix"));
                itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
                itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
                itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            
            }
        } catch (SQLException ex) {
            return null ;
        }
        return itineraire;
    }
    
     public Itineraire getItineraireByMaxId() throws ProblemeTechniqueException {
   
         requete = "select * from itineraires where idItineraires=(Select Max(idItineraires) from itineraires)";
         Itineraire itineraire = new Itineraire();
    try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            resultRequete = pStatement.executeQuery();
            if (resultRequete.next()) {
                 
                itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
                itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
                itineraire.setDescription(resultRequete.getString("Description"));
                itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
                itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
                itineraire.setPrix(resultRequete.getDouble("prix"));
                itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
                itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
                itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            
            }
        } catch (SQLException ex) {
            return null ;
        }
        return itineraire;
    }
    
     public List<Itineraire> getAncienItineraire() throws SQLException, ClassNotFoundException, ProblemeTechniqueException {
        List<Itineraire> result = new ArrayList<>();
        requete = "select * from itineraires where CURDATE() > dateItineraire";
        resultRequete = statement.executeQuery(requete);
        Itineraire itineraire;
        
        while (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            result.add(itineraire);
            
        }
        return result;
    }
     
      public Itineraire getAncienItineraireByID(int iditineraire) throws SQLException, ClassNotFoundException, ProblemeTechniqueException {

        requete = "select * from itineraires where CURDATE() > dateItineraire and idItineraires=?";
        pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
        pStatement.setInt(1,iditineraire);
        resultRequete = pStatement.executeQuery();
        Itineraire itineraire = new Itineraire () ; 
        if (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
         
            
        }
        return itineraire;
    }
      
      public Itineraire getNewItineraireByID(int iditineraire) throws SQLException, ClassNotFoundException, ProblemeTechniqueException {

        requete = "select * from itineraires where dateItineraire>=CURDATE() and idItineraires=?";
        pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
        pStatement.setInt(1,iditineraire);
        resultRequete = pStatement.executeQuery();
        Itineraire itineraire = new Itineraire () ; 
        if (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
         
            
        }
          System.out.println(itineraire.getPrix());
        return itineraire;
    }
     
        public List<Itineraire> getNewItineraire() throws SQLException, ClassNotFoundException, ProblemeTechniqueException {
        List<Itineraire> result = new ArrayList<>();
        requete = "select * from itineraires where CURDATE() <= dateItineraire";
        resultRequete = statement.executeQuery(requete);
        Itineraire itineraire;
        
        while (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            result.add(itineraire);
            
        }
        return result;
    }
        
        public List<Itineraire> getNewItineraireByConfirmation() throws SQLException, ClassNotFoundException, ProblemeTechniqueException {
        List<Itineraire> result = new ArrayList<>();
        requete = "select * from itineraires where CURDATE() <= dateItineraire and estConfirmer=true";
        resultRequete = statement.executeQuery(requete);
        Itineraire itineraire;
        
        while (resultRequete.next()) {
            itineraire = new Itineraire();
            itineraire.setIditineraire(resultRequete.getInt("idItineraires"));
            itineraire.setIdConducteur(ConducteursDAO.getInstance().getByID(resultRequete.getInt("idConducteurs")));
            itineraire.setDescription(resultRequete.getString("Description"));
            itineraire.setEstpublic(resultRequete.getBoolean("estPublic"));
            itineraire.setDateitineraire(resultRequete.getDate("dateItineraire"));
            itineraire.setPrix(resultRequete.getDouble("prix"));
            itineraire.setEstconfirmer(resultRequete.getBoolean("estConfirmer"));
            itineraire.setDistanceitineraire(resultRequete.getDouble("distanceItineraire"));
            itineraire.setDatepublication(resultRequete.getDate("datePublication"));
            result.add(itineraire);
            
        }
        return result;
    }
         
           public boolean delete(Itineraire obj) throws ProblemeTechniqueException {
        try {
            requete = "DELETE FROM itineraires where idItineraires = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, obj.getIditineraire());
            
            if (pStatement.executeUpdate() == -1)
                return false;
            else
            {
                
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("probleme lors de la suppression d'un itinéraire.");
            return false;
        }
    }
           
      public boolean create(Itineraire obj) throws ProblemeTechniqueException {
        try {
               
            requete = "INSERT INTO itineraires ( idConducteurs, Description, estPublic, dateItineraire, prix, estConfirmer, distanceItineraire, datePublication) VALUES (?,?,?,?,?,?,?,?)";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, obj.getIdConducteur().getIdConducteurs());
            pStatement.setString(2, obj.getDescription());
            pStatement.setDate(4, new java.sql.Date(obj.getDateitineraire().getTime()));
            pStatement.setBoolean(3, obj.isEstpublic());
            pStatement.setDouble(5, obj.getPrix());
            pStatement.setBoolean(6, obj.isEstconfirmer());
            pStatement.setDouble(7, obj.getDistanceitineraire());
            pStatement.setDate(8, new java.sql.Date(obj.getDatepublication().getTime()));
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création.");
        }
        
        return true;
    }
      
       public boolean update(Itineraire obj) throws ProblemeTechniqueException {
        try {
               
            requete = "UPDATE itineraires SET Description=?, estPublic=? ,dateItineraire=?, prix=?, "
                    + "estConfirmer=? ,distanceItineraire=?, datePublication=? where idItineraires=?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
           
            pStatement.setString(1, obj.getDescription());
            pStatement.setDate(3, new java.sql.Date(obj.getDateitineraire().getTime()));
            pStatement.setBoolean(2, obj.isEstpublic());
            pStatement.setDouble(4, obj.getPrix());
            pStatement.setBoolean(5, obj.isEstconfirmer());
            pStatement.setDouble(6, obj.getDistanceitineraire());
            pStatement.setDate(7, new java.sql.Date(obj.getDatepublication().getTime()));
            pStatement.setInt(8, obj.getIditineraire());
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification.");
        }
        
        return true;
    }
}
