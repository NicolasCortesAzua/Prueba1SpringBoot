package com.prueba1.prueba1.controllers;

import java.util.List;

import javax.validation.Valid;

import com.prueba1.prueba1.models.Categoria;
import com.prueba1.prueba1.service.CategoriaSVC.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String categorias(){
        return "Categoria/index-categoria";
    }

    @GetMapping("/crearCategoria")
    public String crearCategoria(Model model){
        Categoria categoria  = new Categoria();

        model.addAttribute("categoria", categoria);

        return "Categoria/crear-categoria";
    }

    @PostMapping("/formCreaCategoria")
    public String Post(@Valid Categoria categoria, 
                        BindingResult result,
                        Model model,
                        SessionStatus status){
        if (result.hasErrors()) {
            return "redirect:/crearCategoria";
        }
        categoriaService.Crear(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categoria/editar/{id}")
    public String editarCategoria(@SessionAttribute(name= "categoria", required = false ) Categoria categoria,
                                    @PathVariable Integer id,
                                    Model model, 
                                    SessionStatus status){
        categoria = categoriaService.BuscarPorId(id);

        if(categoria == null){
            return "redirect:/Categoria/index-categoria";
        }

        model.addAttribute("categoria",categoriaService.BuscarPorId(id));

        status.setComplete();

        return "Categoria/editar-categoria";
    }

    @PostMapping("/editCategoria")
    public String editCategoria(@Valid Categoria categoria, 
                                BindingResult result,
                                Model model,
                                SessionStatus status){
                                    
        categoriaService.Editar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/deleteCategoria/{id}")
    public String deleteCategoria(@PathVariable("id") Integer id, Model model) {
        categoriaService.Eliminar(id);
        
        return "redirect:/categorias";
    }
    

    @ModelAttribute("listaCategorias")
    public List<Categoria> listaCategorias(){
        return categoriaService.Listar();
    }

}