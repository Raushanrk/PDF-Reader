/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfviewer;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author raushan kumar
 */
public class pdfview {
     public void createPdf(String dest)  {
    Document document = new Document() {
        @Override
        public int getLength() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addDocumentListener(DocumentListener listener) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeDocumentListener(DocumentListener listener) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void addUndoableEditListener(UndoableEditListener listener) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void removeUndoableEditListener(UndoableEditListener listener) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object getProperty(Object key) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void putProperty(Object key, Object value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getText(int offset, int length) throws BadLocationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void getText(int offset, int length, Segment txt) throws BadLocationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Position getStartPosition() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Position getEndPosition() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Position createPosition(int offs) throws BadLocationException {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Element[] getRootElements() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Element getDefaultRootElement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void render(Runnable r) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    PdfWriter writer = PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(dest));
    TOCEvent event = new TOCEvent();
    writer.setPageEvent(event);
    document.open();
         Font titleFont = null;
    for (int i = 0; i < 10; i++) {
        String title = "This is title " + i;
        Chunk c = new Chunk(title, titleFont);
        c.setGenericTag(title);
        document.add(new Paragraph(c));
        for (int j = 0; j < 50; j++) {
            document.add(new Paragraph("Line " + j + " of title " + i));
        }
    }
    document.newPage();
    document.add(new Paragraph("Table of Contents", titleFont));
    Chunk dottedLine = new Chunk(new DottedLineSeparator());
    List<SimpleEntry<String, Integer>> entries = event.getTOC();
    Paragraph p;
    for (SimpleEntry<String, Integer> entry : entries) {
        p = new Paragraph(entry.getKey());
        p.add(dottedLine);
        p.add(String.valueOf(entry.getValue()));
        document.add(p);
    }
    document.close();
} 
    
    public static void main(String args[]) {
        pdfview pdf=new pdfview();
          try{ 
              pdf.createPdf("G:\\vishal\\raushan");
          }
          catch(Exception e){
               System.out.println("SOrry");
          }
    }
    
    
}
