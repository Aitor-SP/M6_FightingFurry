package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "defensa")
public class Defensa extends Carta implements Serializable {

    @Column(name = "valor_defensa")
    private int valor_defensa;

    public Defensa(int id_carta, String nombre, String descripcion, String imagen, Integer coste_mana, int valor_defensa) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_defensa = valor_defensa;
    }

    public int getValor_defensa() {
        return valor_defensa;
    }

    public void setValor_defensa(int valor_defensa) {
        this.valor_defensa = valor_defensa;
    }

    @Override
    public String toString() {
        return "Defensa{" +
                "valor_defensa=" + valor_defensa +
                '}';
    }
}
