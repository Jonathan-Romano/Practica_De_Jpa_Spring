package com.teoriaTodoCOde.pruebaJpa.controller;

import com.teoriaTodoCOde.pruebaJpa.model.Persona;
import com.teoriaTodoCOde.pruebaJpa.service.iPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    iPersonaService personaService;

    @GetMapping("/Personas/traer")
    public List<Persona> traerPersonas() {
        return personaService.getPersonas();
    }

    @PostMapping("/Personas/crear")
    public String crearPersona(@RequestBody Persona perso) {
        personaService.savePersona(perso);
        return "Persona Fue Creada";
    }

    @PostMapping("/Personas/encontrar/{id}")
    public Persona encontrarPersona(@PathVariable Long id) {
        return personaService.findPersona(id);
    }

    @DeleteMapping("/Personas/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "Persona Fue eliminada";
    }

    @PutMapping("Personas/editar/{idOriginal}")
    @ResponseBody
    public Persona editarPersona(@PathVariable Long idOriginal,
                               /* @RequestParam(required = false, name = "id") Long idNuevo,*/
                                @RequestParam(required = false, name = "nombre") String nombreNuevo,
                                @RequestParam(required = false, name = "apellido") String apellidoNuevo,
                                @RequestParam(required = false, name = "edad") int edad) {
        personaService.editPersona(idOriginal, nombreNuevo, apellidoNuevo, edad);
             
        return personaService.findPersona(idOriginal);
    }               

}
