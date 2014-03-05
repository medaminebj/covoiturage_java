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
    private String [] entetes ={"Date itinéraire","Date de publication","Ville de départ","Ville d'arriver","Distance itinéraire","Confirmer"}; 
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
                    return data.get(rowIndex).getDateitineraire();
                case 1:
                    return data.get(rowIndex).getDatepublication();
                case 2:
           
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
                case 3:
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
                
                 case 4:
                     return r.getDistanceitineraire();
                 case 5:
                     if(r.isEstconfirmer()==true)
                     {
                         return "Oui" ;
                     }
                     else
                     {
                         return "Non";
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