package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Unidade;


public class UnidadeRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Unidade guardar(Unidade unidade) {
		return manager.merge(unidade);
	}
	
	public List<Unidade> todos() {
		List<Unidade> unidades = null;	
		
		try {
			unidades = manager.createQuery("from Unidade", Unidade.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return unidades;
	}

	public void excluir(Unidade unidade){
		Unidade est = manager.find(Unidade.class, unidade.getId());
		manager.remove(est);
	}


}