package com.exemplo.gerenciamento.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.exemplo.gerenciamento.model.Projeto;

public class ProjetoRepository {

	private static ProjetoRepository uniqueInstance = new ProjetoRepository();

	private ProjetoRepository() {
	}

	public static ProjetoRepository getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ProjetoRepository();
        }
		return uniqueInstance;
	}
	
	EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
	EntityManager em = sf.createEntityManager();

	private List<Projeto> todosProjetos = new ArrayList<Projeto>();

	public List<Projeto> getTodosProjetos() {
		return em.createQuery("From Projeto").getResultList();
	}

	public void setTodosProjetos(List<Projeto> todosProjetos) {
		this.todosProjetos = todosProjetos;
	}

	private Projeto projeto = new Projeto();

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Projeto buscarProjetoPorId(Long id) {
		// Configuração do EntityManager
        EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();

        Projeto projeto = null;

        try {
            // Criar consulta HQL
            String hql = "SELECT p FROM Projeto p WHERE p.id = :id";
            TypedQuery<Projeto> query = em.createQuery(hql, Projeto.class);
            query.setParameter("id", id);

            // Executar a consulta e obter resultado
            projeto = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
            sf.close();
        }

        return projeto;
    }

	public void saveProjetos(Projeto projeto) {
		System.out.println("[Entrou] saveProjetos" );
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();
        
        try {
			em.getTransaction().begin();
			
			em.persist(projeto);
			
			em.getTransaction().commit();
			em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
            sf.close();
        }
		System.out.println("Projeto cadastrado");
	}

	public void editProjetos(Projeto projeto) {
		System.out.println("[Entrou] editProjetos" );
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();
        
        try {
			em.getTransaction().begin();
			
			em.merge(projeto);
			
			em.getTransaction().commit();
			em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fechar EntityManager
            em.close();
            sf.close();
        }
		System.out.println("Projeto alterado");
	}
	
	public void removeProjetos(Long idProjeto) {
		System.out.println("[Entrou] removeProjetos, ID: " + idProjeto);
		
		EntityManagerFactory sf = Persistence.createEntityManagerFactory("GerenciamentoProjetos");
        EntityManager em = sf.createEntityManager();
        
        try {
			em.getTransaction().begin();
			// Carregar o objeto gerenciado
		    Projeto projetoGerenciado = em.find(Projeto.class, idProjeto);
		    
		    if (projetoGerenciado != null) {
		        em.remove(projetoGerenciado);
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
		System.out.println("Projeto excluido");
	}
	
	// EXCLUIR
	public void excluiProjetoUnico() {
		System.out.println("[Entrou]\n");
		em.getTransaction().begin();
		Query p = em.createQuery("From Projeto");
		@SuppressWarnings("unchecked")
		List<Projeto> projetos = p.getResultList();

		for (Projeto c : projetos) {
			if (c.getId() == c.getId()) {
				// Excluir Projeto
				System.out.println("Projeto Removido\n");
				em.remove(projeto.getId());
				em.getTransaction().commit();
				em.close();
				break;
			}
		}
	}
}
