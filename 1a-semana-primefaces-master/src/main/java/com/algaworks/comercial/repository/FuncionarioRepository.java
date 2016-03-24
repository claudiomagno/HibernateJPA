package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Funcionario;


public class FuncionarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Funcionario guardar(Funcionario funcionario) {
		return manager.merge(funcionario);
	}
	
	public List<Funcionario> todos() {
		List<Funcionario> funcionarios = null;	
		
		try {
			funcionarios = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return funcionarios;
	}

	public void excluir(Funcionario funcionario){
		Funcionario est = manager.find(Funcionario.class, funcionario.getId());
		manager.remove(est);
	}
	
	
	public List<Funcionario> getFuncionarioes() {
		List<Funcionario> funcionarioes = null;	
		
		try {
			funcionarioes = manager.createQuery("from Funcionario", Funcionario.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return funcionarioes;
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