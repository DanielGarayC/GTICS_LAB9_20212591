package com.example.lab9_20212591.dao;

import com.example.lab9_20212591.dto.ComidaDto;
import com.example.lab9_20212591.entity.Comida;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComidaDao {
    public List<Comida> buscarComidaPorNombre(String nombreComida) {
        List<Comida> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nombreComida;

        ResponseEntity<ComidaDto> responseEntity = restTemplate.getForEntity(endPoint, ComidaDto.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ComidaDto comidaDto = responseEntity.getBody();
            if (comidaDto != null) {
                lista = comidaDto.getMeals();
            }
        }
        return lista;
    }

    public Comida verDetalleReceta(String idMeal) {

        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + idMeal;

        ResponseEntity<ComidaDto> responseEntity = restTemplate.getForEntity(endPoint, ComidaDto.class);
        if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
            ComidaDto receta = responseEntity.getBody();
            if(receta != null && receta.getMeals() != null && !receta.getMeals().isEmpty()) {
                Comida comida = receta.getMeals().get(0);
                System.out.println("Comida: " + comida);
                llenarListas(comida);
                return comida;
            }
        }
        return null;
    }
    public void llenarListas(Comida comida) {

        List<String> ingredientes = new ArrayList<>();
        List<String> medidas = new ArrayList<>();

        for (int i = 1; i <= 20; i++) { // Solo hay hasta 20 pa cada uno
            String ingrediente = comida.getStrIngredient(i);
            String medida = comida.getStrMeasure(i);

            if (ingrediente == null && medida == null) {
                break;
            }

            if (ingrediente != null && !ingrediente.trim().isEmpty()) {
                ingredientes.add(ingrediente);
            }
            if (medida != null && !medida.trim().isEmpty()) {
                medidas.add(medida);
            }
        }

        comida.setStrIngredients(ingredientes);
        comida.setStrMeasures(medidas);

    }


}
