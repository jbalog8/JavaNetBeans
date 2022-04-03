/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edunova.kontroler.ObradaGrupe;
import edunova.kontroler.ObradaPolaznik;
import edunova.kontroler.ObradaPredavac;
import edunova.kontroler.ObradaSmjer;

import edunova.model.Grupe;
import edunova.model.Polaznik;
import edunova.model.Predavac;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import edunova.util.EdunovaUtil;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jbalog8
 */
public class GrupaProzor extends javax.swing.JFrame {

    private ObradaGrupe obrada;
    private ObradaPolaznik obradaPolaznik;

    /**
     * Creates new form SmjerProzor
     */
    public GrupaProzor() {
        initComponents();
        obrada = new ObradaGrupe();
        obradaPolaznik = new ObradaPolaznik();
        setTitle(EdunovaUtil.getNaslov("Grupe"));
        ucitaj();
        ucitajSmjerove();
        ucitajPredavace();
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumPocetka.setSettings(dps);
        lstPolazniciNaGrupi.setCellRenderer(new PrikazPolaznika());
    }

    private void ucitajSmjerove() {
        DefaultComboBoxModel<Smjer> ms = new DefaultComboBoxModel<>();
        Smjer smjer = new Smjer();
        smjer.setSifra(Long.valueOf(0));
        smjer.setNaziv("Nije odabrano");
        ms.addElement(smjer);
        new ObradaSmjer().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbSmjerovi.setModel(ms);
    }

    private void ucitajPredavace() {
        DefaultComboBoxModel<Predavac> ms = new DefaultComboBoxModel<>();
        Predavac predavac = new Predavac();
        predavac.setSifra(Long.valueOf(0));
        predavac.setIme("Nije");
        predavac.setPrezime("odabrano");
        ms.addElement(predavac);
        new ObradaPredavac().read().forEach(s -> {
            ms.addElement(s);
        });
        cmbPredavaci.setModel(ms);
    }

    private void ucitaj() {
        DefaultListModel<Grupe> m = new DefaultListModel<>();
        List<Grupe> entiteti = obrada.read();

        for (Grupe s : entiteti) {
            m.addElement(s);
        }
        // implementirati ćemo custom renderer https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
        lstEntiteti.setModel(m);
    }

