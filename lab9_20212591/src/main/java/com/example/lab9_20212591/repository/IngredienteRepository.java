package com.example.lab9_20212591.repository;

import com.example.lab9_20212591.entity.Ingrediente;
import com.example.lab9_20212591.entity.RecetaFav;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
