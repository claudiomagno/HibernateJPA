package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Aquisicao;


public class AquisicaoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Aquisicao guardar(Aquisicao aquisicao) {
		return manager.merge(aquisicao);
	}
	
	public List<Aquisicao> todos() {
		List<Aquisicao> aquisicaos = null;	
		
		try {
			aquisicaos = manager.createQuery("from Aquisicao", Aquisicao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return aquisicaos;
	}

	public void excluir(Aquisicao aquisicao){
		Aquisicao est = manager.find(Aquisicao.class, aquisicao.getId());
		manager.remove(est);
	}
	
	
	public List<Aquisicao> getAquisicaoes() {
		List<Aquisicao> aquisicaoes = null;	
		
		try {
			aquisicaoes = manager.createQuery("from Aquisicao", Aquisicao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return aquisicaoes;
	}
	
	

}