package com.example.lab9_20212591.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "recetafavorita")
public class RecetaFav {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idreceta", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "categoria", nullable = false, length = 45)
    private String categoria;

    @Column(name = "area", nullable = false, length = 45)
    private String area;

    @Column(name = "tags", nullable = false, length = 100)
    private String tags;

    @Column(name = "foto", nullable = false)
    private String foto;

    @Lob
    @Column(name = "instrucciones", columnDefinition = "TEXT")
    private String instrucciones;

    @OneToMany(mappedBy = "receta")
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "receta")
    private List<Medida> medidas;
}
