package com.example.lab9_20212591.dao;

import com.example.lab9_20212591.dto.CategoriaDto;
import com.example.lab9_20212591.entity.Categoria;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CategoriaDao {

    public List<Categoria> listarCategorias(){
        List<CategoriaDto> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/categories.php";

        ResponseEntity<CategoriaDto> responseEntity = restTemplate.getForEntity(endPoint, CategoriaDto.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            CategoriaDto categoriaDto = responseEntity.getBody();
            return categoriaDto != null ? categoriaDto.getCategories() : new ArrayList<>();
        }

        return new ArrayList<>();

    }
}
