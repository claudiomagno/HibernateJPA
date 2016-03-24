package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Tarefa;
import util.EntityManagerProducer;


public class AlterarUtil {

	private static EntityManager manager;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 EntityManagerFactory factory = Persistence.
			        createEntityManagerFactory("magno");
			    EntityManager manager = factory.createEntityManager();
			    
			    manager.getTransaction().begin();
			    
			    Tarefa t = manager.find(Tarefa.class, 1L);
			    t.setDescricao("Aprendido JSF");
			    
			    manager.getTransaction().commit();
			    
			    manager.close();
		
		
	}

}
