/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.components.jtable;
import java.util.*;
import Entity.Rapport;
import DAO.RapportDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exceptions.ProblemeTechniqueException;
/**
 *
 * @author user
 */
public class tableModelGererRapport extends javax.swing.table.AbstractTableModel
{
    private List<Rapport> data;
    private String [] entetes ={"dateRapport","cause","Itineraires","traiter"}; 
    
    
    public tableModelGererRapport() 
    {
        try {
            data=RapportDAO.getInstance().getAllRapportNonTraiter();
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
        Rapport r= (Rapport)data.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getDaterapport();
            case 1:
                return data.get(rowIndex).getCause();
            case 2:
                return data.get(rowIndex).getIditineraire().getDescription();
            case 3:
                if (data.get(rowIndex).isTraiter())
                {
                    return "Oui";
                }
                else
                {
                    return "Non";
                }
            default:
                return null;
        }
    }
    
    public Rapport getRowEntity(int rowIndex)
    {
        return data.get(rowIndex);
    }
    
    public boolean  refreshData()
    {
        try
        {
        data= RapportDAO.getInstance().getRapport();
        return true;
        }
        catch(Exception ex)
        {
                return false;
        }
    }
}
