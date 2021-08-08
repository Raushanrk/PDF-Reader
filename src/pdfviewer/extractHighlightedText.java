/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfviewer;
import com.spire.pdf.*;  
import java.io.*;  
import com.spire.pdf.annotations.*;  
import com.spire.pdf.graphics.*; 
/**
 *
 * @author raushan kumar
 */
public class extractHighlightedText {  
    public void read(String input) throws Exception {  
//        String input = "Sample.pdf";  
        //Load the PDF file  
        PdfDocument pdf = new PdfDocument();  
        pdf.loadFromFile(input);  
        //Create a new txt file to save the extracted text  
        String result = "sample.txt";  
        File file = new File(result);  
        if (!file.exists()) {  
            file.delete();  
        }  
        file.createNewFile();  
        FileWriter fw = new FileWriter(file, true);  
        BufferedWriter bw = new BufferedWriter(fw);  
        bw.write("Extracted highlighted text:");  
        PdfPageBase page = pdf.getPages().get(0);  
        for (int i = 0; i < page.getAnnotationsWidget().getCount(); i++) {  
            if (page.getAnnotationsWidget().get(i) instanceof PdfTextMarkupAnnotationWidget) {  
                PdfTextMarkupAnnotationWidget textMarkupAnnotation = (PdfTextMarkupAnnotationWidget) page.getAnnotationsWidget().get(i);  
                bw.write(page.extractText(textMarkupAnnotation.getBounds()));  
                //Get the highlighted color  
                PdfRGBColor color = textMarkupAnnotation.getColor();  
                bw.write("Color=" + (color.getR() & 0XFF) + "," + (color.getG() & 0XFF) + "," + (color.getB() & 0XFF) + "\n");  
            }  
        }  
        bw.flush();  
        bw.close();  
        fw.close();  
    }  
}  
