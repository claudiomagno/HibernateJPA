package teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class CarregaTarefa {
	
	public static void main(String[] args) {

		List<Tarefa> tarefas = new ArrayList<Tarefa>(); 
		
	    EntityManagerFactory factory = Persistence.
	        createEntityManagerFactory("magno");
	    EntityManager manager = factory.createEntityManager();

//	    Tarefa encontrada = manager.find(Tarefa.class, 3L);
//	    System.out.println(encontrada.getDescricao());  
	    
	    tarefas = manager.createQuery("from Tarefa", Tarefa.class).getResultList();

	    manager.close();
	    
	    for (Tarefa t : tarefas) {
	    	System.out.println(t.getDescricao());
		}
	  }

}
