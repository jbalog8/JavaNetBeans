/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.kontroler;

import edunova.util.EdunovaException;
import edunova.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author jbalog8
 */
public abstract class Obrada<T> {

    protected Session session;
    protected T entitet;

    public abstract List<T> read();

    protected abstract void kontorolaCreate() throws EdunovaException;

    protected abstract void kontorlaUpdate() throws EdunovaException;

    protected abstract void kontrolaDelete() throws EdunovaException;

    public Obrada() {
        session = HibernateUtil.getSession();

    }

    public T create() throws EdunovaException {
        kontorolaCreate();
        save();
        return entitet;
    }

    public T update() throws EdunovaException {
        kontorlaUpdate();
        save();
        return entitet;
    }

    public void delete() throws EdunovaException {
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }

    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();

    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

}
