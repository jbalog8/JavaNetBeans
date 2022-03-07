/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova;

import edunova.kontroler.ObradaPredavac;
import edunova.model.Predavac;
import edunova.model.vjezbanje.veze.Mjesto;
import edunova.model.vjezbanje.veze.Opcina;
import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import edunova.view.SplashScreen;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jbalog8
 */
public class Start {

    private Session session;

    public Start() {
        this.session = HibernateUtil.getSession();
        //PocetniInsert.izvedi();
        //testiranjeUnosaPredavaca();

        //primjerRadaSVezama();
        //procitajOpcine();
    }

    private void procitajOpcine() {
        // čitati https://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
        // u dijelu upita Opcina tekst mora odgovarati imenu klase
        List<Opcina> opcine = session.createQuery("from Opcina").list();

        for (Opcina o : opcine) {
            System.out.println(o.getNaziv());
            o.getMjesta().forEach(m -> System.out.println(m.getNaziv()));
        }
    }

    private void primjerRadaSVezama() {
        session.beginTransaction();
        Opcina opcina = new Opcina();
        opcina.setNaziv("Bilje");
        session.save(opcina);
        Mjesto mjesto = new Mjesto();
        mjesto.setNaziv("Kopačevo");
        mjesto.setOpcina(opcina);
        session.save(mjesto);

        mjesto = new Mjesto();
        mjesto.setNaziv("Bilje");
        mjesto.setOpcina(opcina);
        session.save(mjesto);
        session.getTransaction().commit();;
    }

    public static void main(String[] args) {
        // new Start();
        new SplashScreen().setVisible(true);
        // PocetniInsert.unosOperatera();

        /*
        Session s = HibernateUtil.getSession();
       
        Mobitel m = new Mobitel();
        m.setCijena(new BigDecimal(5999.99));
        m.setDatumKupnje(new Date());
        m.setNaziv("iPhone");
        m.setIspravan(true);
        m.setOpis("Mobitel je dobar");
        m.setNapomena("Sve je OK");
        
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
         */
    }

    private void testiranjeUnosaPredavaca() {
        Predavac predavac = new Predavac();
        predavac.setOib("34727507038");
        predavac.setIme("Ana");
        predavac.setPrezime("Osječka");
        predavac.setIban("HR0823400098942437554");
        predavac.setEmail("ana@osječka");
        ObradaPredavac op = new ObradaPredavac();
        op.setEntitet(predavac);
        try {
            op.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
    }

}
