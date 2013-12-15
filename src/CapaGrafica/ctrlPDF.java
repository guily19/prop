/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaGrafica;
import CapaDomini.Prestatge;
import CapaDomini.Producte;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author toni
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class ctrlPDF {
   
    private static final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
        }
      }
 
    public ctrlPDF(Prestatge p) throws FileNotFoundException, DocumentException{
        String file = System.getProperty("user.dir") + "/Cataleg/PDF/" + p.getNom();
         Document document = new Document();
         PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph(p.getNom(), catFont));
        addEmptyLine(preface, 1);
        String param = new String();
        for(int i = 0; i < p.getSolucio().size(); ++i) param = param.concat(p.getSolucio().get(i) + " ");
        preface.add(new Paragraph("Orden del prestatge: ",smallBold));
        preface.add(new Paragraph(param, smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph("Lista de productos: " , smallBold));
        param = "";
        for(int i = 0; i < p.getSolucio().size(); ++i){
            Producte prod = p.getLlista().getArrayproductes().get(i);
            param = param.concat("ID: " + Integer.toString(prod.getId()) + "   Nom: " + prod.getNom() + "    Tipus: " + prod.getTipus() + "    Subtipus: " + prod.getSubtipus() + "\n");
        }
        preface.add(new Paragraph(param, smallBold));
        document.add(preface);
        document.close();
    }
}
