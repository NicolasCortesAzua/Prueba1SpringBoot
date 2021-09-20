package com.prueba1.prueba1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/", "", "/index"})
    public String index(Model model){
        model.addAttribute("mensaje", "Mensaje desde Model en IndexController");
        return "index";
    }
}