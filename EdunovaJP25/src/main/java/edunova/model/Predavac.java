/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author jbalog8
 */
@Entity
public class Predavac extends Osoba{

    private String iban;  
    
    @OneToMany(mappedBy = "predavac")
    private List<Grupe> grupe;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public List<Grupe> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupe> grupe) {
        this.grupe = grupe;
    }
    
}
