package com.tresct.controller;

import com.tresct.dao.IPersona;
import com.tresct.dao.impl.PersonaImpl;
import com.tresct.dto.Persona;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 * @author lsanchez
 */
@Named(value = "personaBean")
@ViewScoped
public class PersonaBean implements Serializable {

    private Persona persona;
    private List<Persona> listaPersonas;

    public PersonaBean() {
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersonas() {
        IPersona linkDao = new PersonaImpl();
        listaPersonas = linkDao.mostrarPersona();
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public void insertar() {
        IPersona linkDao = new PersonaImpl();        
        linkDao.insertPersona(persona);
        persona = new Persona();
    }

    public void modificar() {
        IPersona linkDao = new PersonaImpl();
        linkDao.modificarPersona(persona);
        persona = new Persona();
    }

    public void eliminar() {
        IPersona linkDao = new PersonaImpl();
        linkDao.eliminarPersona(persona);
        persona = new Persona();
    }

   

}
