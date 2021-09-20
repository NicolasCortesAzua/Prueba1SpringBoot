package com.prueba1.prueba1.service.CategoriaSVC;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import com.prueba1.prueba1.models.Categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private List<Categoria> listaCategorias;

    public CategoriaServiceImpl() {

        this.listaCategorias = new ArrayList<Categoria>( 
            Arrays.asList(
                new Categoria(1, "Aventura", null),
                new Categoria(2, "Acción", null),
                new Categoria(3, "Drama", null)
            )
        );
    }    

    @Override
    public void Crear(Categoria creaCategoria) {
        if(creaCategoria != null){
            this.listaCategorias.add(creaCategoria);        
        }
    }

    @Override
    public void Editar(Categoria editaCategoria) {

        if(editaCategoria.getId() != null || editaCategoria.getId() > 0){

            for (Categoria categoria : listaCategorias) {
                if(categoria.getId() == editaCategoria.getId()){
                    categoria.setDescripcion(editaCategoria.getDescripcion());
                }
            }

        }
        
    }

    @Override
    public void Eliminar(Integer Id) {
        if(Id != null){
            listaCategorias.remove(Id-1);
        }           
    }

    @Override
    public Categoria BuscarPorId(Integer Id) {

        Categoria obtieneCategoria = new Categoria();

        for (Categoria categoria : listaCategorias) {
            if(Id == categoria.getId()){
                obtieneCategoria = categoria;
            }
        }

        return obtieneCategoria;
    }

    @Override
    public List<Categoria> Listar() {
        return listaCategorias;
    }
    
}