package com.example.lab9_20212591.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medida")
public class Medida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmedida")
    private int id;

    @Column(name = "mishur", nullable = false, length = 100)
    private String mishur;

    @ManyToOne
    @JoinColumn(name = "idreceta", nullable = false)
    private RecetaFav receta;

    @ManyToOne
    @JoinColumn(name = "idingrediente", nullable = false)
    private Ingrediente ingrediente;
}

