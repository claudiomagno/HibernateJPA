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
import com.algaworks.comercial.model.Tarefa;

import dao.GenericDAO;
import dao.TarefaDao;

public class TarefasRepository extends GenericDAO<Long, Tarefa> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public Tarefa guardar(Tarefa tarefa) {
		return manager.merge(tarefa);
	}
	
//	public List<Tarefa> todos() {
//		List<Tarefa> Tarefas = new ArrayList<Tarefa>();	
//		//todosOrcamentos = manager.createQuery("from Orcamento", Orcamento.class).getResultList();
//		
//		return dao.findAll();
//	}

}