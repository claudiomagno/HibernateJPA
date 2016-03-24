package util;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("magno");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	@Produces
	@RequestScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return factory;
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
	
	@Produces
	public void criarEntityManager() throws Exception{
	     factory = Persistence.createEntityManagerFactory("magno");
	     manager = factory.createEntityManager();
	}

}