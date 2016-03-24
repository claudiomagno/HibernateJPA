package teste;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.DAO;
import servico.TarefaServico;
import util.EntityManagerProducer;
import util.SimpleEntityManager;
import model.Tarefa;

public abstract class ObterDAo {
	
	@PersistenceContext
	private static EntityManager manager;
	
	private static DAO<Tarefa> tarefaDao;

	public static void main(String[] args) {

		List<Tarefa> tarefas = new ArrayList<Tarefa>(); 
		
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("magno");
		
		TarefaServico servico = new TarefaServico(simpleEntityManager);

	    
	    for (Tarefa t : servico.findAll()) {
	    	System.out.println(t.getDescricao());
		}
	    
	    simpleEntityManager.close();
	  }

}
