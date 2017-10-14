
package com.tresct.dao;

import com.tresct.dto.Persona;
import java.util.List;

/** 
 * @author lsanchez
 */
public interface IPersona {
    public List<Persona> mostrarPersona();
    public void insertPersona(Persona p);
    public void modificarPersona(Persona p);
    public void eliminarPersona(Persona p);
}
