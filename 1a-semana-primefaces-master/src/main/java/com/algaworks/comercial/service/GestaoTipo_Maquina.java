package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.TipoMaquina;
import com.algaworks.comercial.repository.Tipo_MaquinaRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoTipo_Maquina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tipo_MaquinaRepository tipo_maquinas;
	
	@Transacional
	public void salvar(TipoMaquina tipo_maquina) {
		tipo_maquinas.guardar(tipo_maquina);
	}
	
	@Transacional
	public List<TipoMaquina> obeterTodos() {
		List<TipoMaquina> lista = null;
		
		try {
			lista = tipo_maquinas.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<TipoMaquina> getTipo_Maquinaes() {
			
		return tipo_maquinas.getTipoMaquinaes();
	}
	
	
	@Transacional
	public void excluir(TipoMaquina  tipo_maquina){
		tipo_maquinas.excluir(tipo_maquina);
	}

}