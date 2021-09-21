package com.prueba1.prueba1.controllers;

import com.prueba1.prueba1.service.AutorSVC.AutorService;

import javax.validation.Valid;

import java.util.List;

import com.prueba1.prueba1.models.Autor;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public String autor(){
        return "Autor/index-autor";
    }

    @GetMapping("/crearAutor")
    public String crearLibro(Model model){
        Autor autor = new Autor();

        model.addAttribute("autor", autor);

        return "Autor/crear-autor";
    }

    @PostMapping("formCreaAutor")
    public String Post(@Valid Autor autor,
                        BindingResult result,
                        Model model,
                        SessionStatus status){
        if (result.hasErrors()) {
            return "Autor/crear-autor";
        }
        autorService.Crear(autor);
        return "redirect:/autores";
    }

    @GetMapping("/autor/editar/{id}")
    public String editarAutor(@SessionAttribute(name= "autor", required = false ) Autor autor,
                                @PathVariable String id,
                                Model model, 
                                SessionStatus status){
        autor = autorService.BuscarPorId(id);

        if(autor == null){
            return "redirect:/autores";
        }

        model.addAttribute("autor", autor);

        status.setComplete();

        return "Autor/editar-autor";
    }

    @PostMapping("/editAutor")
    public String editAutor(@Valid Autor autor, 
                            BindingResult result,
                            Model model,
                            SessionStatus status){
        if (result.hasErrors()) {
            return "Autor/editar-autor";
        }
        autorService.Editar(autor);
        return "redirect:/autores";
    }

    @GetMapping("/deleteAutor/{id}")
    public String deleteAutor(@PathVariable("id") String id, Model model){
        autorService.Eliminar(id);
        return "redirect:/autores";
    }

    @ModelAttribute("listaAutores")
    public List<Autor> listaAutores(){
        return autorService.Listar();
    }
    
}