/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.model.Osoba;
import edunova.util.EdunovaException;
import edunova.util.OibValidation;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author jbalog8
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T> {

    @Override
    protected void kontorolaCreate() throws EdunovaException {
        kontrolaOib();
        kontrolaEmail();
    }

    @Override
    protected void kontorlaUpdate() throws EdunovaException {
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {

    }

    private void kontrolaOib() throws EdunovaException {
        if (!OibValidation.checkOIB(entitet.getOib())) {
            throw new EdunovaException("OIB nije formalno ispravan");
        }
    }

    private void kontrolaEmail() throws EdunovaException {
        try {
            InternetAddress emailAddr = new InternetAddress(entitet.getEmail());
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new EdunovaException("Email nije formalno ispravan");
        }
    }

}
