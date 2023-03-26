package com.Vijay;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.StringWriter;

public class DOMParserDTD {

    public static void main(String[] args) {
        String dtdFileName = "employee.dtd";
        String xmlFileName = "employee.xml";
        Document document = parseXmlDomFile(xmlFileName);
        validateXmlAgainstDTD(document, dtdFileName);
    }

    public static void validateXmlAgainstDTD(Document document, String dtdFileName) {
        System.out.println("Begin validateXmlAgainstDTD");
        try {
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new StringWriter());
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dtdFileName);
            transformer.transform(domSource, streamResult);
            System.out.println("Validating XML against DTD is successful");
        } catch (TransformerConfigurationException e) {
            System.out.println("TransformerConfigurationException in validateXmlAgainstDTD:: "+e.getMessage());
        } catch (TransformerException e) {
            System.out.println("TransformerException in validateXmlAgainstDTD:: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception validateXmlAgainstDTD:: "+e.getMessage());
        }
        System.out.println("End validateXmlAgainstDTD");
    }

    public static Document parseXmlDomFile(String xmlFileName) {
        System.out.println("Begin parseXmlDomFile");
        Document document = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(new FileInputStream(xmlFileName));
            System.out.println("Parsing XML DOM File is successful");

        } catch (Exception e) {
            System.out.println("Exception in parseXmlDomFile:: "+ e.getMessage());
        }
        System.out.println("End parseXmlDomFile");
        return document;
    }

}
