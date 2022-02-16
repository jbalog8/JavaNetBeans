/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model.vjezbanje.nasljedivanje;

import javax.persistence.Entity;

/**
 *
 * @author jbalog8
 */
@Entity
public class Primka extends Dokument{
    private String dobavljac;

    public String getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(String dobavljac) {
        this.dobavljac = dobavljac;
    
}
}
