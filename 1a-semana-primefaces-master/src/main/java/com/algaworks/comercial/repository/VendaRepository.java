package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Venda;


public class VendaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Venda guardar(Venda venda) {
		return manager.merge(venda);
	}
	
	public List<Venda> todos() {
		List<Venda> vendas = null;	
		
		try {
			vendas = manager.createQuery("from Venda", Venda.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return vendas;
	}

	public void excluir(Venda venda){
		Venda est = manager.find(Venda.class, venda.getId());
		manager.remove(est);
	}
	
	
	public List<Venda> getVendaes() {
		List<Venda> vendaes = null;	
		
		try {
			vendaes = manager.createQuery("from Venda", Venda.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return vendaes;
	}
	
	

}