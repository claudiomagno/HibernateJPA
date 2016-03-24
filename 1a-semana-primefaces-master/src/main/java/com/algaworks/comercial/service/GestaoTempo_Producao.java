package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.TempoProducao;
import com.algaworks.comercial.repository.Tempo_ProducaoRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoTempo_Producao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tempo_ProducaoRepository tempo_producaos;
	
	@Transacional
	public void salvar(TempoProducao tempo_producao) {
		tempo_producaos.guardar(tempo_producao);
	}
	
	@Transacional
	public List<TempoProducao> obeterTodos() {
		List<TempoProducao> lista = null;
		
		try {
			lista = tempo_producaos.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<TempoProducao> getTempo_Producaoes() {
			
		return tempo_producaos.getTempoProducaoes();
	}
	
	
	@Transacional
	public void excluir(TempoProducao  tempo_producao){
		tempo_producaos.excluir(tempo_producao);
	}

}