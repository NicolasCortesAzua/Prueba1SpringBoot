package com.prueba1.prueba1.models;

import java.sql.Date;
import java.util.List;

public class Autor {
    public Integer id;
    public String nombre;
    public String nacionalidad;
    public Date fechaNacimiento;
    public String seudonimo;
    public List<Libro> libros;

    public Autor() {}

    public Autor(Integer id, String nombre, String nacionalidad, Date fechaNacimiento, String seudonimo,
            List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.seudonimo = seudonimo;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor [fechaNacimiento=" + fechaNacimiento + ", id=" + id + ", libros=" + libros + ", nacionalidad="
                + nacionalidad + ", nombre=" + nombre + ", seudonimo=" + seudonimo + "]";
    }
    
}