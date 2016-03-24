package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Empresax;
import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.MPrima;
import com.algaworks.comercial.model.Produto;
import com.algaworks.comercial.model.TipoMovimento;
import com.algaworks.comercial.service.GestaoEstoque;
import com.algaworks.comercial.service.GestaoProduto;

 

@Named("produto")
@ViewScoped
public class ProdutoManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoProduto gestaoProduto;
	@Inject
	private GestaoEstoque gestaoEstoque;


	private Estoque estoque = new Estoque(); 
	
	private Produto produto = new Produto(); 
	
	private List<Produto> produtos = new ArrayList<Produto>(); 
	private Empresax empresax = new Empresax();
	private Set<MPrima> mprimas = new HashSet<MPrima>(); 
	private Long[] materiaSelecionadas;
	
	
	public ProdutoManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		produto = new Produto();
		empresax = new Empresax();
		
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	

	public Empresax getEmpresax() {
		return empresax;
	}

	public void setEmpresax(Empresax empresax) {
		this.empresax = empresax;
	}
	

	public Set<MPrima> getMprimas() {
		return mprimas;
	}

	public void setMprimas(Set<MPrima> mprimas) {
		this.mprimas = mprimas;
	}

	public Long[] getMateriaSelecionadas() {
		return materiaSelecionadas;
	}

	public void setMateriaSelecionadas(Long[] materiaSelecionadas) {
		this.materiaSelecionadas = materiaSelecionadas;
	}

	public void salvar() {
		
		Set<MPrima> lista = new HashSet<MPrima>();
		
		for (int i = 0; i < materiaSelecionadas.length; i++) {
			MPrima materia = new MPrima();
			materia.setId(materiaSelecionadas[i]);
			lista.add(materia);
		}
		
		int contQtd =0;
		
		for (Produto pro : produtos) {
			contQtd += pro.getQtdMaxima();
		}
		
		//estoque minimo
		
		
		estoque.setDataInicial(new Date());
		//estoque.setQtd_Movimentada(produto.getQtd_maxima());
		if(gestaoEstoque.getEstoquees() != null)
			estoque.setQtdMovimentada(gestaoEstoque.getEstoquees().size());
		produto.setQtdMinima(3);

		if(estoque.getTipoMovimento()!= null){
			Estoque est = gestaoProduto.getEstoqueMPrima(produto);
			//alterar
			if(estoque.getTipoMovimento().equals(TipoMovimento.SAIDA)){			
				estoque.setQtdSaldo(est.getQtdSaldo()- 1);
				estoque.setDataFinalizacao(new Date());
			}else{
				estoque.setQtdSaldo(est.getQtdSaldo()+ 1);
			}
			estoque.setId(est.getId());
		}else{
			//incluir
			estoque.setTipoMovimento(TipoMovimento.ENTRADA);
			if(contQtd > 0)
				estoque.setQtdSaldo(contQtd);
			else
				estoque.setQtdSaldo(1);
			
			//produto.getEstoqueProdutos().add(estoque);
		}
		
		produto.setPrecoCompra(2);
		
		estoque.setValor(produto.getPrecoCompra() * produto.getQtdMaxima());
		produto.setStatus("A");
		produto.setMPrimas(mprimas);
		produto.setEmpresax(empresax);
		//estoque.setProduto(produto);
		
		gestaoProduto.salvar(produto);
		
		produto = new Produto();
		estoque = new Estoque();
		
		FacesMessage msg = new FacesMessage("Produto salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoProduto.excluir(produto);
		produto = new Produto();
		
		FacesMessage msg = new FacesMessage("Produto excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Produto> getTodasProduto() {
		
		List<Produto> lista = new ArrayList<Produto>();
		lista = gestaoProduto.obeterTodos();
		produtos = lista;
		return lista;
	}
	
	
}
