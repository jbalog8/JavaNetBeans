/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.model.Polaznik;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author jbalog8
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik> {

    @Override
    public List<Polaznik> read() {
        return session.createQuery("from Polaznik").list();
        
    }
     public List<Polaznik> read(String uvjet) {
        return session.createQuery("from Polaznik p " 
                + "where concat(p.ime,' ', p.prezime)"
                + "like : uvjet order by p.prezime, p.ime")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(50)
                .list();
    }
    
    public List<Polaznik> readPocetakPrezime(String uvjet) {
        return session.createQuery("from Polaznik p " 
                + "where concat(p.prezime)"
                + "like : uvjet order by p.prezime, p.ime")
                .setParameter("uvjet", "%" + uvjet + "%")
                .setMaxResults(50)
                .list();
}

    @Override
    protected void kontorolaCreate() throws EdunovaException {
        super.kontorolaCreate();
        kontrolaBrojUgovora();
    }

    private void kontrolaBrojUgovora() throws EdunovaException {
        if (entitet.getBrojUgovora() == null || !entitet.getBrojUgovora().contains("/")) {
            throw new EdunovaException("Broj ugovora mora imati znak /");
        }

    }
   
}
