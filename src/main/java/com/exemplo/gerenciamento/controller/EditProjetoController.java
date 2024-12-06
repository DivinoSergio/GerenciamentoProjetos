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

import com.exemplo.gerenciamento.model.Projeto;
import com.exemplo.gerenciamento.repository.ProjetoRepository;

@ManagedBean
@ViewScoped
public class EditProjetoController implements Serializable {

	private static final long serialVersionUID = -4354208142461711818L;
	private Projeto projeto;	
	private Projeto projeto1;
	
	public EditProjetoController() {
		System.out.println("Entrou inicializando o EditProjetoController.");
		// Recuperar objeto do Flash Scope
		projeto1 = (Projeto) FacesContext.getCurrentInstance()
                          .getExternalContext().getFlash().get("projetoId");
		
	}
		
	public String edit(Projeto projeto) {
        // Salvar no banco de dados
        System.out.println("Salvando: " + projeto.getId() + " - " + projeto.getTitulo());

		ProjetoRepository.getInstance().editProjetos(projeto);
		
        // Redirecionar de volta para a página de listagem
        return "/pages/projetoList.xhtml?faces-redirect=true";
    }
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Projeto getProjeto1() {
		return projeto1;
	}

	public void setProjeto1(Projeto projeto1) {
		this.projeto1 = projeto1;
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

}
