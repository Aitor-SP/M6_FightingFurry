package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Mazo;
import net.xeill.elpuig.restservice.repository.MazoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")
public class MazoController {

    @Autowired
    MazoRepository mazoRepository;

    @GetMapping("/mazos")
    public List<Mazo> getAllMazos() {
        return mazoRepository.findAll();
    }

    @PostMapping("/mazos")
    public Mazo createMazo(@Valid @RequestBody Mazo mazo) {
        return mazoRepository.save(mazo);
    }

    @GetMapping("/mazos/{id}")
    public Mazo getMazoById(@PathVariable(value = "id") Integer mazoId) {
        return mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mazo", "id", mazoId));
    }

    @PutMapping("/mazos/{id}")
    public Mazo updateMazo(@PathVariable(value = "id") Integer mazoId,
                                     @Valid @RequestBody Mazo mazoDetails) {

        Mazo mazo = mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", mazoId));

        mazo.setId_mazo(mazoDetails.getId_mazo());
        mazo.setPersonaje(mazoDetails.getPersonaje());
        mazo.setCarta(mazoDetails.getCarta());

        Mazo updatedMazo = mazoRepository.save(mazo);
        return updatedMazo;
    }

    @DeleteMapping("/mazos/{id}")
    public ResponseEntity<?> deleteMazo(@PathVariable(value = "id") Integer mazoId) {
        Mazo mazo = mazoRepository.findById(mazoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mazo", "id", mazoId));

        mazoRepository.delete(mazo);

        return ResponseEntity.ok().build();
    }
}
