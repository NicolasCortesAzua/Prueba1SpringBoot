package com.prueba1.prueba1.service.LibroSVC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.prueba1.prueba1.models.Autor;
import com.prueba1.prueba1.models.Categoria;
import com.prueba1.prueba1.models.Libro;

import org.springframework.stereotype.Service;

@Service
public class LibroServiceIpml implements LibroService {

    List<Libro> listaLibros;
    
    public LibroServiceIpml() {
        this.listaLibros = new ArrayList<Libro>(
            Arrays.asList(
                new Libro(1, "Manual de cocina", new Autor("FEL2008", "Felipe", "Azua", "chileno", null, "pipe", null), new Categoria(1, "Aventura", null), "Libro para aprender a cocinar", "2021", "999-99-99999-99-9", 100),
                new Libro(2, "Los vencejos", new Autor("MIC1999", "Mickel", "muñoz", "chileno", null, "pipe", null), new Categoria(1, "Aventura", null),  "Novela sobre un profesor", "2020", "888-88-88888-88-8", 90),
                new Libro(3, "A fuego lento", new Autor("MAN1998", "Manuel", "Lara", "chileno", null, "pipe", null), new Categoria(1, "Aventura", null),  "Novela de un accidente", "2019", "777-77-77777-77-7", 190)
            )
        );
    }

    @Override
    public void Crear(Libro creaLibro) {
        if(creaLibro != null){
            //List<Categoria> categorias = _categoriaService.Listar().get(index);
            listaLibros.add(creaLibro);        
        }
        
    }

    @Override
    public void Editar(Libro editaLibro) {
        if(editaLibro.getId() != null || editaLibro.getId() > 0){
            for (Libro libro : listaLibros) {
                if(libro.getId() == editaLibro.getId()){
                    editaLibro.setTitulo(libro.getTitulo());
                    editaLibro.setAutor(libro.getAutor());
                    editaLibro.setCategoria(libro.getCategoria());
                    editaLibro.setDescripcion(libro.getDescripcion());
                    editaLibro.setAnnio(libro.getAnnio());
                    editaLibro.setIsbn(libro.getIsbn());
                    editaLibro.setCantPaginas(libro.getCantPaginas());
                }
            }
        }        
    }

    @Override
    public void Eliminar(Integer Id) {
        if(Id != null){
            listaLibros.remove(Id-1);
        }
    }

    @Override
    public Libro BuscarPorId(Integer Id) {
        Libro encuentraLibro = new Libro();

        for (Libro libro : listaLibros) {
            if(libro.getId() == Id){
                encuentraLibro = libro;
            }
        }

        return encuentraLibro;
    }

    @Override
    public List<Libro> Listar() {
        return listaLibros;
    }
    
}