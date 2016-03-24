package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Unidade;
import com.algaworks.comercial.repository.UnidadeRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoUnidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadeRepository unidades;
	
	@Transacional
	public void salvar(Unidade unidade) {
		unidades.guardar(unidade);
	}
	
	
	public List<Unidade> obeterTodos() {
		List<Unidade> lista = null;
		
		try {
			lista = unidades.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
		
	
	@Transacional
	public void excluir(Unidade  unidade){
		unidades.excluir(unidade);
	}

}