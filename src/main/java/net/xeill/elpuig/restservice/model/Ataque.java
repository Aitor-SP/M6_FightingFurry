package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ataque")
public class Ataque extends Carta implements Serializable {

    @Column(name = "valor_ataque")
    private int valor_ataque;

    public Ataque(int id_carta, String nombre, String descripcion, String imagen, Integer coste_mana, int valor_ataque) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_ataque = valor_ataque;
    }

    public int getValor_ataque() {
        return valor_ataque;
    }

    public void setValor_ataque(int valor_ataque) {
        this.valor_ataque = valor_ataque;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "valor_ataque=" + valor_ataque +
                '}';
    }
}
