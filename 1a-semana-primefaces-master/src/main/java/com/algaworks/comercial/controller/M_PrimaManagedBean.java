package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.model.TipoMovimento;
import com.algaworks.comercial.service.GestaoEmpresa;
import com.algaworks.comercial.service.GestaoEstoque;
import com.algaworks.comercial.service.GestaoM_Prima;
import com.algaworks.comercial.util.Transacional;
 

@Named("mprima")
@ViewScoped
public class M_PrimaManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoM_Prima gestaoM_Prima;


	private Estoque estoque = new Estoque();
	private MPrima mprima = new MPrima(); 
	private List<MPrima> mprimas = new ArrayList<MPrima>(); 
	
	
	public M_PrimaManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		mprima = new MPrima();
	}
			
	public MPrima getMprima() {
		return mprima;
	}

	public void setMprima(MPrima mprima) {
		this.mprima = mprima;
	}

	public List<MPrima> getMprimas() {
		return mprimas;
	}

	public void setMprimas(List<MPrima> mprimas) {
		this.mprimas = mprimas;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public void salvar() {
		
		estoque.setDataInicial(new Date());
		estoque.setQtdMovimentada(mprima.getQtdMaxima());
		
		
		
		if(estoque.getTipoMovimento()!= null){
			Estoque est = gestaoM_Prima.getEstoqueMPrima(mprima);
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
			estoque.setQtdSaldo(1);
			
			//mprima.getEstoues().add(estoque);
		}

		//estoque.setMateriaPrima(mprima);
		gestaoM_Prima.salvar(mprima);
		mprima = new MPrima();
		
		FacesMessage msg = new FacesMessage("M_Prima salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoM_Prima.excluir(mprima);
		mprima = new MPrima();
		
		FacesMessage msg = new FacesMessage("M_Prima excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<MPrima> getTodasM_Prima() {
		
		List<MPrima> lista = new ArrayList<MPrima>();
		lista = gestaoM_Prima.obeterTodos();
		mprimas = lista;
		return lista;
	}
	
	
}
