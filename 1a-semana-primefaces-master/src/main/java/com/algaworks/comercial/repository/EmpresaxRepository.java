package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Empresax;


public class EmpresaxRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Empresax guardar(Empresax empresax) {
		return manager.merge(empresax);
	}
	
	public List<Empresax> todos() {
		List<Empresax> empresaxs = null;	
		
		try {
			empresaxs = manager.createQuery("from Empresax", Empresax.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return empresaxs;
	}

	public void excluir(Empresax empresax){
		Empresax est = manager.find(Empresax.class, empresax.getId());
		manager.remove(est);
	}
	
	
	public List<Empresax> getEmpresaxes() {
		List<Empresax> empresaxes = null;	
		
		try {
			empresaxes = manager.createQuery("from Empresax", Empresax.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return empresaxes;
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