package com.algaworks.comercial.repository;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Maquina;

import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.model.TipoMaquina;

public class MaquinaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Maquina guardar(Maquina maquina) {
		return manager.merge(maquina);
	}
	
	public List<Maquina> todos() {
		List<Maquina> maquinas = null;	
		
		try {
			maquinas = manager.createQuery("from Maquina", Maquina.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return maquinas;
	}

	public void excluir(Maquina maquina){
		Maquina est = manager.find(Maquina.class, maquina.getId());
		manager.remove(est);
	}
	

	public List<TipoMaquina> getTipos() {
		List<TipoMaquina> maquinas = null;	
		
		try {
			maquinas = manager.createQuery("from TipoMaquina", TipoMaquina.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return maquinas;
	}
	
	public List<Setor> getSetores() {
		List<Setor> setores = null;	
		
		try {
			setores = manager.createQuery("from Setor", Setor.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return setores;
	}
	
	public List<Aquisicao> getAquisicoes() {
		List<Aquisicao> aquisicoes = null;	
		
		try {
			aquisicoes = manager.createQuery("from Aquisicao", Aquisicao.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return aquisicoes;
	}

}