package servico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import model.Tarefa;
import repository.TarefasRepository;
import util.SimpleEntityManager;
import util.Transacional;
import dao.TarefaDao;


public class TarefaServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TarefaDao dao;
	private SimpleEntityManager simpleEntityManager;
	
	
	  public TarefaServico(SimpleEntityManager simpleEntityManager){
	        this.simpleEntityManager = simpleEntityManager;
	        dao = new TarefaDao(simpleEntityManager.getEntityManager());
	    }
	     
	    public void save(Tarefa tarefa){
	        try{
	            simpleEntityManager.beginTransaction();
	            dao.save(tarefa);
	            simpleEntityManager.commit();
	        }catch(Exception e){
	            e.printStackTrace();
	            simpleEntityManager.rollBack();
	        }
	    }
	     
	    public List<Tarefa> findAll(){
	        return dao.findAll();
	    }
	
	@Inject
	private TarefasRepository tarefas;
	
	@Transacional
	public void salvar(Tarefa tarefa) {
		tarefas.guardar(tarefa);
	}
	
//	@Transacional
//	public List<Orcamento> obeterTodos() {
//		return orcamentos.todos();
//	}

}
