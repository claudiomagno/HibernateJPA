package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.TempoProducao;


public class Tempo_ProducaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public TempoProducao guardar(TempoProducao producao) {
		return manager.merge(producao);
	}
	
	public List<TempoProducao> todos() {
		List<TempoProducao> producaos = null;	
		
		try {
			producaos = manager.createQuery("from TempoProducao", TempoProducao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaos;
	}

	public void excluir(TempoProducao producao){
		TempoProducao est = manager.find(TempoProducao.class, producao.getId());
		manager.remove(est);
	}
	
	
	public List<TempoProducao> getTempoProducaoes() {
		List<TempoProducao> producaoes = null;	
		
		try {
			producaoes = manager.createQuery("from TempoProducao", TempoProducao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaoes;
	}
	
	
}