package com.exemplo.gerenciamento.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.exemplo.gerenciamento.model.Tarefa;
import com.exemplo.gerenciamento.repository.TarefaRepository;

@ManagedBean
@ViewScoped
public class EditTarefaController implements Serializable {

	private static final long serialVersionUID = -3416840278403571207L;
	private Tarefa tarefa;	
	private Tarefa tarefa1;
	private String prioridade;
	
	@PostConstruct
	public void init() {
		System.out.println("Entrou inicializando o EditTarefaController.");
		// Recuperar objeto do Flash Scope
		tarefa1 = (Tarefa) FacesContext.getCurrentInstance()
                          .getExternalContext().getFlash().get("tarefaId");
	}
		
	public String edit(Tarefa tarefa) {
        // Salvar no banco de dados
        System.out.println("Salvando: " + tarefa.getId() + " - " + tarefa.getTitulo());

		TarefaRepository.getInstance().editTarefas(tarefa);
		
        // Redirecionar de volta para a página de listagem
        return "/pages/tarefaList.xhtml?faces-redirect=true";
    }
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public Tarefa getTarefa1() {
		return tarefa1;
	}

	public void setTarefa1(Tarefa tarefa1) {
		this.tarefa1 = tarefa1;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

}