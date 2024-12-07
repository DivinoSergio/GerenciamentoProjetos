package com.exemplo.gerenciamento.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.exemplo.gerenciamento.model.Projeto;
import com.exemplo.gerenciamento.repository.ProjetoRepository;

@ManagedBean
@ViewScoped
public class ProjetoController {
	
	private List<Projeto> todosProjetos;
	private Projeto projeto = new Projeto();
	private Projeto projetoId;

	public void setTodosProjetos(List<Projeto> todosProjetos) {
		this.todosProjetos = todosProjetos;
	}
	
	public Projeto getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Projeto projetoId) {
		this.projetoId = projetoId;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public List<Projeto> getTodosProjetos() {
		return ProjetoRepository.getInstance().getTodosProjetos();
	}

    public String loadProjetoById(int id) {
    	System.out.println("Valor " + id);
    	projetoId = ProjetoRepository.getInstance().buscarProjetoPorId(Long.valueOf(id));
    	System.out.println("projetoId " + this.projetoId.getTitulo());

        // Adicionar selectedItem ao Flash Scope para usar na próxima página
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("projetoId", projetoId);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        return "/pages/projetoEdit?faces-redirect=true";
    }

    public void removeProjetoById(int id) {
    	System.out.println("Valor " + id);
    	
    	ProjetoRepository.getInstance().removeProjetos(Long.valueOf(id));
    	
        // return "/pages/projetoEdit?faces-redirect=true";
    }
}
