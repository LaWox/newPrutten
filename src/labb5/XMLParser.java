package labb5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class XMLParser {

    Document doc;

    XMLParser(){
        this.doc = getDocument("src/labb5/Liv.xml");
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
}
