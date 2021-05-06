package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mazo")
public class Mazo implements Serializable {

    @Id
    @Column(name = "mazo")
    private int id_mazo;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje")
    private Personaje personaje;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carta")
    private Carta carta;

    public Mazo() {
    }

    public Mazo(int id_mazo, Personaje personaje, Carta carta) {
        this.id_mazo = id_mazo;
        this.personaje = personaje;
        this.carta = carta;
    }

    public int getId_mazo() {
        return id_mazo;
    }

    public void setId_mazo(int id_mazo) {
        this.id_mazo = id_mazo;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "id_mazo=" + id_mazo +
                ", personaje=" + personaje +
                ", carta=" + carta +
                '}';
    }
}