    private void ucitajPolaznike() {
        DefaultListModel<Polaznik> m = new DefaultListModel<>();
        List<Polaznik> entiteti;

        if (chbPocetakPrezimena.isSelected()) {
            entiteti = obradaPolaznik.readPocetakPrezime(txtUvjet.getText().trim());
        } else {
            entiteti = obradaPolaznik.read(txtUvjet.getText());
        }

        Collections.sort(entiteti, new PolaznikComparator());

        for (Polaznik s : entiteti) {
            m.addElement(s);
        }
        // implementirati ćemo custom renderer https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
        lstPolazniciUSkoli.setModel(m);
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
        btnKreiraj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbSmjerovi = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbPredavaci = new javax.swing.JComboBox<>();
        dpDatumPocetka = new com.github.lgooddatepicker.components.DatePicker();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPolazniciNaGrupi = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPolazniciUSkoli = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnTrazi = new javax.swing.JButton();
        chbPocetakPrezimena = new javax.swing.JCheckBox();
        btnDodajPolaznike = new javax.swing.JButton();
        btnObrisiPolaznike = new javax.swing.JButton();
        btnExportJSON = new javax.swing.JButton();
        btnPosaljiEmail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Naziv");

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

        jLabel2.setText("Smjer");

        jLabel3.setText("Predavač");

        jLabel4.setText("Datum početka");

        lstPolazniciNaGrupi.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(lstPolazniciNaGrupi);

        jLabel6.setText("Polaznici na grupi");

        jScrollPane4.setViewportView(lstPolazniciUSkoli);

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        jLabel7.setText("Traži po imenu, prezimenu ili OIB-u");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        chbPocetakPrezimena.setText("Početak prezimena");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTrazi))
                    .addComponent(jLabel7)
                    .addComponent(chbPocetakPrezimena))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbPocetakPrezimena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnDodajPolaznike.setText("<<");
        btnDodajPolaznike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPolaznikeActionPerformed(evt);
            }
        });

        btnObrisiPolaznike.setText(">>");
        btnObrisiPolaznike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPolaznikeActionPerformed(evt);
            }
        });

        btnExportJSON.setText("Export JSON");
        btnExportJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportJSONActionPerformed(evt);
            }
        });

        btnPosaljiEmail.setText("Pošalji e-mail");
        btnPosaljiEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosaljiEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreiraj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportJSON)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPosaljiEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbSmjerovi, javax.swing.GroupLayout.Alignment.LEADING, 0, 226, Short.MAX_VALUE)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbPredavaci, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajPolaznike, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObrisiPolaznike, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbSmjerovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbPredavaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addGap(2, 2, 2)
                                                .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jScrollPane3)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDodajPolaznike)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObrisiPolaznike)
                                        .addGap(91, 91, 91))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 33, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKreiraj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi)
                            .addComponent(btnExportJSON)
                            .addComponent(btnPosaljiEmail))
                        .addGap(24, 24, 24))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        var e = obrada.getEntitet();
        txtNaziv.setText(e.getNaziv());

        if (e.getSmjer() == null) {
            cmbSmjerovi.setSelectedIndex(0);
        } else {
            cmbSmjerovi.setSelectedItem(e.getSmjer());
        }

        if (e.getPredavac() == null) {
            cmbPredavaci.setSelectedIndex(0);
        } else {
            cmbPredavaci.setSelectedItem(e.getPredavac());
        }

        if (e.getDatumPocetka() != null) {
            dpDatumPocetka.setDate(e.getDatumPocetka().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        } else {
            dpDatumPocetka.setDate(null);
        }

       

        DefaultListModel<Polaznik> m = new DefaultListModel<>();
        if (e.getPolaznici() != null) {
            Collections.sort(e.getPolaznici(), new PolaznikComparator());
            // e.getPolaznici().forEach(p->{m.addElement(p);});
            m.addAll(e.getPolaznici());
        }
        lstPolazniciNaGrupi.setModel(m);

    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajActionPerformed
        try {
            if(obrada.getEntitet()==null){
                obrada.setEntitet(new Grupe());
            }
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

        if (JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati \"" + obrada.getEntitet().getNaziv() + "\"?",
                "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajPolaznike();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajPolaznike();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnDodajPolaznikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPolaznikeActionPerformed
      DefaultListModel<Polaznik> m;
      
      if(obrada.getEntitet()!=null){
          m= (DefaultListModel<Polaznik>)lstPolazniciNaGrupi.getModel();
      }else{
          obrada.setEntitet(new Grupe());
          obrada.getEntitet().setPolaznici(new ArrayList<>());
          preuzmiVrijednosti();
          m = new DefaultListModel<>();
          lstPolazniciNaGrupi.setModel(m);
      }
      
      for(Polaznik p : lstPolazniciUSkoli.getSelectedValuesList()){
          if(!postojiPolaznikUGrupi(m,p)){
          obrada.getEntitet().getPolaznici().add(p);
          m.addElement(p);
          }
      }
      lstPolazniciNaGrupi.repaint(); 
    }//GEN-LAST:event_btnDodajPolaznikeActionPerformed

    private void btnObrisiPolaznikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPolaznikeActionPerformed
        DefaultListModel<Polaznik> m = (DefaultListModel<Polaznik>)lstPolazniciNaGrupi.getModel();
        for(Polaznik p : lstPolazniciNaGrupi.getSelectedValuesList()){
            m.removeElement(p);
            for(Polaznik mp : obrada.getEntitet().getPolaznici()){
                if(mp.getSifra().equals(p.getSifra())){
                    obrada.getEntitet().getPolaznici().remove(mp);
                    break;
                }
            }
            lstPolazniciNaGrupi.repaint();
        }
    }//GEN-LAST:event_btnObrisiPolaznikeActionPerformed

    private void btnExportJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportJSONActionPerformed
         
        ExclusionStrategy strategija = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                if(fa.getDeclaringClass()==Smjer.class && fa.getName().equals("grupe")){
                    return true;
                }
                if(fa.getDeclaringClass()==Predavac.class && fa.getName().equals("grupe")){
                    return true;
                }
                if(fa.getDeclaringClass()==Polaznik.class && fa.getName().equals("grupe")){
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> type) {
               return false;
            }
        };
        
         Gson gson = new GsonBuilder()
                .setExclusionStrategies(strategija)
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();
         
         JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.setSelectedFile(new File(System.getProperty("user.home") + 
                File.separator + "grupe.json"));
        if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            try {
                BufferedWriter writer = new BufferedWriter(
                new FileWriter(jfc.getSelectedFile(),StandardCharsets.UTF_8));
                
                writer.write(gson.toJson(obrada.read()));
                writer.close();
                
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_btnExportJSONActionPerformed

    private void btnPosaljiEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosaljiEmailActionPerformed
          new GrupaSlanjeEmailProzor(obrada.getEntitet().getPolaznici()).setVisible(true);
    }//GEN-LAST:event_btnPosaljiEmailActionPerformed

     private boolean postojiPolaznikUGrupi(DefaultListModel<Polaznik> m, Polaznik p) {
        for(int i=0;i<m.size();i++){
            if(m.get(i).getSifra().equals(p.getSifra())){
                return true;
            }
        }
        return false;
    }
    
    private void preuzmiVrijednosti() {
        var e = obrada.getEntitet();
        e.setNaziv(txtNaziv.getText());
        e.setSmjer((Smjer) cmbSmjerovi.getSelectedItem());
        e.setPredavac((Predavac) cmbPredavaci.getSelectedItem());
        if(dpDatumPocetka.getDate()!=null){
             e.setDatumPocetka(
                Date.from(
                        dpDatumPocetka.getDate().atStartOfDay().atZone(
                                ZoneId.systemDefault()
                        ).toInstant()
                )
        );
        }else{
            e.setDatumPocetka(null);
        }
       
      

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPolaznike;
    private javax.swing.JButton btnExportJSON;
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiPolaznike;
    private javax.swing.JButton btnPosaljiEmail;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JCheckBox chbPocetakPrezimena;
    private javax.swing.JComboBox<Predavac> cmbPredavaci;
    private javax.swing.JComboBox<Smjer> cmbSmjerovi;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Grupe> lstEntiteti;
    private javax.swing.JList<Polaznik> lstPolazniciNaGrupi;
    private javax.swing.JList<Polaznik> lstPolazniciUSkoli;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

   
}
