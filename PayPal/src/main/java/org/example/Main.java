package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;


public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


       // String filePath = "/Users/sudhathiruvengadam/Documents/Testing/invoice.pdf";
        File file = new File("/Users/sudhathiruvengadam/Documents/Testing/invoice.pdf");
//        try {
//            // Load the PDF document from the file
//            PDDocument document = PDDocument.load(new File(filePath));
//
//            // Get the number of pages in the document
//            int pageCount = document.getNumberOfPages();
//            System.out.println("Number of pages: " + pageCount);
//
//            // Close the document when done
//            document.close();
//        } catch (IOException e) {
//            // Handle file loading errors
//            e.printStackTrace();
//        }
        try (InputStream inputStream = new FileInputStream(file)) {
            Metadata metadata = new Metadata();
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler(-1); // Unlimited character limit
            ParseContext parseContext = new ParseContext();

            parser.parse(inputStream, handler, metadata, parseContext);

            // Check metadata fields for password protection indicators
            String isProtected = metadata.get("protected");

            System.out.println("metadata:" +metadata);

            // Print password protection status
            System.out.println("Is Password Protected: " + isProtected);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}