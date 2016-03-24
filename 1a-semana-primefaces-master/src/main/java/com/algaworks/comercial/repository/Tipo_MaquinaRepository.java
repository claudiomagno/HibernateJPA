package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.TipoMaquina;


public class Tipo_MaquinaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public TipoMaquina guardar(TipoMaquina tipo_maquina) {
		return manager.merge(tipo_maquina);
	}
	
	public List<TipoMaquina> todos() {
		List<TipoMaquina> tipo_maquinas = null;	
		
		try {
			tipo_maquinas = manager.createQuery("from TipoMaquina", TipoMaquina.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tipo_maquinas;
	}

	public void excluir(TipoMaquina tipo_maquina){
		TipoMaquina est = manager.find(TipoMaquina.class, tipo_maquina.getId());
		manager.remove(est);
	}
	
	
	public List<TipoMaquina> getTipoMaquinaes() {
		List<TipoMaquina> tipo_maquinaes = null;	
		
		try {
			tipo_maquinaes = manager.createQuery("from TipoMaquina", TipoMaquina.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return tipo_maquinaes;
	}
	
	

}