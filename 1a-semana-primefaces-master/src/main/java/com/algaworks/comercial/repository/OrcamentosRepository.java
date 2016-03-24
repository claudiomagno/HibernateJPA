package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;

public class OrcamentosRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	
	public Orcamento guardar(Orcamento orcamento) {
		return manager.merge(orcamento);
	}
	
	public List<Orcamento> todos() {
		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();	
		todosOrcamentos = manager.createQuery("from Orcamento", Orcamento.class).getResultList();
		
		return todosOrcamentos;
	}
	
	public List<OrcamentoItem> todosItens() {
		List<OrcamentoItem> todosOrcamentos = new ArrayList<OrcamentoItem>();	
		todosOrcamentos = manager.createQuery("from OrcamentoItem", OrcamentoItem.class).getResultList();
		return todosOrcamentos;
	}
	
	//JPA: Criando um objeto dentro da consulta - nao popular um objeto completo traz 2 colunas
	public List<Orcamento> todosClienteCpf() {
		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();	
		Query query = manager
		        .createQuery("select new com.algaworks.comercial.model.Orcamento(o.cliente,o.cpf)" 
		+"from Orcamento o order by o.id");
		 
		return query.getResultList();
	}
	
//	public List<Orcamento> obterValidacao(Date data_validade) {
//		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();	
//		Query query = manager.createNamedQuery(Orcamento.FIND_DATA);
//		query.setParameter("data_validade", data_validade);
//		return query.getResultList();
//	}

}