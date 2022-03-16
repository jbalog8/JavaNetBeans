/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.model.Grupe;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author jbalog8
 */
public class ObradaGrupe extends Obrada<Grupe> {

    @Override
    public List<Grupe> read() {
        return session.createQuery("from Grupe").list();
    }

    @Override
    protected void kontorolaCreate() throws EdunovaException {
        kontrolaSmjer();
    }

    @Override
    protected void kontorlaUpdate() throws EdunovaException {

    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {

    }

    private void kontrolaSmjer() throws EdunovaException{
       
        if(entitet.getSmjer()== null || entitet.getSmjer().getSifra().equals(Long.valueOf(0))){
            throw new EdunovaException("Obavezan odabir smjera");
        }
    }

}
