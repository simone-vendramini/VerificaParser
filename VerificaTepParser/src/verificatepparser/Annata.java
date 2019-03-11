/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificatepparser;

/**
 *
 * @author LENOVO
 */
public class Annata {
    private String regione, codice;
    private int anno, olive_superficie, olive_superficie_in_produzione, olive_produzione_quintali, olive_da_tavola_produzione_raccolta_quintali, olive_da_tavola_produzione_quintali, olive_da_olio_produzione_quintali, olio_di_pressione_produzione_quintali;
    private double olio_di_pressione_resa_di_produzione_quintali;

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getOlive_superficie() {
        return olive_superficie;
    }

    public void setOlive_superficie(int olive_superficie) {
        this.olive_superficie = olive_superficie;
    }

    public int getOlive_superficie_in_produzione() {
        return olive_superficie_in_produzione;
    }

    public void setOlive_superficie_in_produzione(int olive_superficie_in_produzione) {
        this.olive_superficie_in_produzione = olive_superficie_in_produzione;
    }

    public int getOlive_produzione_quintali() {
        return olive_produzione_quintali;
    }

    public void setOlive_produzione_quintali(int olive_produzione_quintali) {
        this.olive_produzione_quintali = olive_produzione_quintali;
    }

    public int getOlive_da_tavola_produzione_raccolta_quintali() {
        return olive_da_tavola_produzione_raccolta_quintali;
    }

    public void setOlive_da_tavola_produzione_raccolta_quintali(int olive_da_tavola_produzione_raccolta_quintali) {
        this.olive_da_tavola_produzione_raccolta_quintali = olive_da_tavola_produzione_raccolta_quintali;
    }

    public int getOlive_da_tavola_produzione_quintali() {
        return olive_da_tavola_produzione_quintali;
    }

    public void setOlive_da_tavola_produzione_quintali(int olive_da_tavola_produzione_quintali) {
        this.olive_da_tavola_produzione_quintali = olive_da_tavola_produzione_quintali;
    }

    public int getOlive_da_olio_produzione_quintali() {
        return olive_da_olio_produzione_quintali;
    }

    public void setOlive_da_olio_produzione_quintali(int olive_da_olio_produzione_quintali) {
        this.olive_da_olio_produzione_quintali = olive_da_olio_produzione_quintali;
    }

    public int getOlio_di_pressione_produzione_quintali() {
        return olio_di_pressione_produzione_quintali;
    }

    public void setOlio_di_pressione_produzione_quintali(int olio_di_pressione_produzione_quintali) {
        this.olio_di_pressione_produzione_quintali = olio_di_pressione_produzione_quintali;
    }

    public double getOlio_di_pressione_resa_di_produzione_quintali() {
        return olio_di_pressione_resa_di_produzione_quintali;
    }

    public void setOlio_di_pressione_resa_di_produzione_quintali(double olio_di_pressione_resa_di_produzione_quintali) {
        this.olio_di_pressione_resa_di_produzione_quintali = olio_di_pressione_resa_di_produzione_quintali;
    }

    public Annata(String regione, int anno, String codice, int olive_superficie, int olive_superficie_in_produzione, int olive_produzione_quintali, int olive_da_tavola_produzione_raccolta_quintali, int olive_da_tavola_produzione_quintali, int olive_da_olio_produzione_quintali, int olio_di_pressione_produzione_quintali, double olio_di_pressione_resa_di_produzione_quintali) {
        this.regione = regione;
        this.anno = anno;
        this.codice = codice;
        this.olive_superficie = olive_superficie;
        this.olive_superficie_in_produzione = olive_superficie_in_produzione;
        this.olive_produzione_quintali = olive_produzione_quintali;
        this.olive_da_tavola_produzione_raccolta_quintali = olive_da_tavola_produzione_raccolta_quintali;
        this.olive_da_tavola_produzione_quintali = olive_da_tavola_produzione_quintali;
        this.olive_da_olio_produzione_quintali = olive_da_olio_produzione_quintali;
        this.olio_di_pressione_produzione_quintali = olio_di_pressione_produzione_quintali;
        this.olio_di_pressione_resa_di_produzione_quintali = olio_di_pressione_resa_di_produzione_quintali;
    }
    
    public Annata(){
    }
    
    public String toString(){
        return codice + " - " + regione + " - " + anno + " - " + olive_superficie + " - " + olive_superficie_in_produzione + " - " + olive_produzione_quintali + " - " + olive_da_tavola_produzione_raccolta_quintali + " - " + olive_da_tavola_produzione_quintali + " - " + olive_da_olio_produzione_quintali + " - " + olio_di_pressione_produzione_quintali + " - " + olio_di_pressione_resa_di_produzione_quintali;
    }
}
