/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author jbalog8
 */
@Entity
public class Polaznik extends Osoba{
    
     private String brojUgovora;
     
     @ManyToMany(mappedBy = "polaznici")
     private List<Grupe> grupe;

    public String getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(String brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public List<Grupe> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupe> grupe) {
        this.grupe = grupe;
    }
    
     
     
}
