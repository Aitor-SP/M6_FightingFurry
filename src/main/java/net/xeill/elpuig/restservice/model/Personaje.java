package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Entity
@Table( name = "personaje" )
public class Personaje implements Serializable {

    @Id
    @Column(name = "id_personaje")
    private int id_personaje;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "vida")
    private int vida;
    @Column(name = "mana")
    private int mana;
    @Column(name = "sprite")
    private String sprite;
    @Column(name = "categoria")
    private String categoria;

    public Personaje(int id_personaje, int vida, int mana, String nombre, String sprite, String categoria) {
        this.id_personaje = id_personaje;
        this.vida = vida;
        this.mana = mana;
        this.nombre = nombre;
        this.sprite = sprite;
        this.categoria = categoria;
    }

    public Personaje() {
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id_personaje=" + id_personaje +
                ", vida=" + vida +
                ", mana=" + mana +
                ", nombre='" + nombre + '\'' +
                ", sprite='" + sprite + '\'' +
                ", categoria='" + categoria + '\''+
                '}';
    }
}