package net.xeill.elpuig.restservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "curacion")
public class Curacion extends Carta implements Serializable {

    @Column(name = "valor_curacion")
    private int valor_curacion;

    public Curacion(int id_carta, String nombre, String descripcion, String imagen, Integer coste_mana, int valor_curacion) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_curacion = valor_curacion;
    }

    public int getValor_curacion() {
        return valor_curacion;
    }

    public void setValor_curacion(int valor_curacion) {
        this.valor_curacion = valor_curacion;
    }

    @Override
    public String toString() {
        return "Curacion{" +
                "valor_curacion=" + valor_curacion +
                '}';
    }
}
