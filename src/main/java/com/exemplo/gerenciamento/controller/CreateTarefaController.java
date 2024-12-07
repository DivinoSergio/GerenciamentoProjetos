package com.exemplo.gerenciamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.exemplo.gerenciamento.model.Projeto;
import com.exemplo.gerenciamento.model.Tarefa;
import com.exemplo.gerenciamento.repository.ProjetoRepository;
import com.exemplo.gerenciamento.repository.TarefaRepository;

@Named
@ViewScoped
public class CreateTarefaController implements Serializable {
	
	private static final long serialVersionUID = -7264627396423955289L;
	private Tarefa tarefa;
//	private Projeto projeto;
	private Projeto projetoSelecionado;
	private Long projetoId;
	private String prioridade;
	
	public CreateTarefaController() {
		System.out.println("Entrou CreateTarefaController()");
		tarefa = new Tarefa();
		tarefa.setProjeto(new Projeto());
	}
		
    public List<Projeto> completeProjeto(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Projeto> projetos = ProjetoRepository.getInstance().buscarProjetos(queryLowerCase);
        return projetos;
    }
    
	public String save() {
        // Salvar no banco de dados
        System.out.println("Salvando: " + tarefa.getId() + " - " + tarefa.getTitulo());
        Projeto p = ProjetoRepository.getInstance().buscarProjetoPorId(this.projetoId);
        tarefa.setProjeto(p);
        tarefa.setPrioridade(Integer.valueOf(this.prioridade));
        
		TarefaRepository.getInstance().saveTarefas(tarefa);
		
        // Redirecionar de volta para a página de listagem
        return "/pages/tarefaList.xhtml?faces-redirect=true";
    }
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

	public Long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

}
