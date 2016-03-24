package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Producao;


public class ProducaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Producao guardar(Producao producao) {
		return manager.merge(producao);
	}
	
	public List<Producao> todos() {
		List<Producao> producaos = null;	
		
		try {
			producaos = manager.createQuery("from Producao", Producao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaos;
	}

	public void excluir(Producao producao){
		Producao est = manager.find(Producao.class, producao.getId());
		manager.remove(est);
	}
	
	
	public List<Producao> getProducaoes() {
		List<Producao> producaoes = null;	
		
		try {
			producaoes = manager.createQuery("from Producao", Producao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaoes;
	}
	
	
}