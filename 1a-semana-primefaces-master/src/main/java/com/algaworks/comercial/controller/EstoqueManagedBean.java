package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.MPrima;
import com.algaworks.comercial.model.Produto;
import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.service.GestaoEmpresa;
import com.algaworks.comercial.service.GestaoEstoque;
import com.algaworks.comercial.util.Transacional;
 

@Named("estoque")
@ViewScoped
public class EstoqueManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoEstoque gestaoEstoque;

	
	private Estoque estoque = new Estoque(); 
	private List<Estoque> estoques = new ArrayList<Estoque>(); 
	private MPrima materia;
	private Produto produto;
	
	
	public EstoqueManagedBean(){
		
		estoque = new Estoque();
		produto = new Produto();
		materia = new MPrima();
	}
	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public MPrima getMateria() {
		return materia;
	}

	public void setMateria(MPrima materia) {
		this.materia = materia;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void salvar() {
		
		//estoque.setMateriaPrima(materia);
		//estoque.setProduto(produto);
		gestaoEstoque.salvar(estoque);
		estoque = new Estoque();
		
		FacesMessage msg = new FacesMessage("Estoque salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoEstoque.excluir(estoque);
		estoque = new Estoque();
		
		FacesMessage msg = new FacesMessage("Estoque excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Estoque> getTodasEstoque() {
		
		List<Estoque> lista = new ArrayList<Estoque>();
		lista = gestaoEstoque.obeterTodos();
		estoques = lista;
		return lista;
	}
	
	

}
