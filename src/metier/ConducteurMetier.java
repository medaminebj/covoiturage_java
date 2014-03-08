/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.AuthentificationDAO;
import DAO.ConducteursDAO;
import Entity.Conducteurs;
import Entity.Itineraire;
import Entity.Session;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author user
 */
public class ConducteurMetier 
{
    private Conducteurs conducteur;

    public Conducteurs getConducteurs() 
    {
        return conducteur;
    }
    
    public List<Conducteurs> getAllConducteurs() throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     List<Conducteurs> tabConducteurs = new ArrayList();
     tabConducteurs= DAO.ConducteursDAO.getInstance().getAll();
     if (tabConducteurs==null)
         return null ; 
     else 
         return tabConducteurs ; 
     
     
    }
    
     public Conducteurs getConducteursById(int id) throws SQLException, ClassNotFoundException, ProblemeTechniqueException
    {
     boolean test = false ; 
     Conducteurs tabConducteurs = new Conducteurs();
     tabConducteurs = DAO.ConducteursDAO.getInstance().getByID(id);
     if (tabConducteurs==null)
         return null ; 
     else 
         return tabConducteurs ; 
     
     
    }
     
     public JFreeChart getbeneficeByYear(int id, int year) throws ProblemeTechniqueException{
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double fff;
        for (int i = 1; i <= 12; i++) {
            fff = ConducteursDAO.getInstance().getBeneficeByidConcducteurInYearAndMonth(id, year, i);
            dataset.addValue(fff, "Conducteur", monthNameByNum(i));
        }
        
        JFreeChart chart =  ChartFactory.createBarChart("Année "+year, "Date de création", "Bénéfice" , dataset, PlotOrientation.VERTICAL, true, true, false);
        
        //on change l'axe des y en integer
        final CategoryPlot plot = chart.getCategoryPlot();
       
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        return chart;
     }
     
     
    public JFreeChart getbeneficeByYearAndMonth(int id, int year, int month) throws ProblemeTechniqueException{
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Calendar c = Calendar.getInstance();
        
        for (int i = 1; i <= 28; i++) {
            //c.set(year, month-1, i);
            dataset.addValue(ConducteursDAO.getInstance().getBeneficeByidConcducteurInYearAndMonthAndDay(id, year, month, i),"b",i+"");
        }
        
        int finalMonth = 28;
        
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                finalMonth = 31;
                break;
            case 2:
                if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))//année bissextile 
                {
                     finalMonth = 29;
                }
                break;
            case 4:
            case 6: 
            case 9:
            case 11:
                finalMonth = 30;
                break;
        }
        
        finalMonth++;
        for (int i = 29; i < finalMonth; i++) {
            dataset.addValue(ConducteursDAO.getInstance().getBeneficeByidConcducteurInYearAndMonthAndDay(id, year, month, i),"b",i+"");
        }
        
        JFreeChart chart =  ChartFactory.createBarChart("Année "+year + " / "+monthNameByNum(month), "Date de création", "nombre de comtpe" , dataset, PlotOrientation.VERTICAL, true, true, false);
        
        //on change l'axe des y en integer
        final CategoryPlot plot = chart.getCategoryPlot();
       
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        return chart;
     }
    
     private String monthNameByNum(int num){
        switch (num){
            case 1:
                return "Janvier";
            case 2:
                return "Février";
            case 3:
                return "Mars";
            case 4:
                return "Avril";
            case 5:
                return "Mars";
            case 6:
                return "Juin";
            case 7:
                return "Juillet";
            case 8:
                return "Aout";
            case 9:
                return "Septembre";
            case 10:
                return "Octobre";
            case 11:
                return "Novombre";
            case 12:
                return "Décembre";
            default:
                return null;
        }
    }
}
