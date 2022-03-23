/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import edunova.model.Polaznik;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jbalog8
 */
public class PrikazPolaznika extends JLabel implements ListCellRenderer<Polaznik> {

    private String ime;
    private DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    private int maksimalnoZnakovaIme = 12;

    public PrikazPolaznika() {

        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Polaznik> list, Polaznik value, int index, boolean isSelected, boolean cellHasFocus) {
       JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        renderer.setFont(new Font("Courier new", Font.BOLD, 12));

        if (isSelected) {
            renderer.setBackground(Color.BLUE);
            renderer.setForeground(Color.WHITE);
        } else {
            renderer.setBackground(Color.WHITE);
            renderer.setForeground(Color.BLACK);

        }
        ime = value.getIme();
        for (int i = 0; i < maksimalnoZnakovaIme; i++) {
            ime += " ";
        }

        ime = ime.substring(0, maksimalnoZnakovaIme);

        renderer.setText(ime + value.getPrezime());

        return renderer;
    }

}
