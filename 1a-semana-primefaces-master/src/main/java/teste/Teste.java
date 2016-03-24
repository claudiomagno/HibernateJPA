package teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.Tarefa;
import com.algaworks.comercial.service.GestaoOrcamentos;
import com.algaworks.comercial.util.EntityManagerProducer;

public class Teste {

	private static EntityManager manager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();
		Orcamento o = new Orcamento();
		Date dt = new Date();
		o.setCliente("Magno");
		o.setCpf("5454454544");
		o.setCondicaoPagamento("A vista");
		o.setDiasEntrega(4);
		o.setDataValidade(dt);
		o.setTelefone("64646464");
		
		Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("Estudar JPA e Hibernate");
	    tarefa.setFinalizado(true);
	    //tarefa.setDataFinalizacao(Calendar.getInstance());
		
		EntityManagerProducer en = new EntityManagerProducer();
		
		manager = en.createEntityManager();
		
		manager.merge(tarefa);
		
		
		//Orcamento or = manager.find(Orcamento.class, 1);
		
		System.out.println("ID do Orcamento: " + tarefa.getId());

		//manager.close();
		
	}

}
