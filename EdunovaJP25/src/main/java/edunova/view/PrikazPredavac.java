/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import edunova.model.Predavac;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jbalog8
 */
public class PrikazPredavac extends JLabel implements ListCellRenderer<Predavac>{
    
    public PrikazPredavac(){
        
        setOpaque(true);
}

    @Override
    public Component getListCellRendererComponent(JList<? extends Predavac> list, Predavac value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        
        setText((value.getIme()==null ? "Nepoznato" : value.getIme())
                + " " + (value.getPrezime()==null ? "Nepoznato" : value.getPrezime()));

        return this;
    }
    
}
