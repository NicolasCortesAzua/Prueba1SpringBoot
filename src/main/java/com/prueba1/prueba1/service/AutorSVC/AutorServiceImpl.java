package com.prueba1.prueba1.service.AutorSVC;

import java.util.List;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.prueba1.prueba1.models.Autor;

import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

    private List<Autor> listaAutores;

    public AutorServiceImpl() {
        this.listaAutores = new ArrayList<Autor>(Arrays.asList(
                new Autor("FEL2008", "Felipe", "Azua", "chileno", LocalDate.of(2008, 1, 18).toString(), "pipe", null),
                new Autor("MIC1999", "Mickel", "muñoz", "extranjero", LocalDate.of(1999, 2, 22).toString(), "", null),
                new Autor("MAN1998", "Manuel", "Lara", "chileno", LocalDate.of(1998, 5, 28).toString(), "manu", null)));
    }

    @Override
    public void Crear(Autor creaAutor) {
        if (creaAutor != null) {
            String letrasId = creaAutor.getNombre().substring(0, 3).toUpperCase();
            String annioId = creaAutor.getFechaNacimiento().substring(0, 4);

            String id = letrasId + annioId;
            creaAutor.setId(id);
            this.listaAutores.add(creaAutor);
        }
    }

    @Override
    public void Editar(Autor editaAutor) {

        for (Autor autor : listaAutores) {
            if (autor.getId().equals(editaAutor.getId())) {
                autor.setNombre(editaAutor.getNombre());
                autor.setNacionalidad(editaAutor.getNacionalidad());
                autor.setFechaNacimiento(editaAutor.getFechaNacimiento());
                autor.setSeudonimo(editaAutor.getSeudonimo());
            }
        }

    }

    @Override
    public void Eliminar(String Id) {
        if (Id != null) {
            for (Autor autor : this.listaAutores) {
                if (Id.equals(autor.getId())) {
                    this.listaAutores.remove(autor);
                    break;
                }
            }
        }
    }

    @Override
    public Autor BuscarPorId(String idAutor) {
        Autor obtieneAutor = new Autor();

        for (Autor autor : this.listaAutores) {
            String idAut = autor.getId();
            if (idAutor.equals(idAut)) {
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