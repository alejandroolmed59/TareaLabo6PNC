package com.olmedo.laboratorio5.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
    @Id
    @Column(name = "c_importancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_importancia;

    @Column(name = "s_importancia")
    private String s_importancia;

    @OneToMany(mappedBy = "importancia", fetch = FetchType.EAGER)
    private List<Contribuyente> contribuyentes;

    public Importancia() {
    }

    public Integer getC_importancia() {
        return c_importancia;
    }

    public void setC_importancia(Integer c_importancia) {
        this.c_importancia = c_importancia;
    }

    public String getS_importancia() {
        return s_importancia;
    }

    public void setS_importancia(String s_importancia) {
        this.s_importancia = s_importancia;
    }
}