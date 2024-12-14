package com.exemplo.gerenciamento.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
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

    public String editarProjeto() {
        return "projetoEdit.xhtml?faces-redirect=true&id=" + projetoId.getId();
    }

    public String loadProjetoById(int id) {
    	System.out.println("Valor " + id);
    	projetoId = ProjetoRepository.getInstance().findById(id);
    	System.out.println("projetoId " + this.projetoId.getTitulo());

        // Adicionar selectedItem ao Flash Scope para usar na próxima página
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("projetoId", projetoId);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        return "/pages/projetoEdit?faces-redirect=true";
    }

    public void removeProjetoById(int id) {
    	System.out.println("Valor " + id);
    	
    	try {
	    	ProjetoRepository.getInstance().removeProjetos(id);
	    	
	    } catch (IllegalStateException e) {
	        // Captura a exceção e adiciona uma mensagem ao contexto
	        addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir o projeto", 
	        		"Não é possível excluir o Projeto, possui Tarefas associadas.");
	        
	    } catch (Exception e) {
	        // Tratamento genérico para outras exceções
	        addMessage(FacesMessage.SEVERITY_FATAL, "Erro ao excluir o projeto", 
	        		"Não é possível excluir o Projeto, possui Tarefas associadas.");
	    }
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
}