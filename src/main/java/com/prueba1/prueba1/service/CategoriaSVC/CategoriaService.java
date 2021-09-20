package com.prueba1.prueba1.service.CategoriaSVC;

import java.util.List;

import com.prueba1.prueba1.models.Categoria;

public interface CategoriaService {
    public void Crear(Categoria creaCategoria);
    public void Editar(Categoria editaCategoria);
    public void Eliminar(Integer Id);
    public Categoria BuscarPorId(Integer Id);
    public List<Categoria> Listar();
    
}