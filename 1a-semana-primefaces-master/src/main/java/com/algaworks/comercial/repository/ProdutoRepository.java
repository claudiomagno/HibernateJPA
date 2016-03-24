package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.Produto;


public class ProdutoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}
	
	public List<Produto> todos() {
		List<Produto> produtos = null;	
		
		try {
			produtos = manager.createQuery("from Produto", Produto.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return produtos;
	}

	public void excluir(Produto produto){
		Produto est = manager.find(Produto.class, produto.getId());
		manager.remove(est);
	}
	
	
	public List<Produto> getProdutoes() {
		List<Produto> produtoes = null;	
		
		try {
			produtoes = manager.createQuery("from Produto", Produto.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return produtoes;
	}
	
	public Estoque getEstoqueProduto(Produto produto){
		
		Estoque est = new Estoque();
		
		return est = manager.find(Estoque.class, produto.getId());
		
	}
	
}