/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.model.Grupe;
import edunova.model.Smjer;
import edunova.util.EdunovaException;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jbalog8
 */
public class ObradaSmjer extends Obrada<Smjer>{

    @Override
    public List<Smjer> read() {
        return session.createQuery("from Smjer a order by a.naziv").list();
     }

    @Override
    protected void kontorolaCreate() throws EdunovaException {
        kontrolaNaziv();
        kontrolaTrajanje();
        kontrolaCijena();
    }

    @Override
    protected void kontorlaUpdate() throws EdunovaException {
         kontrolaNaziv();
        kontrolaTrajanje();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
       
          if(entitet.getGrupe()!=null && entitet.getGrupe().size()>0){
            
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for(Grupe g:entitet.getGrupe()){
                sb.append(g.getNaziv());
                sb.append("\n");
            }
            
            throw new EdunovaException("Ne možete brisati smjer jer na njemu ima grupa" + sb.toString());
        }
    }
    
    


    private void kontrolaNaziv() throws EdunovaException{
       
        if(entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()){
            throw new EdunovaException("Naziv smjera obavezan");
        }
        if(entitet.getNaziv().trim().length() > 50){
            throw  new EdunovaException("Naziv smjera ne moze biti duzi od 50 znakova");
        }
    }

    private void kontrolaTrajanje() throws EdunovaException{
        
        if(entitet.getTrajanje() == null || entitet.getTrajanje() < 0){
            throw new EdunovaException ("Trajanje mora biti postavljeno i ne smije biti manje od 0");
        }
    }

    private void kontrolaCijena() throws EdunovaException{
       if( entitet.getCijena()==null || 
                entitet.getCijena().compareTo(BigDecimal.ZERO.ZERO)<0 ||
                entitet.getCijena().compareTo(new BigDecimal(10000))>0){
            throw new EdunovaException("Cijena mora biti postavljena, veća od 0 i manja od 10000");
        }
    }
}
