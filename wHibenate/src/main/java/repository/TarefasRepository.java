package repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Tarefa;


public class TarefasRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@Inject
	private EntityManagerFactory factory;
	
	public Tarefa guardar(Tarefa tarefa) {
		return manager.merge(tarefa);
	}

}
