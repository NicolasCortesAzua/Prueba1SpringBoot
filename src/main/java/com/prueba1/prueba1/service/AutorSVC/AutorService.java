package com.prueba1.prueba1.service.AutorSVC;

import com.prueba1.prueba1.models.Autor;

import java.util.List;

public interface AutorService {
    public void Crear(Autor creaAutor);
    public void Editar(Autor editaAutor);
    public void Eliminar(String Id);
    public Autor BuscarPorId(String Id);
    public List<Autor> Listar();
}