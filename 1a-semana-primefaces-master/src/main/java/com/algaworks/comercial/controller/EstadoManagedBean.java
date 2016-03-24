package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.service.GestaoEmpresa;
import com.algaworks.comercial.service.GestaoEstado;
 

@Named("estado")
@ViewScoped
public class EstadoManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoEstado gestaoEstado;

	
	private Estado estado = new Estado(); 
	private List<Estado> estados = new ArrayList<Estado>(); 
	
	public EstadoManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		estado = new Estado();
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void salvar() {
		gestaoEstado.salvar(estado);
		estado = new Estado();
		
		FacesMessage msg = new FacesMessage("Estado salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoEstado.excluir(estado);
		estado = new Estado();
		
		FacesMessage msg = new FacesMessage("Estado excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Estado> getTodasEstado() {
		
		List<Estado> lista = new ArrayList<Estado>();
		lista = gestaoEstado.obeterTodas();
		estados = lista;
		return lista;
	}
	
	

}
