package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.Produto;
import com.algaworks.comercial.repository.ProdutoRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoRepository produtos;
	
	@Transacional
	public void salvar(Produto setor) {
		produtos.guardar(setor);
	}
	
	@Transacional
	public List<Produto> obeterTodos() {
		List<Produto> lista = null;
		
		try {
			lista = produtos.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<Produto> getProdutoes() {
			
		return produtos.getProdutoes();
	}
	
	
	@Transacional
	public void excluir(Produto  setor){
		produtos.excluir(setor);
	}
	
	@Transacional
	public Estoque getEstoqueMPrima(Produto produto){
		
		return produtos.getEstoqueProduto(produto);
		
	}

}