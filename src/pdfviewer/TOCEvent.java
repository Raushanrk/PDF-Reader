/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfviewer;

/**
 *
 * @author raushan kumar
 */
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Rectangle;
import java.util.*;
import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import javax.swing.text.Document;



public class TOCEvent extends PdfPageEventHelper {

    protected List<SimpleEntry<String, Integer>> toc = new ArrayList<>();

    public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text) {
        toc.add(new SimpleEntry(text, writer.getPageNumber()));
    }

    public List getTOC() {
        return toc;
    }
}
