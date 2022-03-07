/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author jbalog8
 */
@Entity
public class Smjer extends Entitet{
    
    private String naziv;
    private Integer trajanje;
    private BigDecimal cijena;
    private Boolean certificiran;
    
    @OneToMany(mappedBy = "smjer")
     private List<Grupe> grupe;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Boolean getCertificiran() {
        return certificiran;
    }

    public void setCertificiran(Boolean certificiran) {
        this.certificiran = certificiran;
        
    }

    public List<Grupe> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupe> grupe) {
        this.grupe = grupe;
    }

    @Override
    public String toString() {
        return naziv; 
    }
    
    
    
    
}
