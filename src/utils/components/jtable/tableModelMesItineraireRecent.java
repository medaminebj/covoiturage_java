/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;

import DAO.RapportDAO;
import DAO.VilleItineraireDAO;
import Entity.Rapport;
import Entity.VilleItineraire;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.ItineraireMetier;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class tableModelMesItineraireRecent  extends javax.swing.table.AbstractTableModel
{
    private List<VilleItineraire> data;
    private String [] entetes ={"Date itinéraire","Description","Prix","Date publication","Distance","Ville de départ","Ville arriver"}; 
    
    
    public tableModelMesItineraireRecent() 
    {
        try {
            Entity.Conducteurs c = (Entity.Conducteurs) Entity.Session.getInstance().getUser().getCompte();
            data=DAO.VilleItineraireDAO.getInstance().FindAncienVillesItinerairesByIdConcuteur(c.getIdConducteurs());
        } catch (Exception ex) {
            Logger.getLogger(tableModelGererRapport.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public String getColumnName(int ColumnIndex)
    {
        return entetes[ColumnIndex];
    }

    @Override
    public int getRowCount() 
    {
        return data.size();
    }

    @Override
    public int getColumnCount()
    {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        VilleItineraire ville= (VilleItineraire)data.get(rowIndex);
        VilleItineraire villeLocation= new VilleItineraire();
        ItineraireMetier itineraireMetier = new ItineraireMetier();
        DAO.participereventsDAO p ;
        boolean VerifierAncienItineraire=false;
        try {
            VerifierAncienItineraire = itineraireMetier.VerfierAncienItineraire(data.get(rowIndex).getIdItineraires().getIditineraire());
        } catch (ProblemeTechniqueException ex) {
            System.out.println("Probleme de vérification un ancien itineraire");
        }
        if (VerifierAncienItineraire)
        {
            switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getIdItineraires().getDateitineraire();
            case 1:
                return data.get(rowIndex).getIdItineraires().getDescription();
            case 2:
                return data.get(rowIndex).getIdItineraires().getPrix();
            case 3:
                return data.get(rowIndex).getIdItineraires().getDatepublication();
            case 4:
                return data.get(rowIndex).getIdItineraires().getDistanceitineraire();
            case 5:
            
                try {
                    try {
                        villeLocation = VilleItineraireDAO.getInstance().FindVilleDepart(data.get(rowIndex).getIdItineraires().getIditineraire());
                    } catch (ProblemeTechniqueException ex) {
                        Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                return villeLocation.getIdLocalites().getNomLocalite();
            case 6:

           try {
               try {
                   villeLocation = VilleItineraireDAO.getInstance().FindVilleArriver(data.get(rowIndex).getIdItineraires().getIditineraire());
               } catch (ProblemeTechniqueException ex) {
                   Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(tableModelMesItineraireRecent.class.getName()).log(Level.SEVERE, null, ex);
           }

           return villeLocation.getIdLocalites().getNomLocalite();
            default:
                return null;
         }
        }
        else
        {
            switch (columnIndex) {
                 default:
                return null;
            }
        }
     }
        
    
    
    public VilleItineraire getRowEntity(int rowIndex)
    {
        return data.get(rowIndex);
    }
    
    public boolean  refreshData()
    {
        try
        {
        data= VilleItineraireDAO.getInstance().FindAllvillesitineraires();
        return true;
        }
        catch(Exception ex)
        {
                return false;
        }
    }
}
