/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Passagers;
import Entity.participerevents;
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
public class participereventsDAO implements utils.interfaces.DAO<participereventsDAO>{

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static participereventsDAO instanceparticipereventsDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
     private participereventsDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static participereventsDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceparticipereventsDAO == null) {
            instanceparticipereventsDAO = new participereventsDAO();
        }
        return instanceparticipereventsDAO;
    }

    @Override
    public boolean create(participereventsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(participereventsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(participereventsDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<participereventsDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public participereventsDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Entity.participerevents> FindAllparticiperevents() throws ProblemeTechniqueException
    {
        List<Entity.participerevents> Result = new ArrayList<>();
        Entity.participerevents participer = new Entity.participerevents ();
         try {
            requete = "select * from participerevents ";
            
            statement = DAO.getInstance().getConnection().createStatement();
            resultRequest = statement.executeQuery(requete);
            while (resultRequest.next()) {
               
                participer.setIdParticiperEvents(resultRequest.getInt("IdParticiperEvents"));
                try {
                    participer.setIdPassagers(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("IdPassagers")));
                    participer.setVilleDepart(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleDepart")));
                    participer.setVilleArrivee(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleArrivee")));
                    participer.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("ItineraireById")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                participer.setEstAccepter(resultRequest.getBoolean("EstAccepter"));
                Result.add(participer);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return Result;
    }
    
     public List<Entity.participerevents> FindParticiperEventsByIdItineraires(int id) throws ProblemeTechniqueException
    {
        List<Entity.participerevents> Result = new ArrayList<>();
        Entity.participerevents participer ;
         try {
            requete = "select * from participerevents where idItineraires = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            while (resultRequest.next()) {
               participer = new Entity.participerevents ();
                participer.setIdParticiperEvents(resultRequest.getInt("IdParticiperEvents"));
                try {
                    participer.setIdPassagers(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("IdPassagers")));
                    participer.setVilleDepart(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleDepart")));
                    participer.setVilleArrivee(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleArrivee")));
                    participer.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                participer.setEstAccepter(resultRequest.getBoolean("EstAccepter"));
                Result.add(participer);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return Result;
    }
     
      public List<Entity.participerevents> FindParticiperEventsByIdItinerairesAccepted(int id) throws ProblemeTechniqueException
    {
        //si le passager est accepter 
        List<Entity.participerevents> Result = new ArrayList<>();
        Entity.participerevents participer ;
         try {
            requete = "select * from participerevents where idItineraires = ? and estAccepter=true";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,id);
            resultRequest = pStatement.executeQuery();
            while (resultRequest.next()) {
               participer = new Entity.participerevents ();
                participer.setIdParticiperEvents(resultRequest.getInt("IdParticiperEvents"));
                try {
                    participer.setIdPassagers(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("IdPassagers")));
                    participer.setVilleDepart(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleDepart")));
                    participer.setVilleArrivee(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleArrivee")));
                    participer.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                participer.setEstAccepter(resultRequest.getBoolean("EstAccepter"));
                Result.add(participer);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return Result;
    }
     public int NombreDePassagerParEvenement(int idEvent , int idItineraire) throws ProblemeTechniqueException
    {
       int NombrePassager= 0; 
         try {
            requete = "select count(*) from participerevents where IdParticiperEvents=? and ItineraireById=?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,idEvent);
            pStatement.setInt(2,idItineraire);
            resultRequest = pStatement.executeQuery();
            while (resultRequest.next()) {
              NombrePassager= resultRequest.getInt(0);
               
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return NombrePassager;
    } 
     
     
     public boolean updateAcceptationPassager(Passagers passager , Entity.Itineraire itineraire) throws ProblemeTechniqueException {
        try {
            requete = "UPDATE participerevents SET estAccepter=? WHERE idPassagers=? and idItineraires=?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setBoolean(1, true);
            pStatement.setInt(2, passager.getIdPassagers());
            pStatement.setInt(3, itineraire.getIditineraire());
            

            if (pStatement.executeUpdate() == -1) {
                return false;
            }


        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise a jour d'un evenement");
            return false;
        }

        return true;
    }
    
     public boolean Inserrer(Entity.participerevents obj) throws ProblemeTechniqueException {
        
        try {
               
            requete = "INSERT INTO participerevents (idPassagers, estAccepter, villeDepart, villeArrivee, idItineraires) VALUES (?,?,?,?,?)";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);            
            pStatement.setInt(1, obj.getIdPassagers().getIdPassagers());
            pStatement.setBoolean(2, obj.isEstAccepter());
            pStatement.setInt(3, 1);
            pStatement.setInt(4, 2);
            pStatement.setInt(5, obj.getIdItineraires().getIditineraire());
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création.");
        }
        
        return true;
    
    }

      public Entity.participerevents FindEventsByIdItinerairesAndPassager(Entity.Passagers p , Entity.Itineraire i ) throws ProblemeTechniqueException
    {
        
        Entity.participerevents participer = null ;
         try {
            requete = "select * from participerevents where idItineraires = ? and idPassagers=?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1,i.getIditineraire());
            pStatement.setInt(2,p.getIdPassagers());
            resultRequest = pStatement.executeQuery();
            if (resultRequest.next()) {
               participer = new Entity.participerevents ();
                participer.setIdParticiperEvents(resultRequest.getInt("IdParticiperEvents"));
                try {
                    participer.setIdPassagers(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("IdPassagers")));
                    participer.setVilleDepart(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleDepart")));
                    participer.setVilleArrivee(VilleItineraireDAO.getInstance().FindVillesItinerairesById(resultRequest.getInt("VilleArrivee")));
                    participer.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                participer.setEstAccepter(resultRequest.getBoolean("EstAccepter"));
                
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return participer;
    }

}


