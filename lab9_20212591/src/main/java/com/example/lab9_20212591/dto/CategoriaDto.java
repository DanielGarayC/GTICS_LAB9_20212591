package com.example.lab9_20212591.dto;

import com.example.lab9_20212591.entity.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriaDto {
    private List<Categoria> categories;
}
