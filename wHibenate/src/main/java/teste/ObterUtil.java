package teste;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.Query;

import util.EntityManagerProducer;
import model.Tarefa;

public abstract class ObterUtil {
	
	private static EntityManager manager;
	

	
	
	public static void main(String[] args) {

		List<Tarefa> tarefas = new ArrayList<Tarefa>(); 
		
		EntityManagerProducer en = new EntityManagerProducer();
		manager = en.createEntityManager();
		
	    
	    //tarefas = manager.createQuery("from Tarefa", Tarefa.class).getResultList();
		
//		 Query query = manager
//			        .createQuery("select t from Tarefa as t "+
//			          "where t.finalizado = :paramFinalizado");
//			    query.setParameter("paramFinalizado", true);
		
//		 Query query = manager
//			        .createQuery("select t from Tarefa as t "+
//			          "where t.descricao like :paramFinalizado");
//			    query.setParameter("paramFinalizado", "%JSF%");
		
		 Query query = manager
			        .createQuery("select new model.Tarefa(t.id,t.descricao) from Tarefa as t "+
			          "where t.descricao like :paramFinalizado");
			    query.setParameter("paramFinalizado", "%JSF%");

			tarefas =  query.getResultList();
			    
	    manager.close();
	    
	    for (Tarefa t : tarefas) {
	    	System.out.println(t.getDescricao());
		}
	  }

}
