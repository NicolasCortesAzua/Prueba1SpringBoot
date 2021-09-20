package com.prueba1.prueba1.service.LibroSVC;

import java.util.List;

import com.prueba1.prueba1.models.Libro;

public interface LibroService {
    public void Crear(Libro creaLibro);
    public void Editar(Libro editaLibro);
    public void Eliminar(Integer Id);
    public Libro BuscarPorId(Integer Id);
    public List<Libro> Listar();
}