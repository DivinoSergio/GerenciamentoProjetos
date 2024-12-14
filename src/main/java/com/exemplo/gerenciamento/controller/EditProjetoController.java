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
	private Projeto projetoId;

	public void init() {
		System.out.println("Entrou inicializando o EditProjetoController.");
		 // Obtém o parâmetro da URL e carrega o objeto
        String idParam = FacesContext.getCurrentInstance().getExternalContext()
        		.getRequestParameterMap().get("id");
        
        if (idParam != null) {
            int id = Integer.parseInt(idParam);
            projetoId = ProjetoRepository.getInstance().findById(id);
        }
	}
	
	public String edit() {
        // Salvar no banco de dados
        System.out.println("Salvando: " + projetoId.getId() + " - " + projetoId.getTitulo());

		ProjetoRepository.getInstance().editProjetos(projetoId);
		
        // Redirecionar de volta para a página de listagem
        return "/pages/projetoList.xhtml?faces-redirect=true";
    }
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Projeto getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Projeto projetoId) {
		this.projetoId = projetoId;
	}
}