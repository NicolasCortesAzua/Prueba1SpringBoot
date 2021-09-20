package com.prueba1.prueba1.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Categoria {
    @NotNull
    @Range(min=1, max=2)
    public Integer id;

    @NotNull
    @Size(min=3, max=255)
    public String descripcion;
    public List<Libro> libros;

    public Categoria() {}

    public Categoria(Integer id, String descripcion, List<Libro> libros) {
        this.id = id;
        this.descripcion = descripcion;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Categoria [descripcion=" + descripcion + ", id=" + id + ", libros=" + libros + "]";
    }
    
}
