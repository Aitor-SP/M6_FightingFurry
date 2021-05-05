package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Carta;
import net.xeill.elpuig.restservice.model.Mano;
import net.xeill.elpuig.restservice.repository.ManoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")
public class ManoControler {

    @Autowired
    ManoRepository manoRepository;

    @GetMapping("/manos")
    public List<Mano> getAllManos() {
        return manoRepository.findAll();
    }

    @PostMapping("/manos")
    public Mano createMarta(@Valid @RequestBody Mano mano) {
        return manoRepository.save(mano);
    }

    @GetMapping("/manos/{id}")
    public Mano getManoById(@PathVariable(value = "id") Integer manoId) {
        return manoRepository.findById(manoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mano", "id", manoId));
    }

    @PutMapping("/manos/{id}")
    public Mano updateMano(@PathVariable(value = "id") Integer manoId,
                             @Valid @RequestBody Mano manoDetails) {

        Mano mano = manoRepository.findById(manoId)
                .orElseThrow(() -> new ResourceNotFoundException("Carta", "id", manoId));

        mano.setNombre(manoDetails.getNombre());
        mano.setDescripcion(manoDetails.getDescripcion());
        mano.setImagen(manoDetails.getImagen());
        mano.setCoste_mana(manoDetails.getCoste_mana());

        Mano updatedMano = manoRepository.save(mano);
        return updatedMano;
    }

    @DeleteMapping("/manos/{id}")
    public ResponseEntity<?> deleteMano(@PathVariable(value = "id") Integer manoId) {
        Mano mano = manoRepository.findById(manoId)
                .orElseThrow(() -> new ResourceNotFoundException("Mano", "id", manoId));

        manoRepository.delete(mano);

        return ResponseEntity.ok().build();
    }
}
