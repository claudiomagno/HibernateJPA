package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Maquina;
import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.model.TipoMaquina;
import com.algaworks.comercial.repository.MaquinaRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoMaquina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaquinaRepository maquinas;
	
	@Transacional
	public void salvar(Maquina maquina) {
		maquinas.guardar(maquina);
	}
	
	@Transacional
	public List<Maquina> obeterTodos() {
		List<Maquina> lista = null;
		
		try {
			lista = maquinas.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	@Transacional
	public List<TipoMaquina> getTipos() {
	
		return maquinas.getTipos();
	}
	@Transacional
	public List<Setor> getSetores() {
			
		return maquinas.getSetores();
	}
	@Transacional
	public List<Aquisicao> getAquisicoes() {
	
		return maquinas.getAquisicoes();
	}
	
	@Transacional
	public void excluir(Maquina  maquina){
		maquinas.excluir(maquina);
	}

}