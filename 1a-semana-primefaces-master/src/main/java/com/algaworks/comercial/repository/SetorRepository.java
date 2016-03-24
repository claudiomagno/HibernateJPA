package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Setor;


public class SetorRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Setor guardar(Setor setor) {
		return manager.merge(setor);
	}
	
	public List<Setor> todos() {
		List<Setor> setors = null;	
		
		try {
			setors = manager.createQuery("from Setor", Setor.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return setors;
	}

	public void excluir(Setor setor){
		Setor est = manager.find(Setor.class, setor.getId());
		manager.remove(est);
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
	
	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = null;	
		
		try {
			funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return funcionarios;
	}

}