package teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;

public class Adiciona {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("magno");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("dfdff JSF");
	    tarefa.setFinalizado(true);
	    tarefa.setDataFinalizacao(Calendar.getInstance());
	    
	    manager.getTransaction().begin();    
	    manager.persist(tarefa);
	    manager.getTransaction().commit(); 
		
		System.out.println("ID da tarefa: " + tarefa.getId());
		manager.close();
	}

}
