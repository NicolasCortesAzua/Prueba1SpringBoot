package com.prueba1.prueba1.editors;

import java.beans.PropertyEditorSupport;

import com.prueba1.prueba1.service.AutorSVC.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorEditor extends PropertyEditorSupport{

    @Autowired
    private AutorService autorService;

    @Override
    public void setAsText(String idForm) throws IllegalArgumentException{
        if (idForm != null && idForm.length() > 0) {
			try {
				this.setValue(autorService.BuscarPorId(idForm));
			} catch (NumberFormatException ex) {
				setValue(null);
			}
		} else {
			setValue(null);
		}	
    }
}