package com.exemplo.gerenciamento.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.exemplo.gerenciamento.model.Tarefa;

public class TarefaRepository {

	private static TarefaRepository uniqueInstance = new TarefaRepository();

	private TarefaRepository() {
	}

	public static TarefaRepository getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TarefaRepository();
        }
		return uniqueInstance;
	}
	
	EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
	EntityManager em = sf.createEntityManager();

	private List<Tarefa> todosTarefas = new ArrayList<Tarefa>();

	public List<Tarefa> getTodosTarefas() {
		return em.createQuery("From Tarefa").getResultList();
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
        EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();

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
            sf.close();
        }

        return tarefa;
    }

	public void saveTarefas(Tarefa tarefa) {
		System.out.println("[Entrou] saveTarefas" );
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();
        
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
            sf.close();
        }
		System.out.println("Tarefa cadastrado");
	}

	public void editTarefas(Tarefa tarefa) {
		System.out.println("[Entrou] editTarefas" );
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();
        
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
            sf.close();
        }
		System.out.println("Tarefa alterado");
	}
	
	public void removeTarefas(Long idTarefa) {
		System.out.println("[Entrou] removeTarefas, ID: " + idTarefa);
		
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoTarefas");
        EntityManager em = sf.createEntityManager();
        
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
            sf.close();
        }
		System.out.println("Tarefa excluido");
	}
	
	// EXCLUIR
	public void excluiTarefaUnico() {
		System.out.println("[Entrou]\n");
		em.getTransaction().begin();
		Query p = em.createQuery("From Tarefa");
		@SuppressWarnings("unchecked")
		List<Tarefa> tarefas = p.getResultList();

		for (Tarefa c : tarefas) {
			if (c.getId() == c.getId()) {
				// Excluir Tarefa
				System.out.println("Tarefa Removido\n");
				em.remove(tarefa.getId());
				em.getTransaction().commit();
				em.close();
				break;
			}
		}
	}
}
