
package com.teoriaTodoCOde.pruebaJpa.service;

import com.teoriaTodoCOde.pruebaJpa.model.Persona;
import java.util.List;


public interface iPersonaService {
    
    public List<Persona> getPersonas();
    public void savePersona(Persona perso);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
    public void editPersona(Long idOriginal, String nombreNuevo, String apellidoNuevo, int edadNueva);
    
}
