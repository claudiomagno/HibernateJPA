package teste;

import java.util.Calendar;

import javax.inject.Inject;
import javax.persistence.EntityManager;




import repository.TarefasRepository;
import servico.TarefaServico;
import util.EntityManagerProducer;
import model.Tarefa;



public class AdcionaUtil {

	private static EntityManager manager;
	
	@Inject
	private static TarefasRepository ts;
	
	public static void add(){
		
		Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("Revisar Python ");
	    tarefa.setFinalizado(true);
	    tarefa.setDataFinalizacao(Calendar.getInstance());
	    //tarefaServico.salvar(tarefa);
	    
	    TarefasRepository t = new TarefasRepository();
	    
	    t.guardar(tarefa);
	}
	
	public static void main(String[] args) {
		
		add();
		
//		TarefaServico tarefaServico = null;
//		
//		Tarefa tarefa = new Tarefa();
//	    tarefa.setDescricao("Revisar Python ");
//	    tarefa.setFinalizado(true);
//	    tarefa.setDataFinalizacao(Calendar.getInstance());
		
	    
//		EntityManagerProducer en = new EntityManagerProducer();
//		
//		manager = en.createEntityManager();
//		
//		 manager.getTransaction().begin(); 
//		manager.persist(tarefa);
//		manager.getTransaction().commit();
//		
//		System.out.println("ID do tarefa: " + tarefa.getId());
//		
//		manager.close();

	}

}
