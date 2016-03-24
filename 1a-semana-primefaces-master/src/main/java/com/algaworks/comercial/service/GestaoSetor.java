package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.repository.SetorRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoSetor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SetorRepository setors;
	
	@Transacional
	public void salvar(Setor setor) {
		setors.guardar(setor);
	}
	
	@Transacional
	public List<Setor> obeterTodos() {
		List<Setor> lista = null;
		
		try {
			lista = setors.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<Setor> getSetores() {
			
		return setors.getSetores();
	}
	
	
	@Transacional
	public void excluir(Setor  setor){
		setors.excluir(setor);
	}

}