/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Voiture;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Rjiba
 */
public class VoitureDAO {
    
    private static VoitureDAO instanceDAOVoiture = null;
    private Statement statement;
    private String requete;
    private ResultSet resultrequest;
    
    private VoitureDAO() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        statement = DAO.getInstance().getConnection().createStatement();
    }
    
    public static VoitureDAO getInstance() throws ClassNotFoundException, SQLException, ProblemeTechniqueException {
        if (instanceDAOVoiture == null) {
            instanceDAOVoiture = new VoitureDAO();
        }
        return instanceDAOVoiture;
    }
    
    public List<Voiture> getVoiture() throws SQLException {
        List<Voiture> result = new ArrayList<>();
        requete = "select * from voitures";
        resultrequest = statement.executeQuery(requete);
        Voiture voiture;
        
        while (resultrequest.next()) {
            voiture = new Voiture();
            voiture.setIdvoiture(resultrequest.getInt("idVoitures"));
            voiture.setMarque(resultrequest.getString("marque"));
            voiture.setModele(resultrequest.getString("modele"));
            voiture.setAnnee(resultrequest.getInt("annee"));
            voiture.setNbrplaces(resultrequest.getInt("nbrPlaces"));
            voiture.setBagage(resultrequest.getBoolean("bagage"));
            voiture.setEstclimatiser(resultrequest.getBoolean("estClimatiser"));
            voiture.setTabac(resultrequest.getBoolean("tabac"));
            voiture.setEnfant(resultrequest.getBoolean("enfant"));
            result.add(voiture);
            
            
        }
        return result;
    }
    
    public Voiture getVoitureById(int idVoiture) throws SQLException {
        
        
        requete = "select * from voitures where idVoitures="+idVoiture;
        resultrequest = statement.executeQuery(requete);
        Voiture voiture = new Voiture();
        
        if (resultrequest.next()) {
            
            voiture.setIdvoiture(resultrequest.getInt("idVoitures"));
            voiture.setMarque(resultrequest.getString("marque"));
            voiture.setModele(resultrequest.getString("modele"));
            voiture.setAnnee(resultrequest.getInt("annee"));
            voiture.setNbrplaces(resultrequest.getInt("nbrPlaces"));
            voiture.setBagage(resultrequest.getBoolean("bagage"));
            voiture.setEstclimatiser(resultrequest.getBoolean("estClimatiser"));
            voiture.setTabac(resultrequest.getBoolean("tabac"));
            voiture.setEnfant(resultrequest.getBoolean("enfant"));
            
        }
        return voiture;
    }
    
    
    
}
