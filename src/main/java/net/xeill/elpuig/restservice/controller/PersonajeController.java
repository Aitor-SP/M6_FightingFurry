package net.xeill.elpuig.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import net.xeill.elpuig.restservice.model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;

import net.xeill.elpuig.restservice.repository.PersonajeRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")
public class PersonajeController {

    @Autowired
    PersonajeRepository personajeRepository;

    @GetMapping("/personajes")
    public List<Personaje> getAllUsers() {
        return personajeRepository.findAll();
    }

    @PostMapping("/personajes")
    public Personaje createPersonaje(@Valid @RequestBody Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @GetMapping("/personajes/{id}")
    public Personaje getPersonajeById(@PathVariable(value = "id") Integer personajeId) {
        return personajeRepository.findById(personajeId)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));
    }

    @PutMapping("/personajes/{id}")
    public Personaje updatePersonaje(@PathVariable(value = "id") Integer personajeId,
                                @Valid @RequestBody Personaje personajeDetails) {

    	Personaje personaje = personajeRepository.findById(personajeId)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));

        personaje.setNombre(personajeDetails.getNombre());
        personaje.setVida(personajeDetails.getVida());
        personaje.setMana(personajeDetails.getMana());
        personaje.setSprite(personajeDetails.getSprite());
        personaje.setCategoria(personajeDetails.getCategoria());

        Personaje updatedPersonaje = personajeRepository.save(personaje);
        return updatedPersonaje;
    }

    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<?> deletePersonaje(@PathVariable(value = "id") Integer personajeId) {
        Personaje personaje = personajeRepository.findById(personajeId)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", personajeId));

        personajeRepository.delete(personaje);

        return ResponseEntity.ok().build();
    }
}
