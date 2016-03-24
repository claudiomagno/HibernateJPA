package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Venda;
import com.algaworks.comercial.repository.VendaRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoVenda implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private VendaRepository vendas;
	
	@Transacional
	public void salvar(Venda venda) {
		vendas.guardar(venda);
	}
	
	@Transacional
	public List<Venda> obeterTodos() {
		List<Venda> lista = null;
		
		try {
			lista = vendas.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<Venda> getVendaes() {
			
		return vendas.getVendaes();
	}
	
	
	@Transacional
	public void excluir(Venda  venda){
		vendas.excluir(venda);
	}

}