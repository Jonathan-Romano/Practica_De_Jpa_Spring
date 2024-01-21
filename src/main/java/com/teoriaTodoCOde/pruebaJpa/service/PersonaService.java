
package com.teoriaTodoCOde.pruebaJpa.service;

import com.teoriaTodoCOde.pruebaJpa.model.Persona;
import com.teoriaTodoCOde.pruebaJpa.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements iPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {        
        List<Persona> listaPersonas = persoRepo.findAll();       
    return listaPersonas;    
    }

    @Override
    public void savePersona(Persona perso) {
     persoRepo.save(perso);
    }
    
    @Override
    public void deletePersona(Long id) {
     persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
      Persona perso = persoRepo.findById(id).orElse(null);
    return perso;           
    }

    @Override
    public void editPersona(Long idOriginal, String nombreNuevo, String apellidoNuevo, int edadNueva) {
       Persona perso = this.findPersona(idOriginal);
     
       if(nombreNuevo!=null){
           perso.setNombre(nombreNuevo);
       }
       if(apellidoNuevo!=null){
           perso.setApellido(apellidoNuevo);
       }
       if(edadNueva!= 0){
           perso.setEdad(edadNueva);
       }
       /* perso.setNombre(nombreNuevo);
        perso.setApellido(apellidoNuevo);
        perso.setEdad(edadNueva);*/
       this.savePersona(perso);
    }
   
}
