/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zavrsnirad.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jbalog8
 */
@Entity
public class Odjel {
    @Id
    private int sifra;
    private String naziv;
    
}
