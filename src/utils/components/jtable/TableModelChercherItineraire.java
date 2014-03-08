/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;

import DAO.*;
import Entity.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Axel
 */
public class TableModelChercherItineraire  extends javax.swing.table.AbstractTableModel
{
    private List<Itineraire> data;
    private String [] entetes ={"Ville de départ","Ville d'arriver","Date itinéraire","Date de publication","Distance itinéraire","Statuts"}; 
    private VilleItineraire ville ;
    
    
    public TableModelChercherItineraire() 
    {
        try {

            data=ItineraireDAO.getInstance().getNewItineraireByConfirmation();
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
       
            Itineraire r= (Itineraire)data.get(rowIndex);
            
            switch (columnIndex) {
                case 0:
                          try {
                try {
                    ville = VilleItineraireDAO.getInstance().FindVilleDepart(r.getIditineraire()) ;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                return ville.getIdLocalites().getIdDelegations().getIdGouvernorats().getNomGouvernorat();
                   
                case 1:
                    try {
                try {
                    ville = VilleItineraireDAO.getInstance().FindVilleArriver(r.getIditineraire()) ;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ProblemeTechniqueException ex) {
                Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
            }
                return ville.getIdLocalites().getIdDelegations().getIdGouvernorats().getNomGouvernorat();
                   
                case 2:
                    return data.get(rowIndex).getDateitineraire();
          
                case 3:
                     return data.get(rowIndex).getDatepublication();
                
                 case 4:
                     return r.getDistanceitineraire();
                 case 5:
                     Passagers p = (Passagers)Session.getInstance().getUser().getCompte();
            try {
                    participerevents participer  = participereventsDAO.getInstance().FindEventsByIdItinerairesAndPassager(p, data.get(rowIndex));
                    if (participer==null)
                    {
                        return "Disponible";
                    }
                    else if (participer.isEstAccepter())
                    {
                        return "Accepté";
                    }
                    else if (!participer.isEstAccepter())
                    {
                        return "En attente";
                    }
            } catch (ProblemeTechniqueException ex) {
                Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TableModelChercherItineraire.class.getName()).log(Level.SEVERE, null, ex);
            }
                default:
                    return null;
                    
            } 
        
    }
    
    public Itineraire getRowEntity(int rowIndex)
    {
        return data.get(rowIndex);
    }
    
    public boolean  refreshData()
    {
        try
        {
        data= ItineraireDAO.getInstance().getNewItineraireByConfirmation();
        return true;
        }
        catch(Exception ex)
        {
                return false;
        }
    }
}