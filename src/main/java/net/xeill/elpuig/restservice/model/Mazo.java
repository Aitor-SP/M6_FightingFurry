package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "mazo")
public class Mazo implements Serializable {

    @Id
    @Column(name = "mazo")
    private int id_mazo;
    //FK DE ID PERSONAJE
    //FK DE ID CARTA
}
