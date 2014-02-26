/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Amine
 */
public class Statistique {
    
    public static JFreeChart create3DPieChartWithFloat(String title, List<String> values, List<Float> keys){
        PieDataset dataset = createPieDatasetWithFloat(values,keys);
        
        return createPieChart(dataset, title);
    }
    
    private static  PieDataset createPieDatasetWithFloat(List<String> values, List<Float> keys) {
        DefaultPieDataset result = new DefaultPieDataset();
        
        for (int i = 0; i < keys.size(); i++) {
            result.setValue(values.get(i), keys.get(i));
        }
        return result;
    }
    
    public static JFreeChart create3DPieChartWithInteger(String title, List<String> values, List<Integer> keys){
        PieDataset dataset = createPieDatasetWithInteger(values,keys);
        
        return createPieChart(dataset, title);
    }
    
    private static  PieDataset createPieDatasetWithInteger(List<String> values, List<Integer> keys) {
        DefaultPieDataset result = new DefaultPieDataset();
        
        for (int i = 0; i < keys.size(); i++) {
            result.setValue(values.get(i), keys.get(i));
        }
        return result;
    }
    
    private static  JFreeChart createPieChart(PieDataset dataset, String title) {
        
        JFreeChart chart =  ChartFactory.createPieChart3D(title, dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.7f);
            
        return chart;
    }
    
    //Bar charts
    
    public static JFreeChart createBarChart(String title, List<String> values, List<Integer> keys, String ch, String xaxisLabel,String yaxisLabel){
        CategoryDataset dataset = createBarDataset(values,keys,ch);
        
        return createBarChart(dataset, title, xaxisLabel, yaxisLabel);
    }
    
    private static CategoryDataset createBarDataset(List<String> values, List<Integer> keys, String ch){
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        
        for (int i = 0; i < keys.size(); i++) {
            result.setValue(keys.get(i), ch, values.get(i));
        }
        return result;
    }
    
    private static  JFreeChart createBarChart(CategoryDataset dataset, String title, String xaxisLabel,String yaxisLabel ) {
        
        JFreeChart chart =  ChartFactory.createBarChart(title, (xaxisLabel == null) ? "" : xaxisLabel, (yaxisLabel == null) ? "" : yaxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        
        return chart;
    }
    
}
