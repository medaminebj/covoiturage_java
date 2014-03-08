/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Rapport;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Rjiba
 */
public class RapportDAO {

    private static RapportDAO instanceDAORapport = null;
    private Statement statement;
    private String requete;
    private ResultSet resultRequest;
    private PreparedStatement pStatement;
    
    private RapportDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = (Statement) DAO.getInstance().getConnection().createStatement();
    }

    public static RapportDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceDAORapport == null) {
            instanceDAORapport = new RapportDAO();
        }

        return instanceDAORapport;
    }

    public List<Rapport> getRapport() throws SQLException, ClassNotFoundException, ClassNotFoundException, ProblemeTechniqueException {
        List<Rapport> result = new ArrayList<>();
        requete = "select * from rapports";
        resultRequest = statement.executeQuery(requete);
        Rapport rapport = new Rapport() ;
        while (resultRequest.next()) {
            
            rapport.setIdrapport(resultRequest.getInt("idRapports"));
            rapport.setDaterapport(resultRequest.getDate("dateRapport"));
            rapport.setCause(resultRequest.getString("cause"));
            rapport.setRapporterConducteur(resultRequest.getBoolean("rapporterConducteur"));
            rapport.setRapporterPassager(resultRequest.getBoolean("rapporterPassager"));
            rapport.setIdPassager(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("idPassagers")));
            rapport.setIditineraire(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
            rapport.setTraiter(resultRequest.getBoolean("traiter"));
            result.add(rapport);
        }
          System.out.println(result.get(0).getCause());
          return result;
        
    }
    
    public List<Rapport> getAllRapportNonTraiter() throws SQLException, ClassNotFoundException, ClassNotFoundException, ProblemeTechniqueException {
        List<Rapport> result = new ArrayList<>();
        requete = "Select * from rapports where traiter=false";
        resultRequest = statement.executeQuery(requete);
        Rapport rapport  ;
        while (resultRequest.next()) {
            rapport = new Rapport() ;
            rapport.setIdrapport(resultRequest.getInt("idRapports"));
            rapport.setDaterapport(resultRequest.getDate("dateRapport"));
            rapport.setCause(resultRequest.getString("cause"));
            rapport.setRapporterConducteur(resultRequest.getBoolean("rapporterConducteur"));
            rapport.setRapporterPassager(resultRequest.getBoolean("rapporterPassager"));
            rapport.setIdPassager(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("idPassagers")));
            rapport.setIditineraire(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
            rapport.setTraiter(resultRequest.getBoolean("traiter"));
            result.add(rapport);
        }
          System.out.println(result.get(0).getCause());
          return result;
        
    }
    public Rapport getRapportByIdRapport(int idrapport) throws SQLException, ClassNotFoundException, ClassNotFoundException, ProblemeTechniqueException {
        requete = "select * from rapports where idRapports="+idrapport;
        resultRequest = statement.executeQuery(requete);
        Rapport  rapport = new Rapport();

        while (resultRequest.next()) {
           
            rapport.setIdrapport(resultRequest.getInt("idRapports"));
            rapport.setDaterapport(resultRequest.getDate("dateRapport"));
            rapport.setCause(resultRequest.getString("cause"));
            rapport.setRapporterConducteur(resultRequest.getBoolean("rapporterConducteur"));
            rapport.setRapporterPassager(resultRequest.getBoolean("rapporterPassager"));
            rapport.setIdPassager(PassagersDAO.getInstance().getPassagerById(resultRequest.getInt("idPassagers")));
            rapport.setIditineraire(ItineraireDAO.getInstance().getItineraireById(resultRequest.getInt("idItineraires")));
            rapport.setTraiter(resultRequest.getBoolean("traiter"));
        }

        return rapport;
    }

    public boolean update(Rapport obj) throws ProblemeTechniqueException, SQLException 
    {
        requete="UPDATE rapports set dateRapport=?,cause=?,rapporterConducteur=?,rapporterPassager=?,idPassagers=?,idItineraires=?,traiter=1 where idPassagers=?";
        try 
        {
            pStatement=DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setDate(1,new java.sql.Date(obj.getDaterapport().getTime()));
            pStatement.setString(2,obj.getCause());
            pStatement.setBoolean(3, obj.isRapporterConducteur());
            pStatement.setBoolean(4,obj.isRapporterPassager());
            pStatement.setInt(5,obj.getIdPassager().getIdPassagers());
            pStatement.setInt(6, obj.getIditineraire().getIditineraire());
            pStatement.setBoolean(7,obj.isTraiter());
            
            if(pStatement.executeUpdate()==-1)
                return false;
            return true;
             
            
        } 
        catch (SQLException ex) 
        {
            System.out.println("probléme lors de la mise à jours des rapports");
            return false;
        }
    }
    
    public boolean create(Rapport obj) throws ProblemeTechniqueException, SQLException 
    {
        requete="INSERT INTO rapports(dateRapport, cause, rapporterConducteur,rapporterPassager,idPassagers,idItineraires,traiter) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try 
        {
            pStatement=DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setDate(1,new java.sql.Date(obj.getDaterapport().getTime()));
            pStatement.setString(2,obj.getCause());
            pStatement.setBoolean(3, obj.isRapporterConducteur());
            pStatement.setBoolean(4,obj.isRapporterPassager());
            pStatement.setInt(5,obj.getIdPassager().getIdPassagers());
            pStatement.setInt(6, obj.getIditineraire().getIditineraire());
            pStatement.setBoolean(7,obj.isTraiter());
            pStatement.executeUpdate();
            if(pStatement.executeUpdate()== -1)
                return false;
        } 
        catch (SQLException ex) 
        {
            System.out.println("probléme lors de l'ajout des rapports");
            return false;
        }
       return true ;  
    }
    
    public int getNbrRapportByIdPassager(int idPassagers) throws ProblemeTechniqueException{
       int NbrReport= 0 ; 
        
        requete = "Select count(*) as nbr from rapports where idPassagers = ?";
        try {
            pStatement = DAO.getInstance().getConnection().prepareStatement(requete);
            pStatement.setInt(1, idPassagers);
            resultRequest = pStatement.executeQuery();

            if (resultRequest.next()) {
                
                NbrReport = resultRequest.getInt("nbr");
            }
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération du nombre de report.");
        }
        
        
        return NbrReport;
    }

}

