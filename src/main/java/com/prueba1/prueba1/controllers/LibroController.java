package com.prueba1.prueba1.controllers;

import java.util.List;

import javax.validation.Valid;

import com.prueba1.prueba1.models.Autor;
import com.prueba1.prueba1.models.Categoria;
import com.prueba1.prueba1.models.Libro;
import com.prueba1.prueba1.service.AutorSVC.AutorService;
import com.prueba1.prueba1.service.CategoriaSVC.CategoriaService;
import com.prueba1.prueba1.service.LibroSVC.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/libros")
    public String libros(){
        return "Libro/index-libro";
    }

    @GetMapping("/crearLibro")
    public String crearLibro(Model model){
        Libro libro  = new Libro();

        model.addAttribute("libro", libro);

        return "Libro/crear-libro";
    }

    @PostMapping("/formCreaLibro")
    public String Post(@Valid Libro libro, 
                        BindingResult result,
                        Model model,
                        SessionStatus status){
        libroService.Crear(libro);
        return "redirect:/libros";
    }

    @GetMapping("/libro/editar/{id}")
    public String editarlibro(@SessionAttribute(name= "libro", required = false ) Libro libro,
                                @PathVariable Integer id,
                                Model model, 
                                SessionStatus status){
        libro = libroService.BuscarPorId(id);

        if(libro == null){
            return "redirect:/Libro/index-libro";
        }

        model.addAttribute("libro", libro);

        status.setComplete();

        return "Libro/editar-libro";
    }

    @PostMapping("/editLibro")
    public String editLibro(@Valid Libro libro, 
                            BindingResult result,
                            Model model,
                            SessionStatus status){
                                    
        libroService.Editar(libro);
        return "redirect:/libros";
    }

    @GetMapping("/deleteLibro/{id}")
    public String deletelibro(@PathVariable("id") Integer id, Model model) {
        libroService.Eliminar(id);
        
        return "redirect:/libros";
    }
    

    @ModelAttribute("listaLibros")
    public List<Libro> listaLibros(){
        return libroService.Listar();
    }

    @ModelAttribute("listaCategorias")
    public List<Categoria> listaCategorias(){
        return categoriaService.Listar();
    }

    @ModelAttribute("listaAutor")
    public List<Autor> listaAutores(){
        return autorService.Listar();
    }

}