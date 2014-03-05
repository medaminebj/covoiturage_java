/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Jpeg;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Amine
 */
public class pdf {
    
    private final int width = 500;
    private final int height = 400;
    
    private final Font prefaceTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
    private final Font simpleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    
    private PdfWriter writer;
    private Document document;
    private String urlDocument = "C:\\Users\\Amine\\Desktop\\amine\\aminePdf.pdf";
    
    private Paragraph preface = new Paragraph();
    private Paragraph first;
    private List<BufferedImage> pages;
    private List<String> titlesPages;
    private Paragraph last;
    
    
    public pdf(){
        pages = new ArrayList<>();
        titlesPages = new ArrayList<>();
    }
    
    
    public boolean createPDFFile(String title,String auteur){
        try {
            document = new Document(PageSize.A4, 36, 36, 54, 54);
            writer = PdfWriter.getInstance(document, new FileOutputStream(urlDocument));
            document.open();
            
            //on ajoute les meta données
            createMetaDataInfo(title, auteur);
            
            //on ajoute la page de garde
            createPrefacePage(title, auteur);
            document.newPage();
            
            //on ajoute la premier page
            createFirstPage();
            document.newPage();
            
            //on ajoute les pages
            createPages();
            //on ajoute la derniere page
            createLastPage();
            
            document.close();
            writer.close();
            
            return true;
        } catch (Exception ex) {
            System.out.println("probleme createPDFFile");
            return false;
        }
    }
    
    private void createMetaDataInfo(String title, String auteur){
        document.addAuthor(auteur);
        document.addTitle(title);
        document.addCreationDate();
    }
    
    private void createPrefacePage(String title,String auteur){
        try {
            Paragraph auxP = new Paragraph(title, prefaceTitleFont);
            auxP.setAlignment(Element.ALIGN_CENTER);
            preface.add(auxP);
            
            addEmptyLines(preface, 5);
            
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
            auxP = new Paragraph("Ce documenet a été générer par "+auteur+ " le "+ df.format(new Date()), new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL));
            preface.add(auxP);
            
            addEmptyLines(preface, 8);
            
            
            Image img = Image.getInstance("src/assets/baby.png");
            preface.add(img);
            
            addEmptyLines(preface, 12);
            
            auxP = new Paragraph("\u00a9 Dev Boys ESPRIT "+Calendar.getInstance().get(Calendar.YEAR), simpleFont);
            auxP.setAlignment(Element.ALIGN_CENTER);
            
            preface.add(auxP);
            
            document.add(preface);
        } catch (Exception ex) {
            System.out.println("Probleme createPrefacePage");
        }
    }
    
    private void createFirstPage() throws DocumentException{
        if (first != null)
        {
            document.add(first);
        }
    }
    
    private void createPages() throws DocumentException, BadElementException, IOException
    {
        Paragraph auxP ;
        Image image;
        
        for (int i = 0; i < pages.size(); i++) {
            auxP = new Paragraph(titlesPages.get(i), prefaceTitleFont);
            auxP.setAlignment(Element.ALIGN_CENTER);
            
            addEmptyLines(auxP, 5);
            
            document.add(auxP);
            
            auxP = new Paragraph();
            
            image = Image.getInstance(writer, pages.get(i), 1.0f);
            auxP.add(image);
            
            document.add(auxP);
            document.newPage();
        }
    }
    
    private void createLastPage() throws DocumentException{
        if (last != null)
        {
            document.add(last);
        }
    }
    
    private void addEmptyLines(Paragraph paragraph, int number){
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public Paragraph getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = new Paragraph(first);
        this.first.setAlignment(Element.ALIGN_JUSTIFIED);
    }

    public Paragraph getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = new Paragraph(last);
        this.last.setAlignment(Element.ALIGN_JUSTIFIED);
    }
    
    public void addPage(JFreeChart chart, String title){
        pages.add(chart.createBufferedImage(width, height));
        titlesPages.add(title);
    }
    
}
