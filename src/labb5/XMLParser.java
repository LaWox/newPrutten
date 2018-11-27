package labb5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;


public class XMLParser {

    Document doc;

    XMLParser(String filepath){
        this.doc = getDocument(filepath);
    }

    XMLParser(){
        this.doc = getDocument("labb5/Liv.xml");
    }



    public static Document getDocument(String filePath){
        try{
            File inputFile = new File(filePath);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            return document;

        }
        catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public static void main(String[] arg){
        XMLParser run= new XMLParser();
        System.out.println(run.doc.getRootElement().getName());

    }
}
