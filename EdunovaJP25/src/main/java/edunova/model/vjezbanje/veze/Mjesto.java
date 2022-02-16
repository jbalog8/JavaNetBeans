/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model.vjezbanje.veze;

import edunova.model.vjezbanje.nasljedivanje.Dokument;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author jbalog8
 */
@Entity
public class Mjesto extends Dokument{
    
    private String naziv;
    @ManyToOne
    private Opcina opcina;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Opcina getOpcina() {
        return opcina;
    }

    public void setOpcina(Opcina opcina) {
        this.opcina = opcina;
    }
}
