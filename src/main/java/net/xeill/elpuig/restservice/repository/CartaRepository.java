package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
}
