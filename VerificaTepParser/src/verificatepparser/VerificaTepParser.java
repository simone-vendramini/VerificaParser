/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatepparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author LENOVO
 */
public class VerificaTepParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<Annata> Annate = null;
            Parser dom = new Parser();
            String percorso="xmlVerifica.xml";
            Annate = dom.parseDocument(percorso);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            boolean menu=true;
            String scelta="";
            while(menu){
                 System.out.println("1] ricerca, 2]  Olio di pressione Produzione, 3] Olive da tavola Produzione raccolta, 4] Olive Superficie in produzione, 0]esci");
                 scelta=inFromUser.readLine();
                 switch(scelta){
                     case "1":
                         System.out.println("Inserire anno");
                         int anno=Integer.parseInt(inFromUser.readLine());
                         System.out.println("Inserire regione");
                         String regione=inFromUser.readLine();
                         for (Annata ric:Annate) {
                            if(regione.equals(ric.getRegione())&& anno==ric.getAnno()){
                                System.out.println(ric.toString());
                            }
                        }
                         break;
                     case "2":
                         System.out.println("Inserire anno");
                         int ann=Integer.parseInt(inFromUser.readLine());
                         int conta=0;
                         for (Annata ric:Annate) {
                            if(ann==ric.getAnno()&&"IT".equals(ric.getCodice())){
                                conta+=ric.getOlio_di_pressione_produzione_quintali();
                            }
                        }
                         System.out.println(conta);
                         break;
                     case "3":
                         Annata annata=Annate.get(0);
                         for (Annata ric:Annate) {
                            if(annata.getOlive_da_tavola_produzione_raccolta_quintali()<ric.getOlive_da_tavola_produzione_raccolta_quintali()&&!"IT".equals(ric.getCodice())){
                                annata=ric;
                            }
                        }
                         System.out.println(annata.toString());
                         break;
                     case "4":
                         Annata annat=Annate.get(0);
                         for (Annata ric:Annate) {
                            if(annat.getOlive_superficie_in_produzione()<ric.getOlive_superficie_in_produzione()&&!"IT".equals(ric.getCodice())){
                                annat=ric;
                            }
                        }
                         System.out.println(annat.toString());
                         break;
                     case "0":
                         menu=false;
                         break;
                 }
                 
            }

            for (Annata ric:Annate) {
                System.out.println(ric.toString());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VerificaTepParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(VerificaTepParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerificaTepParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
