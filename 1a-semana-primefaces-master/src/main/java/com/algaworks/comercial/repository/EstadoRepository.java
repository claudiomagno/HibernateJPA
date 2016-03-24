package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;

public class EstadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Estado guardar(Estado estado) {
		return manager.merge(estado);
	}
	
	public List<Estado> todos() {
		List<Estado> estados = null;	
		
		try {
			estados = manager.createQuery("from Estado", Estado.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return estados;
	}

	public void excluir(Estado estado){
		Estado est = manager.find(Estado.class, estado.getUf());
		manager.remove(est);
	}
	
	
	public Estado getUF(String uf) {
		
		Query query = manager.createNamedQuery(Estado.FIND_UF);
		query.setParameter("uf", uf);
		
		return (Estado) query.getSingleResult();
	}




}