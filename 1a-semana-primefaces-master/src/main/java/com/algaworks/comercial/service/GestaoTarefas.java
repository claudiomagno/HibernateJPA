package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Tarefa;
import com.algaworks.comercial.repository.TarefasRepository;
import com.algaworks.comercial.util.Transacional;

import dao.GenericDAO;

public class GestaoTarefas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TarefasRepository tarefas;
	
	public List<Tarefa> obterTodos(){
		
		return tarefas.findAll();		
	}
	
}
