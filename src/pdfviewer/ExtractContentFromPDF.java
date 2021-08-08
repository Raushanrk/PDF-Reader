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

    import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

public class ExtractContentFromPDF {
   public static void main(String[] args) throws Exception {
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File(
         "G:/mechanical books/material science by william calister.pdf"));
      
      ParseContext pcontext = new ParseContext();

      //parsing the document using PDF parser
      PDFParser pdfparser = new PDFParser();
      pdfparser.parse(inputstream, handler, metadata,pcontext);

      //getting the content of the document
      System.out.println("Contents of the PDF :" + handler.toString());

      //getting metadata of the document
      System.out.println("Metadata of the PDF:");
      String[] metadataNames = metadata.names();

      for(String name : metadataNames) {
         System.out.println(name+ " : " + metadata.get(name));
      }
   }
}
    

