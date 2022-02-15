/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.model.vjezbanje;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author CP
 */
@Entity
public class Mobitel {
    
    @Id
    private int sifra;
    private String naziv;
    private BigDecimal cijena;
    private Date datumKupnje;
    private boolean ispravan;
    private String opis;
    private String napomena;

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
    

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Date getDatumKupnje() {
        return datumKupnje;
    }

    public void setDatumKupnje(Date datumKupnje) {
        this.datumKupnje = datumKupnje;
    }

    public boolean isIspravan() {
        return ispravan;
    }

    public void setIspravan(boolean ispravan) {
        this.ispravan = ispravan;
    }
    
    
    
}
