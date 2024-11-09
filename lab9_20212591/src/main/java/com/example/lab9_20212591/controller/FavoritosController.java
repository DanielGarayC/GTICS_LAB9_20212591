package com.example.lab9_20212591.controller;

import com.example.lab9_20212591.entity.RecetaFav;
import com.example.lab9_20212591.repository.RecetaFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FavoritosController {
    @Autowired
    RecetaFavRepository recetaFavRepository;

    @GetMapping("/listarFavoritos")
    public String listarFavoritos(Model model) {
        List<RecetaFav> favoritos = recetaFavRepository.findAll();

        model.addAttribute("lista", favoritos);

        return "listaFavoritos";
    }
}
