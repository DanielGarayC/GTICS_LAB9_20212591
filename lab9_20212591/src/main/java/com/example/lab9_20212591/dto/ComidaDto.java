package com.example.lab9_20212591.dto;

import com.example.lab9_20212591.entity.Comida;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComidaDto {
    private List<Comida> meals;

}
