/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edunova;

import edunova.model.vjezbanje.veze.Mjesto;
import edunova.model.vjezbanje.veze.Opcina;
import edunova.util.HibernateUtil;
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
        
        //primjerRadaSVezama();
       //procitajOpcine();
    }
    
    private void procitajOpcine(){
        // čitati https://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
        // u dijelu upita Opcina tekst mora odgovarati imenu klase
        List<Opcina> opcine = session.createQuery("from Opcina").list();
        
        for(Opcina o:opcine){
            System.out.println(o.getNaziv());
            o.getMjesta().forEach(m->System.out.println(m.getNaziv()));
        }
    }
    
    private void primjerRadaSVezama(){
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
    new Start();
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
    
}
