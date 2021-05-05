package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Carta;
import net.xeill.elpuig.restservice.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")
public class CartaController {

    @Autowired
    CartaRepository cartaRepository;

    @GetMapping("/cartas")
    public List<Carta> getAllCartas() {
        return cartaRepository.findAll();
    }

    @PostMapping("/cartas")
    public Carta createCarta(@Valid @RequestBody Carta carta) {
        return cartaRepository.save(carta);
    }

    @GetMapping("/cartas/{id}")
    public Carta getCartaById(@PathVariable(value = "id") Integer cartaId) {
        return cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta", "id", cartaId));
    }

    @PutMapping("/cartas/{id}")
    public Carta updateCarta(@PathVariable(value = "id") Integer cartaId,
                                     @Valid @RequestBody Carta cartaDetails) {

        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta", "id", cartaId));

        carta.setNombre(cartaDetails.getNombre());
        carta.setDescripcion(cartaDetails.getDescripcion());
        carta.setImagen(cartaDetails.getImagen());
        carta.setCoste_mana(cartaDetails.getCoste_mana());

        Carta updatedCarta = cartaRepository.save(carta);
        return updatedCarta;
    }

    @DeleteMapping("/cartas/{id}")
    public ResponseEntity<?> deleteCarta(@PathVariable(value = "id") Integer cartaId) {
        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta", "id", cartaId));

        cartaRepository.delete(carta);

        return ResponseEntity.ok().build();
    }
}
