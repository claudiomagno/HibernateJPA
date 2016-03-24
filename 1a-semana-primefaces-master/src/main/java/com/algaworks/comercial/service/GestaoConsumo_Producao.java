package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.ConsumoProducao;
import com.algaworks.comercial.repository.Consumo_ProducaoRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoConsumo_Producao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Consumo_ProducaoRepository tempo_producaos;
	
	@Transacional
	public void salvar(ConsumoProducao tempo_producao) {
		tempo_producaos.guardar(tempo_producao);
	}
	
	@Transacional
	public List<ConsumoProducao> obeterTodos() {
		List<ConsumoProducao> lista = null;
		
		try {
			lista = tempo_producaos.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<ConsumoProducao> getConsumo_Producaoes() {
			
		return tempo_producaos.getConsumo_Producaoes();
	}
	
	
	@Transacional
	public void excluir(ConsumoProducao  tempo_producao){
		tempo_producaos.excluir(tempo_producao);
	}

}