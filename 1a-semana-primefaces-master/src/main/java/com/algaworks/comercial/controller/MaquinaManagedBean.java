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
import com.algaworks.comercial.model.Maquina;
import com.algaworks.comercial.model.Setor;
import com.algaworks.comercial.model.TipoMaquina;
import com.algaworks.comercial.service.GestaoEmpresa;
import com.algaworks.comercial.service.GestaoMaquina;
import com.algaworks.comercial.util.Transacional;
 

@Named("maquina")
@ViewScoped
public class MaquinaManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoMaquina gestaoMaquina;

	
	private Maquina maquina = new Maquina(); 
	private List<Maquina> maquinas = new ArrayList<Maquina>(); 
	private List<Setor> setores;
	private List<Aquisicao> aquisicoes;
	private List<TipoMaquina> tipos;
	private TipoMaquina tipo;
	
	public MaquinaManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		maquina = new Maquina();
		tipo = new TipoMaquina();
	}
	
	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public List<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public List<Aquisicao> getAquisicoes() {
		return aquisicoes;
	}

	public void setAquisicoes(List<Aquisicao> aquisicoes) {
		this.aquisicoes = aquisicoes;
	}

	public List<TipoMaquina> getTipos() {
		return tipos;
	}

	public void setTipos(List<TipoMaquina> tipos) {
		this.tipos = tipos;
	}
	

	public TipoMaquina getTipo() {
		return tipo;
	}

	public void setTipo(TipoMaquina tipo) {
		this.tipo = tipo;
	}

	public void salvar() {
		maquina.setTipoMaquina(tipo);
		gestaoMaquina.salvar(maquina);
		maquina = new Maquina();
		
		FacesMessage msg = new FacesMessage("Maquina salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoMaquina.excluir(maquina);
		maquina = new Maquina();
		
		FacesMessage msg = new FacesMessage("Maquina excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Maquina> getTodasMaquina() {
		
		List<Maquina> lista = new ArrayList<Maquina>();
		lista = gestaoMaquina.obeterTodos();
		maquinas = lista;
		return lista;
	}
	
	public List<Setor> getTodosSetores() {
		
		List<Setor> lista = new ArrayList<Setor>();
		lista = gestaoMaquina.getSetores();
		return lista;
	}
	

	public List<TipoMaquina> getTodosTipos() {
	
		return gestaoMaquina.getTipos();
	}

	
	public List<Aquisicao> getTodasAquisicoes() {
	
		return gestaoMaquina.getAquisicoes();
	}

}
