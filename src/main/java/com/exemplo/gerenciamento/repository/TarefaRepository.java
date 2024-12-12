package com.exemplo.gerenciamento.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.exemplo.gerenciamento.model.Tarefa;

public class TarefaRepository extends GenericRepository<Tarefa, Integer> {

	private static TarefaRepository uniqueInstance = new TarefaRepository();

	private TarefaRepository() {
		super(Tarefa.class);
	}
	
	public static TarefaRepository getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TarefaRepository();
        }
		return uniqueInstance;
	}
	
	private List<Tarefa> todosTarefas;

	public List<Tarefa> getTodosTarefas() {
		EntityManager em = getEntityManager();
		String hql = "SELECT t FROM Tarefa t ORDER BY t.projeto.id, t.id";
		return em.createQuery(hql).getResultList();
	}

	public void setTodosTarefas(List<Tarefa> todosTarefas) {
		this.todosTarefas = todosTarefas;
	}

	private Tarefa tarefa = new Tarefa();

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public Tarefa buscarTarefaPorId(Long id) {
		// Configuração do EntityManager
		EntityManager em = getEntityManager();

        Tarefa tarefa = null;

        try {
            // Criar consulta HQL
            String hql = "SELECT p FROM Tarefa p WHERE p.id = :id";
            TypedQuery<Tarefa> query = em.createQuery(hql, Tarefa.class);
            query.setParameter("id", id);

            // Executar a consulta e obter resultado
            tarefa = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
        }

        return tarefa;
    }

	public void saveTarefas(Tarefa tarefa) {
		System.out.println("[Entrou] saveTarefas" );
		EntityManager em = getEntityManager();
        
        try {
			em.getTransaction().begin();
			
			em.persist(tarefa);
			
			em.getTransaction().commit();
			em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
        }
		System.out.println("Tarefa cadastrado");
	}

	public void editTarefas(Tarefa tarefa) {
		System.out.println("[Entrou] editTarefas" );
		EntityManager em = getEntityManager();
        
        try {
			em.getTransaction().begin();
			
			em.merge(tarefa);
			
			em.getTransaction().commit();
			em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
        }
		System.out.println("Tarefa alterado");
	}
	
	public void removeTarefas(Long idTarefa) {
		System.out.println("[Entrou] removeTarefas, ID: " + idTarefa);
		EntityManager em = getEntityManager();
        
        try {
			em.getTransaction().begin();
			// Carregar o objeto gerenciado
		    Tarefa tarefaGerenciado = em.find(Tarefa.class, idTarefa);
		    
		    if (tarefaGerenciado != null) {
		        em.remove(tarefaGerenciado);
		    }
		    
			em.getTransaction().commit();

        } catch (Exception e) {
        	em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
        }
		System.out.println("Tarefa excluido");
	}
}