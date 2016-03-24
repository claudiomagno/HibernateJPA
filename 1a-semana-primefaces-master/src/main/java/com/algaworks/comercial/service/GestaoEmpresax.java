package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Empresax;
import com.algaworks.comercial.repository.EmpresaxRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoEmpresax implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaxRepository empresaxs;
	
	@Transacional
	public void salvar(Empresax empresax) {
		empresaxs.guardar(empresax);
	}
	
	
	public List<Empresax> obeterTodos() {
		List<Empresax> lista = null;
		
		try {
			lista = empresaxs.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
		
	
	@Transacional
	public void excluir(Empresax  empresax){
		empresaxs.excluir(empresax);
	}

}