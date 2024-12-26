package br.com.mendes.projectmanager.controller;

import java.io.IOException;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UiController {
	
	public void navToIndexPage() {
		try {
			//FacesContext.getCurrentInstance().getExternalContext().redirect(url);
			FacesContext f = FacesContext.getCurrentInstance();
			ExternalContext ec = f.getExternalContext();
			ec.redirect(ec.getRequestContextPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}
