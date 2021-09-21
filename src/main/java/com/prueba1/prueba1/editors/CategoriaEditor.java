package com.prueba1.prueba1.editors;

import java.beans.PropertyEditorSupport;

import com.prueba1.prueba1.service.CategoriaSVC.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEditor extends PropertyEditorSupport{
    @Autowired
    private CategoriaService autorService;

    @Override
    public void setAsText(String idForm) throws IllegalArgumentException{
        if (idForm != null && idForm.length() > 0) {
			try {
				Integer id = Integer.parseInt(idForm);
				this.setValue(autorService.BuscarPorId(id));
			} catch (NumberFormatException ex) {
				setValue(null);
			}
		} else {
			setValue(null);
		}	
    }
}