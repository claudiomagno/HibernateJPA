package dao;

import javax.persistence.EntityManager;

import model.Tarefa;

public class TarefaDao extends GenericDAO<Long, Tarefa> {

	public TarefaDao(EntityManager entityManager) {
        super(entityManager);
    }
}
