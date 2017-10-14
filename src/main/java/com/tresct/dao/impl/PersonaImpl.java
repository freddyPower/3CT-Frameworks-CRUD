package com.tresct.dao.impl;

import com.tresct.dao.IPersona;
import com.tresct.dto.Persona;
import com.tresct.util.HibernateUtil;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author lsanchez
 */
public class PersonaImpl implements IPersona {

    public List<Persona> mostrarPersona() {
        Session sesion = null;
        List<Persona> lista = null;

        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();

            //Crear consulta HQL
            Query<Persona> query = sesion.createQuery("from Persona"); //Select * from Tramite
            lista = query.getResultList();
            sesion.getTransaction().commit();
            System.out.println(lista.toString());

        } catch (HibernateException hbe) {
            System.out.println("Excepcion en ConsultarHQL: " + hbe.getMessage());
            sesion.close();
        } finally {
            sesion.close();
        }

        return lista;
    }

    public void insertPersona(Persona p) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();            
            sesion.save(p);
            sesion.getTransaction().commit();
        } catch (HibernateException hbe) {
            System.out.println("Hibernate Exception: " + hbe.getMessage());
            sesion.getTransaction().rollback();
            sesion.close();
        } finally {
            sesion.close();
        }
    }

    public void modificarPersona(Persona p) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(p);
            sesion.getTransaction().commit();
        } catch (HibernateException hbe) {
            System.out.println("HibernateException: " + hbe.getMessage());
            sesion.getTransaction().rollback();
            sesion.close();
        } finally {
            sesion.close();
        }
    }

    public void eliminarPersona(Persona p) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(p);
            sesion.getTransaction().commit();
        } catch (HibernateException hbe) {
            System.out.println("HibernateExcepcion: " + hbe.getMessage());
            sesion.getTransaction().rollback();
            sesion.close();
        } finally {
            sesion.close();
        }
    }
    
     public Timestamp getTimestamp(java.util.Date date) {
         System.err.println("Entro a converter");
        return date == null ? null : new java.sql.Timestamp(date.getTime());
    }

}
