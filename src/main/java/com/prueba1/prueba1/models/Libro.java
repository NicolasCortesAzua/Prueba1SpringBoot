package com.prueba1.prueba1.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Libro {
    @NotNull
    public Integer id;

    @NotNull
    @NotBlank
    @Size(min=5, max=255)
    public String titulo;

    @NotNull
    public Autor autor;

    @NotNull
    public Categoria categoria;

    @NotNull
    @Size(min=3, max=255)
    public String descripcion;

    @NotNull
    public String annio;

    @NotNull
    @Pattern(regexp = "[0-9]{4}[-][0-9]{2}[-][0-9]{5}[-][0-9]{2}[-][0-9]{1}")
    public String isbn; // Codigo de los libros

    @NotNull
    @Range(min=1)
    public Integer cantPaginas;

    public Libro() {}

    public Libro(Integer id, String titulo, Autor autor, Categoria categoria, String descripcion, String annio, String isbn,
            Integer cantPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.annio = annio;
        this.isbn = isbn;
        this.cantPaginas = cantPaginas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(Integer cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public String toString() {
        return "Libro [annio=" + annio + ", autor=" + autor + ", cantPaginas=" + cantPaginas + ", descripcion="
                + descripcion + ", id=" + id + ", isbn=" + isbn + ", tema=" + categoria + ", titulo=" + titulo + "]";
    }

    
}