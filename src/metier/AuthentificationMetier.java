/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import DAO.AuthentificationDAO;
import DAO.BanissementsDAO;
import Entity.Authentification;
import Entity.Session;
import Entity.Banissement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.Rotation;
import utils.Exceptions.ProblemeTechniqueException;
/**
 *
 * @author Amine
 */
public class AuthentificationMetier {
    
    private Authentification user;

    public Authentification getUser() {
        return user;
    }
    
    
    
    public AuthentificationMetier(){
        user = new Authentification();
    }
    
    public boolean verifierAccee(String login, String pwd) throws ProblemeTechniqueException{
        
        //conditions
            if (login.equals("") || pwd.equals(""))
                return false;
        
        
            user = AuthentificationDAO.getInstance().getByLogin(login);
            
            
            if (user == null)
                return false;
            else
            {                
                if (user.getPassword().equals(utils.Functions.ConvertToMd5(pwd)))
                    return true;
                else
                    return false;
                 
            }
    }
    
    public boolean verifierBan(int idAuthentification) throws ProblemeTechniqueException{
        Date myDate = new Date();
            
        Banissement ban = BanissementsDAO.getInstance().getByIdAuthentificationAndDate(idAuthentification, new java.sql.Date(myDate.getTime()));
        
        if (ban == null)
            return false;
        
        Session.getInstance().setMessage("Vous êtes banni jusqu'au "+ ban.getDateFin() + ".\nLa cause: "+ban.getCause());
        return true;
    }
    
    public boolean loginExistant(String login) throws ProblemeTechniqueException{
        
        if (AuthentificationDAO.getInstance().getByLogin(login) == null)
            return false;
        else 
            return true;
    }
    
    public JFreeChart get3DPieChartsAllDataByYear(int year) throws ProblemeTechniqueException{
        
        List<String> v = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        
        v.add("Conducteurs");
        v.add("Passagers");
        
        if (year ==0)
        {
            k.add(DAO.AuthentificationDAO.getInstance().getNumberByType('c'));
            k.add(DAO.AuthentificationDAO.getInstance().getNumberByType('p'));
        }
        else
        {
            k.add(DAO.AuthentificationDAO.getInstance().getNumberByTypeAndYear(year,'c'));
            k.add(DAO.AuthentificationDAO.getInstance().getNumberByTypeAndYear(year,'p'));
        }
        
        if (Entity.Session.getInstance().estSuperAdministrateur())
        {
            v.add("Administrateur");
            k.add(DAO.AuthentificationDAO.getInstance().getNumberByType('a'));
        }

        String title = "Statistiques des comptes par type";
        if (year !=0)
            title += " pour l'année "+ year;
        
        JFreeChart chart = utils.Statistique.create3DPieChartWithInteger(title, v, k);
        return chart;
        
    }
    
    public JFreeChart getBarChartsTypeDateCreationByYear(int year) throws ProblemeTechniqueException{
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 1; i <= 12; i++) {
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInMonth(year, i, 'p'), "Passager",monthNameByNum(i));
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInMonth(year, i, 'c'), "Conducteur", monthNameByNum(i));
            if (Session.getInstance().estSuperAdministrateur())
                dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInMonth(year, i, 'a'), "Administrateur", monthNameByNum(i));
        }
        
        JFreeChart chart =  ChartFactory.createBarChart("Année "+year, "Date de création", "nombre de comtpe" , dataset, PlotOrientation.VERTICAL, true, true, false);
        
        //on change l'axe des y en integer
        final CategoryPlot plot = chart.getCategoryPlot();
       
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        return chart;
    }
    
    public JFreeChart getBarChartsTypeDateCreationByYearVertical(int year) throws ProblemeTechniqueException{
        JFreeChart result = getBarChartsTypeDateCreationByYear(year);
        
        CategoryAxis xAxis = (CategoryAxis)result.getCategoryPlot().getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        return result;
    }
    
    public JFreeChart getBarChartsTypeDateCreationByYearandMonth(int year, int month) throws ProblemeTechniqueException{
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        Calendar c = Calendar.getInstance();
        
        for (int i = 1; i <= 28; i++) {
            c.set(year, month-1, i);
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'p'), "Passager",i+"");
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'c'), "Conducteur",i+"");
            if (Session.getInstance().estSuperAdministrateur())
                dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'a'), "Administrateur",i+"");
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
            c.set(year, month-1, i);
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'p'), "Passager",i+"");
            dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'c'), "Conducteur",i+"");
            if (Session.getInstance().estSuperAdministrateur())
                dataset.addValue(AuthentificationDAO.getInstance().getNumberByDateCreationInDay(new java.sql.Date(c.getTime().getTime()), 'a'), "Administrateur",i+"");
        }
        
        JFreeChart chart =  ChartFactory.createBarChart("Année "+year + " / "+monthNameByNum(month), "Date de création", "nombre de comtpe" , dataset, PlotOrientation.VERTICAL, true, true, false);
        
        //on change l'axe des y en integer
        final CategoryPlot plot = chart.getCategoryPlot();
       
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        return chart;
    }
    
    public JFreeChart getBarChartsTypeDateCreationByYearandMonthVertical(int year, int month) throws ProblemeTechniqueException{
        JFreeChart result = getBarChartsTypeDateCreationByYearandMonth(year, month);
        
        CategoryAxis xAxis = (CategoryAxis)result.getCategoryPlot().getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        return result;
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
    
    //selectionner la ligne qui contient le login type de retour Idauthentification
    
    public Authentification FindIdByLogin(String login) throws ProblemeTechniqueException
    {
        
        user = DAO.AuthentificationDAO.getInstance().getByLogin(login);
        return user ;  
    }
    
      //Supprimer l'Authentification d'un administrateur
    
    public boolean DeleteAuthentification(Authentification authentification) throws ProblemeTechniqueException
    {
        return  DAO.AuthentificationDAO.getInstance().delete(authentification);
    }
    
    
}
