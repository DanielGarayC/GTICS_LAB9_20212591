package com.example.lab9_20212591.controller;

import com.example.lab9_20212591.dao.ComidaDao;
import com.example.lab9_20212591.entity.Comida;
import com.example.lab9_20212591.entity.Ingrediente;
import com.example.lab9_20212591.entity.Medida;
import com.example.lab9_20212591.entity.RecetaFav;
import com.example.lab9_20212591.repository.IngredienteRepository;
import com.example.lab9_20212591.repository.MedidaRepository;
import com.example.lab9_20212591.repository.RecetaFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ComidaController {
    @Autowired
    ComidaDao comidaDao;

    @Autowired
    private RecetaFavRepository recetaFavRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private MedidaRepository medidaRepository;

    @GetMapping("/Meal/buscar")
    public String buscarComida(@RequestParam("nombre") String nombre, Model model){
        List<Comida> meals = comidaDao.buscarComidaPorNombre(nombre);
        model.addAttribute("meals", meals);
        return "listaComidas";
    }

    @GetMapping("/Meal/detalle")
    public String detallesReceta(@RequestParam("idMeal") String idMeal,Model model){
        Comida receta = comidaDao.verDetalleReceta(idMeal);
        model.addAttribute("receta", receta);
        return "detalleReceta";
    }

    @PostMapping("/Meal/guardarRecetaFavorita")
    @ResponseBody
    public String addFavorite(@RequestParam("idMeal") String idMeal, Model model) {
        RecetaFav receta = new RecetaFav();
        Comida recetaGuardar = comidaDao.verDetalleReceta(idMeal);

        receta.setNombre(recetaGuardar.getStrMeal());
        receta.setCategoria(recetaGuardar.getStrCategory());
        receta.setArea(recetaGuardar.getStrArea());
        receta.setTags(recetaGuardar.getStrTags());
        receta.setFoto(recetaGuardar.getStrMealThumb());
        receta.setInstrucciones(recetaGuardar.getStrInstructions());

        recetaFavRepository.save(receta);

        List<Ingrediente> ingredientess = new ArrayList<>();
        for (String ingredient : recetaGuardar.getStrIngredients()) {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre(ingredient);
            ingrediente.setReceta(receta);
            ingredientess.add(ingrediente);
            ingredienteRepository.save(ingrediente);
        }
        int idx = 0;
        for (String mishurrr : recetaGuardar.getStrMeasures()) {
            Medida medida = new Medida();
            medida.setMishur(mishurrr);
            medida.setReceta(receta);
            Ingrediente ingredienteM = ingredientess.get(idx);
            medida.setIngrediente(ingredienteM);
            medidaRepository.save(medida);
            idx++;
        }
        return "success";
    }
}
