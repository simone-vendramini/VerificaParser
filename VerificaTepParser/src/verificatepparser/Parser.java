/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatepparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author LENOVO
 */
public class Parser {
     private List ricevimenti;

    public Parser() {
        ricevimenti = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Annata annata;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "libro"
        nodelist = root.getElementsByTagName("row");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                    element = (Element) nodelist.item(i);
                    annata = getAnnata(element);
                    ricevimenti.add(annata);
            }
        }
        return ricevimenti;
    }

    private Annata getAnnata(Element element) {
        Annata annata;
        NodeList nodelist;
        String regione="", codice="";
        int anno=0, olive_superficie=0, olive_superficie_in_produzione=0, olive_produzione_quintali=0,
                olive_da_tavola_produzione_raccolta_quintali=0, olive_da_tavola_produzione_quintali=0, olive_da_olio_produzione_quintali=0,
                olio_di_pressione_produzione_quintali=0;
        double olio_di_pressione_resa_di_produzione_quintali=0;
        Element elemento;
        
        nodelist = element.getElementsByTagName("anno");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                String an=getTextValue(elemento);
                String[] parts =an.split("\"");
                anno=Integer.parseInt(parts[1]);
            }
        }
        
        nodelist = element.getElementsByTagName("codice");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                String an=getTextValue(elemento);
                String[] parts =an.split("\"");
                codice=parts[1];
            }
        }
        
        nodelist = element.getElementsByTagName("regioni");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                String an=getTextValue(elemento);
                String[] parts =an.split("\"");
                regione=parts[1];
            }
        }
        
        nodelist = element.getElementsByTagName("olive_superficie__ha_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_superficie=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olive_superficie_in_produzione__ha_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_superficie_in_produzione=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olive_produzione__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_produzione_quintali=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olive_da_tavola_produzione_raccolta__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_da_tavola_produzione_raccolta_quintali=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olive_da_tavola_produzione__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_da_tavola_produzione_quintali=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olive_da_olio_produzione__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olive_da_olio_produzione_quintali=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olio_di_pressione_resa_di_produzione__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olio_di_pressione_resa_di_produzione_quintali=Double.parseDouble(getTextValue(elemento));
            }
        }
        
        nodelist = element.getElementsByTagName("olio_di_pressione_produzione__quintali_");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                elemento = (Element) nodelist.item(i);
                olio_di_pressione_produzione_quintali=Integer.parseInt(getTextValue(elemento));
            }
        }
        
        annata = new Annata(regione, anno, codice, olive_superficie, olive_superficie_in_produzione, olive_produzione_quintali, olive_da_tavola_produzione_raccolta_quintali, olive_da_tavola_produzione_quintali, olive_da_olio_produzione_quintali, olio_di_pressione_produzione_quintali, olio_di_pressione_resa_di_produzione_quintali);
        return annata;
    }
    
    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element) {
        String value = null;
        if (element != null ) {
            Node el = element.getFirstChild();
            if(el!=null){
                value = el.getNodeValue();
            }
        }
        return value;
    }
}
