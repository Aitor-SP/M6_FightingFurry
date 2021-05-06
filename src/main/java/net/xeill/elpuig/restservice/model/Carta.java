package net.xeill.elpuig.restservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "carta")
public class Carta implements Serializable {

    @Id
    @Column(name = "id_carta")
    private int id_carta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "coste_mana")
    private int coste_mana;


    public Carta(int id_carta, String nombre, String descripcion, String imagen, Integer coste_mana) {
        this.id_carta = id_carta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.coste_mana = coste_mana;
    }

    public int getId_carta() {
        return id_carta;
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCoste_mana() {
        return coste_mana;
    }

    public void setCoste_mana(Integer coste_mana) {
        this.coste_mana = coste_mana;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id_carta=" + id_carta +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", coste_mana=" + coste_mana +
                '}';
    }
}
