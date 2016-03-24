package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.comercial.model.Empresax;
import com.algaworks.comercial.service.GestaoEmpresax;

 

@Named("empresax")
@ViewScoped
public class EmpresaxManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoEmpresax gestaoEmpresax;

	private Empresax empresax = new Empresax(); 
	private List<Empresax> empresaxs = new ArrayList<Empresax>(); 
	
	
	public EmpresaxManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		empresax = new Empresax();
	}

	public Empresax getEmpresax() {
		return empresax;
	}

	public void setEmpresax(Empresax empresax) {
		this.empresax = empresax;
	}

	public List<Empresax> getEmpresaxs() {
		return empresaxs;
	}

	public void setEmpresaxs(List<Empresax> empresaxs) {
		this.empresaxs = empresaxs;
	}

	public void salvar() {
		gestaoEmpresax.salvar(empresax);
		empresax = new Empresax();
		
		FacesMessage msg = new FacesMessage("Empresax salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoEmpresax.excluir(empresax);
		empresax = new Empresax();
		
		FacesMessage msg = new FacesMessage("Empresax excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Empresax> getTodasEmpresax() {
		
		List<Empresax> lista = new ArrayList<Empresax>();
		lista = gestaoEmpresax.obeterTodos();
		empresaxs = lista;
		return lista;
	}
	
	
}
