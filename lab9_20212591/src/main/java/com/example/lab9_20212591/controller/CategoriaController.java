package com.example.lab9_20212591.controller;

import com.example.lab9_20212591.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaDao categoriaDao;

    @GetMapping("/categorias/lista")
    public String listarCategorias(Model model){
        model.addAttribute("lista",categoriaDao.listarCategorias());
        return "listaCategorias";
    }
}
