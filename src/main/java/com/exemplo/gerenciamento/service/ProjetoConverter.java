package com.exemplo.gerenciamento.service;

import javax.faces.bean.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.exemplo.gerenciamento.model.Projeto;

@Named
@ApplicationScoped
@FacesConverter(value = "projetoConverter", managed = true)
public class ProjetoConverter  implements Converter<Projeto> {

	@Override
	public Projeto getAsObject(FacesContext arg0, UIComponent arg1, String arg2) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Projeto arg2) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
