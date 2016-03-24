package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.repository.EstoqueRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoEstoque implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstoqueRepository estoques;
	
	@Transacional
	public void salvar(Estoque estoque) {
		estoques.guardar(estoque);
	}
	
	@Transacional
	public List<Estoque> obeterTodos() {
		List<Estoque> lista = null;
		
		try {
			lista = estoques.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<Estoque> getEstoquees() {
			
		return estoques.getEstoquees();
	}
	
	
	@Transacional
	public void excluir(Estoque  estoque){
		estoques.excluir(estoque);
	}

}