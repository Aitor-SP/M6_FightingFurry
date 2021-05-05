package net.xeill.elpuig.restservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "especial")
public class Especial extends Carta implements Serializable {

    @Column(name = "valor_especial")
    private int valor_especial;

    public Especial(int id_carta, String nombre, String descripcion, String imagen, Integer coste_mana, int valor_especial) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_especial = valor_especial;
    }

    public int getValor_especial() {
        return valor_especial;
    }

    public void setValor_especial(int valor_especial) {
        this.valor_especial = valor_especial;
    }

    @Override
    public String toString() {
        return "Especial{" +
                "valor_especial=" + valor_especial +
                '}';
    }
}
