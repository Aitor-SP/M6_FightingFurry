package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mazo")
    private Mazo mazo;

    public Personaje() {
    }

    public Personaje(int id_personaje, String nombre, int vida, int mana, String sprite, String categoria, Mazo mazo) {
        this.id_personaje = id_personaje;
        this.nombre = nombre;
        this.vida = vida;
        this.mana = mana;
        this.sprite = sprite;
        this.categoria = categoria;
        this.mazo = mazo;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id_personaje=" + id_personaje +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", mana=" + mana +
                ", sprite='" + sprite + '\'' +
                ", categoria='" + categoria + '\'' +
                ", mazo=" + mazo +
                '}';
    }
}