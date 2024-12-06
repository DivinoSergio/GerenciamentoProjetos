package com.exemplo.gerenciamento.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.exemplo.gerenciamento.model.Projeto;
import com.exemplo.gerenciamento.model.Tarefa;
import com.exemplo.gerenciamento.repository.ProjetoRepository;
import com.exemplo.gerenciamento.repository.TarefaRepository;

@ManagedBean
@ViewScoped
public class CreateTarefaController implements Serializable {
	
	private static final long serialVersionUID = -7264627396423955289L;
	private Tarefa tarefa;
	private Projeto projeto;
	
	@PostConstruct
    public void init() {
		System.out.println("Entrou CreateTarefaController()");
		tarefa = new Tarefa();
		tarefa.setProjeto(new Projeto());
	}
		
    public List<Projeto> completeProjeto(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Projeto> projetos = ProjetoRepository.getInstance().getTodosProjetos();
        return projetos.stream().filter(t -> t.getTitulo().toLowerCase()
        		.contains(queryLowerCase)).collect(Collectors.toList());
    }
    
	public String save() {
        // Salvar no banco de dados
        System.out.println("Salvando: " + tarefa.getId() + " - " + tarefa.getTitulo());
        tarefa.setProjeto(getProjeto());
        
		TarefaRepository.getInstance().saveTarefas(tarefa);
		
        // Redirecionar de volta para a página de listagem
        return "/pages/tarefaList.xhtml?faces-redirect=true";
    }
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
