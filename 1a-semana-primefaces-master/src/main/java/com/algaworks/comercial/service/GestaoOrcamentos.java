package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.repository.OrcamentosRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoOrcamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private OrcamentosRepository orcamentos;
	
	@Transacional
	public void salvar(Orcamento orcamento) {
		orcamentos.guardar(orcamento);
	}
	
	@Transacional
	public List<Orcamento> obeterTodos() {
		return orcamentos.todos();
	}
	
	@Transacional
	public List<OrcamentoItem> obeterItens() {
		return orcamentos.todosItens();
	}
	
	@Transacional
	public List<Orcamento> obterClienteCpf() {
		return orcamentos.todosClienteCpf();
	}
	
//	@Transacional
//	public List<Orcamento> obterValidacao(Date data_validade) {
//		return orcamentos.obterValidacao(data_validade);
//	}
}