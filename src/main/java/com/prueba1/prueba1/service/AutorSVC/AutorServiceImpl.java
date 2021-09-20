package com.prueba1.prueba1.service.AutorSVC;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.prueba1.prueba1.models.Autor;

import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

    private List<Autor> listaAutores;

    public AutorServiceImpl() {
        this.listaAutores = new ArrayList<Autor>(
            Arrays.asList(
                new Autor(1, "Felipe Azua", "chileno", null, "pipe", null),
                new Autor(2, "Mickel muñoz", "extranjero", null, "", null),
                new Autor(3, "Manuel Lara", "chileno", null, "manu", null)
            )
        );
    }

    @Override
    public void Crear(Autor creaAutor) {
        if(creaAutor != null){
            this.listaAutores.add(creaAutor);
        }
    }

    @Override
    public void Editar(Autor editaAutor) {
        if(editaAutor.getId() != null || editaAutor.getId() > 0){
            for (Autor autor : listaAutores) {
                if(autor.getId() == editaAutor.getId()){
                    autor.setNombre(editaAutor.getNombre());
                    autor.setNacionalidad(editaAutor.getNacionalidad());
                    autor.setFechaNacimiento(editaAutor.getFechaNacimiento());
                    autor.setSeudonimo(editaAutor.getSeudonimo());
                }
            }
        }        
    }

    @Override
    public void Eliminar(Integer Id) {
        if(Id != null){
            listaAutores.remove(Id-1);
        }        
    }

    @Override
    public Autor BuscarPorId(Integer Id) {
        Autor obtieneAutor = new Autor();

        for (Autor autor : listaAutores) {
            if(Id == autor.getId()){
                obtieneAutor = autor;
            }
        }

        return obtieneAutor;
    }

    @Override
    public List<Autor> Listar() {
        return listaAutores;
    }
    
}