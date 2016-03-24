package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Estoque;


public class EstoqueRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Estoque guardar(Estoque estoque) {
		return manager.merge(estoque);
	}
	
	public List<Estoque> todos() {
		List<Estoque> estoques = null;	
		
		try {
			estoques = manager.createQuery("from Estoque", Estoque.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return estoques;
	}

	public void excluir(Estoque estoque){
		Estoque est = manager.find(Estoque.class, estoque.getId());
		manager.remove(est);
	}
	
	
	public List<Estoque> getEstoquees() {
		List<Estoque> estoquees = null;	
		
		try {
			estoquees = manager.createQuery("from Estoque", Estoque.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return estoquees;
	}
	
	

}