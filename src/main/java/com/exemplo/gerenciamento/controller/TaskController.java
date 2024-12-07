package com.exemplo.gerenciamento.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.*;

import com.exemplo.gerenciamento.model.Projeto;
import com.exemplo.gerenciamento.model.Tarefa;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class TaskController  implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
    private Tarefa tarefa = new Tarefa();
    private Projeto projetoSelecionado;

    // Método para buscar todos os projetos para autocomplete
    public List<Projeto> buscarProjetos(String query) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Projeto p WHERE LOWER(p.titulo) LIKE :query", Projeto.class)
                 .setParameter("query", "%" + query.toLowerCase() + "%")
                 .getResultList();
    }

    // Método para salvar a tarefa no banco de dados
    public String salvarTarefa() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            tarefa.setProjeto(projetoSelecionado);
            em.persist(tarefa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return "tarefas?faces-redirect=true";
    }

    // Getters e Setters
    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Projeto getProjetoSelecionado() {
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(Projeto projetoSelecionado) {
        this.projetoSelecionado = projetoSelecionado;
    }
}
