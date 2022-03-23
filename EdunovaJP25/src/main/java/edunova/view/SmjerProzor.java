/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.view;

import edunova.kontroler.ObradaSmjer;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import edunova.util.EdunovaUtil;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jbalog8
 */
public class SmjerProzor extends javax.swing.JFrame {

    private ObradaSmjer obrada;
    private DecimalFormat nf;

    /**
     * Creates new form SmjerProzor
     */
    public SmjerProzor() {
        initComponents();
        obrada = new ObradaSmjer();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("hr", "HR"));
        nf = new DecimalFormat("###,###.00", symbols);
        setTitle(EdunovaUtil.getNaslov("Smjerovi"));
        ucitaj();
    }

    private void ucitaj() {
        DefaultListModel<Smjer> m = new DefaultListModel<>();
        List<Smjer> entiteti = obrada.read();

        //sortiranje u javi
        /*
        Collections.sort(entiteti,new Comparator<Smjer>() {
            @Override
            public int compare(Smjer o1, Smjer o2) {
                return o1.getNaziv().compareTo(o2.getNaziv());
            }
        });
         */
        for (Smjer s : entiteti) {
            m.addElement(s);
        }
        lstEntiteti.setModel(m);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTrajanje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        chbCertificiran = new javax.swing.JCheckBox();
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Naziv");

        jLabel2.setText("Trajanje");

        txtTrajanje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Cijena");

        txtCijena.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        chbCertificiran.setText("Certificiran");

        btnKreiraj.setText("Kreiraj");
        btnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(chbCertificiran)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCijena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(txtTrajanje, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnKreiraj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chbCertificiran)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKreiraj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        var s = obrada.getEntitet();
        txtNaziv.setText(s.getNaziv());
        txtTrajanje.setText(s.getTrajanje().toString());
        txtCijena.setText(s.getCijena() != null ? nf.format(s.getCijena()) : "");
        chbCertificiran.setSelected(s.getCertificiran() != null ? s.getCertificiran() : false);
    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            obrada.setEntitet(new Smjer());
            preuzmiVrijednosti();
            obrada.create();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnKreirajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        preuzmiVrijednosti();

        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite stavku");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati \"" + obrada.getEntitet().getNaziv() + "\"?", 
                "Brisanje", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
            return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void preuzmiVrijednosti() {
        var s = obrada.getEntitet();
        s.setNaziv(txtNaziv.getText());
        try {
            s.setTrajanje(Integer.parseInt(txtTrajanje.getText()));
        } catch (Exception e) {
            s.setTrajanje(0);
        }
        try {
            
            s.setCijena(new BigDecimal(nf.parse(txtCijena.getText()).toString()));
        } catch (Exception e) {
            s.setCijena(BigDecimal.ZERO);
        }
        s.setCertificiran(chbCertificiran.isSelected());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JCheckBox chbCertificiran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Smjer> lstEntiteti;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTrajanje;
    // End of variables declaration//GEN-END:variables
}
