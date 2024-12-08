package com.exemplo.gerenciamento.controller;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.exemplo.gerenciamento.model.Tarefa;
import com.exemplo.gerenciamento.repository.TarefaRepository;

@ViewScoped
public class TarefasController {

	private List<Tarefa> todosTarefas;
	private Tarefa tarefa = new Tarefa();
	private Tarefa tarefaId;

	public void setTodosTarefas(List<Tarefa> todosTarefas) {
		this.todosTarefas = todosTarefas;
	}
	
	public Tarefa getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Tarefa tarefaId) {
		this.tarefaId = tarefaId;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public List<Tarefa> getTodosTarefas() {
		return TarefaRepository.getInstance().getTodosTarefas();
	}

    public String loadTarefaById(int id) {
    	System.out.println("Valor " + id);
    	tarefaId = TarefaRepository.getInstance().buscarTarefaPorId(Long.valueOf(id));
    	System.out.println("tarefaId " + this.tarefaId.getTitulo());

        // Adicionar selectedItem ao Flash Scope para usar na próxima página
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tarefaId", tarefaId);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        return "/pages/tarefaEdit?faces-redirect=true";
    }

    public void removeTarefaById(int idTarefa ) {
    	System.out.println("Valor " + idTarefa);
    	
    	TarefaRepository.getInstance().removeTarefas(Long.valueOf(idTarefa));

        // return "/pages/tarefaEdit?faces-redirect=true";
    }
}