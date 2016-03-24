package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.ConsumoProducao;


public class Consumo_ProducaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public ConsumoProducao guardar(ConsumoProducao producao) {
		return manager.merge(producao);
	}
	
	public List<ConsumoProducao> todos() {
		List<ConsumoProducao> producaos = null;	
		
		try {
			producaos = manager.createQuery("from Consumo_Producao", ConsumoProducao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaos;
	}

	public void excluir(ConsumoProducao producao){
		ConsumoProducao est = manager.find(ConsumoProducao.class, producao.getId());
		manager.remove(est);
	}
	
	
	public List<ConsumoProducao> getConsumo_Producaoes() {
		List<ConsumoProducao> producaoes = null;	
		
		try {
			producaoes = manager.createQuery("from Consumo_Producao", ConsumoProducao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return producaoes;
	}
	
	
}