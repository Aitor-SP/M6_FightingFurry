package net.xeill.elpuig.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.xeill.elpuig.restservice.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
}
