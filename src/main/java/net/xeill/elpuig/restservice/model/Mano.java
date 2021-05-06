package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mano")
public class Mano implements Serializable {

    @Id
    @Column(name = "mano")
    private int id_mano;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje")
    private Personaje personaje;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carta")
    private Carta carta;

    public Mano() {
    }

    public Mano(int id_mano, Personaje personaje, Carta carta) {
        this.id_mano = id_mano;
        this.personaje = personaje;
        this.carta = carta;
    }

    public int getId_mano() {
        return id_mano;
    }

    public void setId_mano(int id_mano) {
        this.id_mano = id_mano;
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
        return "Mano{" +
                "id_mano=" + id_mano +
                ", personaje=" + personaje +
                ", carta=" + carta +
                '}';
    }
}
