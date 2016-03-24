package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.model.Tarefa;
import com.algaworks.comercial.service.GestaoOrcamentos;
import com.algaworks.comercial.service.GestaoTarefas;

@Named
@ViewScoped
public class CadastroOrcamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GestaoOrcamentos gestaoOrcamentos;
	@Inject
	private GestaoTarefas gestaoTarefas;
	
	private Orcamento orcamento = new Orcamento();
	
	private OrcamentoItem item;
	
	public void novoItem() {
		item = new OrcamentoItem();
	}
	
	public void adicionarItem() {
		orcamento.getItens().add(item);
		item.setOrcamento(orcamento);
	}
	
	public void salvar() {
		gestaoOrcamentos.salvar(orcamento);
		orcamento = new Orcamento();
		
		FacesMessage msg = new FacesMessage("Orçamento salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}

	public OrcamentoItem getItem() {
		return item;
	}
	
	public List<Orcamento> getTodosOrcamentos() {
		
		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();
		todosOrcamentos = gestaoOrcamentos.obeterTodos();
		return todosOrcamentos;
	}
	
	public List<OrcamentoItem> getTodosItens() {
		
		//http://uaihebert.com/jpa-consultas-e-dicas/2/
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		List<OrcamentoItem> itens = new ArrayList<OrcamentoItem>();
		List<Orcamento> todosOrcamentos = new ArrayList<Orcamento>();
		itens = gestaoOrcamentos.obeterItens();
		todosOrcamentos = getValicacoes();
		
		Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("hhghgh JSF");
	    tarefa.setFinalizado(false);
	    //tarefa.setDataFinalizacao(Calendar.getInstance());	
	    //gestaoTarefas.save(tarefa);
	    
	    //tarefa = gestaoTarefas.getById(8L);
		//tarefas = gestaoTarefas.obterTodos();
		
//		for (Orcamento orcamento : todosOrcamentos) {
//			orcamento.getCpf();
//		}
		return itens;
	}
	
	public List<Orcamento> getValicacoes(){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data_validade = null;
        try {
        	data_validade = formatter.parse("22/02/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
//		return gestaoOrcamentos.obterValidacao(data_validade);
        return null;
	
	}
}