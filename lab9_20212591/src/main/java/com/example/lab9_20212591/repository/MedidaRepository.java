package com.example.lab9_20212591.repository;

import com.example.lab9_20212591.entity.Medida;
import com.example.lab9_20212591.entity.RecetaFav;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedidaRepository extends JpaRepository<Medida, Integer> {
}
