/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.VilleItineraire;
import java.sql.Array;
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
public class VilleItineraireDAO implements utils.interfaces.DAO<VilleItineraireDAO>{

    private PreparedStatement pStatement;
    private ResultSet resultRequest;
    private static VilleItineraireDAO instanceVilleItineraireDAO = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequete;
    
    private VilleItineraireDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static VilleItineraireDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceVilleItineraireDAO == null) {
            instanceVilleItineraireDAO = new VilleItineraireDAO();
        }
        return instanceVilleItineraireDAO;
    }
    

    @Override
    public boolean create(VilleItineraireDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(VilleItineraireDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(VilleItineraireDAO obj) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VilleItineraireDAO> getAll() throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VilleItineraireDAO findById(int id) throws ProblemeTechniqueException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Entity.VilleItineraire> FindAllvillesitineraires() throws ProblemeTechniqueException
    {
        List<Entity.VilleItineraire> Result = new ArrayList<>();
        Entity.VilleItineraire ville ;
         try {
            requete = "SELECT  DISTINCT * FROM villesitineraires Group by(idItineraires) ";
            
            statement = DAO.getInstance().getConnection().createStatement();
            resultRequest = statement.executeQuery(requete);
            while (resultRequest.next()) {
               ville = new Entity.VilleItineraire ();
                ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                try {
                    ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                    ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setNumVille(resultRequest.getInt("NumVille"));
                Result.add(ville);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return Result;
    }
    
     public Entity.VilleItineraire FindVilleDepart(int idItinieraire) throws ProblemeTechniqueException
    {
        
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
         try {
                
                requete = "SELECT * FROM villesitineraires WHERE numVille=(SELECT MAX(numVille) FROM villesitineraires group by(idItineraires) having idItineraires=?) AND idItineraires=?";
                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,idItinieraire);
                pStatement.setInt(2,idItinieraire);
                resultRequest = pStatement.executeQuery();
                
                if (resultRequest.next()) {
                    ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                    try {
                        ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                        ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                    } catch (ClassNotFoundException ex) {
                         System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                    } 
                    ville.setLattitude(resultRequest.getDouble("Lattitude"));
                    ville.setLattitude(resultRequest.getDouble("Lattitude"));
                    ville.setNumVille(resultRequest.getInt("NumVille"));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return ville;
    }
     
       public Entity.VilleItineraire FindVilleArriver(int idItinieraire) throws ProblemeTechniqueException
    {
        
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
         try {
                requete = "SELECT * FROM villesitineraires WHERE numVille=(SELECT MIN(numVille) FROM villesitineraires group by(idItineraires) having idItineraires=?) AND idItineraires=?";

                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,idItinieraire);
                pStatement.setInt(2,idItinieraire);
                resultRequest = pStatement.executeQuery();
                
                if (resultRequest.next()) {
                    ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                    try {
                        ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                        ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                    } catch (ClassNotFoundException ex) {
                         System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                    } 
                    ville.setLattitude(resultRequest.getDouble("Lattitude"));
                    ville.setLattitude(resultRequest.getDouble("Lattitude"));
                    ville.setNumVille(resultRequest.getInt("NumVille"));

            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return ville;
    }
       
        public Entity.VilleItineraire FindVillesItinerairesById(int id) throws ProblemeTechniqueException
    {
        
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
         try {
                requete = "select * from villesitineraires where IdVilleItineraire=?";
                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,id);
                resultRequest = pStatement.executeQuery();
            if (resultRequest.next()) {
               
                ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                try {
                    ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                    ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setNumVille(resultRequest.getInt("NumVille"));
        
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return ville;
    }
        //Cherche par des villeItineraire par idItiineraire 
        public Entity.VilleItineraire FindAncienVillesItineraires(int id) throws ProblemeTechniqueException
    {
       
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
         try {
                requete = "select * from villesitineraires where IdItineraires=?";
                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,id);
                resultRequest = pStatement.executeQuery();
            if (resultRequest.next()) {
               
                ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                try {
                    ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                    ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setNumVille(resultRequest.getInt("NumVille"));
        
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return ville;
    }
        
         public List<Entity.VilleItineraire> FindNewVillesItinerairesByIdConcuteur(int id) throws ProblemeTechniqueException
    {
       
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
        List<Entity.VilleItineraire> result = new ArrayList<>();
         try {
                requete = "select * from villesitineraires \n" +
                            "where IdItineraires=(select DISTINCT `idItineraires` from villesitineraires \n" +
                            "where IdItineraires=\n" +
                            "(select  itineraires.IdItineraires from itineraires,conducteurs \n" +
                            "where itineraires.idConducteurs=conducteurs.idConducteurs \n" +
                            "and itineraires.idConducteurs=? \n" +
                            "and CURDATE() < dateItineraire ))and numVille=1";
                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,id);
                resultRequest = pStatement.executeQuery();
            while (resultRequest.next()) {
               
                ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                try {
                    ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                    ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setNumVille(resultRequest.getInt("NumVille"));
                result.add(ville);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }
        
         public List<Entity.VilleItineraire> FindAncienVillesItinerairesByIdConcuteur(int id) throws ProblemeTechniqueException
    {
       
        Entity.VilleItineraire ville = new Entity.VilleItineraire ();
        List<Entity.VilleItineraire> result = new ArrayList<>();
         try {
                requete = "select * from villesitineraires where IdItineraires=(select itineraires.IdItineraires from itineraires,conducteurs where itineraires.idConducteurs=conducteurs.idConducteurs and itineraires.idConducteurs=? and CURDATE() > dateItineraire)";
                pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
                pStatement.setInt(1,id);
                resultRequest = pStatement.executeQuery();
            while (resultRequest.next()) {
               
                ville.setIdVilleItineraire(resultRequest.getInt("IdVilleItineraire"));
                try {
                    ville.setIdItineraires(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("IdItineraires")));
                    ville.setIdLocalites(localitesDAO.getInstance().GetLocalitesById(resultRequest.getInt("IdLocalites")));
                } catch (ClassNotFoundException ex) {
                     System.out.println("Erreur lors de la récupération d'une localité ou itineraire");
                } 
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setLattitude(resultRequest.getDouble("Lattitude"));
                ville.setNumVille(resultRequest.getInt("NumVille"));
                result.add(ville);
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération d'un user by login.");
        }
        
        return result;
    }
        public boolean delete(VilleItineraire obj) throws ProblemeTechniqueException {
        try {
            requete = "DELETE FROM villesitineraires where IdVilleItineraire = ?";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, obj.getIdVilleItineraire());
            
            if (pStatement.executeUpdate() == -1)
                return false;
            else
            {
                try {
                    if (ItineraireDAO.getInstance().delete(obj.getIdItineraires()))
                    return true;
                    else
                        return false ; 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VilleItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VilleItineraireDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("probleme lors de la suppression d'un VilleItineraire.");
            return false;
        }
    }
        
        public boolean create(VilleItineraire obj) throws ProblemeTechniqueException {
        
        try {
               
            requete = "INSERT INTO villesitineraires (idItineraires, idLocalites, longitude, lattitude, numVille) VALUES (?,?,?,?,?)";
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, obj.getIdItineraires().getIditineraire());
            pStatement.setInt(2, obj.getIdLocalites().getIdLocalites());
            pStatement.setString(3, "");
            pStatement.setString(4, "");
            pStatement.setInt(5, obj.getNumVille());
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création.");
        }
        
        return true;
    
    }
        
         public boolean update(VilleItineraire obj,int index) throws ProblemeTechniqueException {
        
        try {
             if (index==0)  
               requete = "UPDATE villesitineraires SET idItineraires=?, idLocalites=?, longitude=?, lattitude=?, numVille=? WHERE numVille=(Select MAX(numVille) from villesitineraires where idItineraires=?)";
             else
               requete = "UPDATE villesitineraires SET idItineraires=?, idLocalites=?, longitude=?, lattitude=?, numVille=? WHERE numVille=(Select MIN(numVille) from villesitineraires where idItineraires=?)";    
             pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            
            pStatement.setInt(1, obj.getIdItineraires().getIditineraire());
            pStatement.setInt(2, obj.getIdLocalites().getIdLocalites());
            pStatement.setString(3, "");
            pStatement.setString(4, "");
            pStatement.setInt(5, obj.getNumVille());
            if (pStatement.executeUpdate() == -1)
                return false;

        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création.");
        }
        
        return true;
    
    }

        
}
