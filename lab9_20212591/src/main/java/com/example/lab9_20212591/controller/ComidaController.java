package com.example.lab9_20212591.controller;

import com.example.lab9_20212591.dao.ComidaDao;
import com.example.lab9_20212591.entity.Comida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComidaController {
    @Autowired
    ComidaDao comidaDao;

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
}
