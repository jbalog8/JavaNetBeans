/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.model.Predavac;
import edunova.util.EdunovaException;
import java.util.List;
import nl.garvelink.iban.IBAN;

/**
 *
 * @author jbalog8
 */
public class ObradaPredavac extends ObradaOsoba<Predavac> {

    @Override
    public List<Predavac> read() {
        return session.createQuery("from Predavac").list();
    }

    @Override
    protected void kontorolaCreate() throws EdunovaException {
        super.kontorolaCreate();
        kontrolaIBAN();
    }

    private void kontrolaIBAN() throws EdunovaException {
        if (entitet.getIban() == null) {
            throw new EdunovaException("Obavezno IBAN");
        }

        try {
            IBAN iban = IBAN.valueOf(entitet.getIban());
            if (!iban.isSEPA()) {
                throw new EdunovaException("IBAN nije ispravan");
            }
        } catch (Exception e) {
            throw new EdunovaException("IBAN nije ispravan");
        }

    }

}
