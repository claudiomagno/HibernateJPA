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
import com.algaworks.comercial.service.GestaoEmpresa;
 

@Named("empresa")
@ViewScoped
public class EmpresaManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoEmpresa gestaoEmpresa;

	private String selectedCNPJ; 
	private Empresa empresa = new Empresa(); 
	private List<Empresa> empresas = new ArrayList<Empresa>(); 
	
	public EmpresaManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		empresa = new Empresa();
	}
	
	private void setMsg(String message) {  }

	
	public String getSelectedCNPJ() {
		return selectedCNPJ;
	}
	public void setSelectedCNPJ(String selectedCNPJ) {
		this.selectedCNPJ = selectedCNPJ;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	

	public void limparEmpresa() { 
		 this.empresa.setRazaoSocial(""); 
		 this.empresa.setCnpj(""); 
		 this.empresa.setComplemento(""); 
		 this.empresa.setLogradouro(""); 
		 this.empresa.setMunicipio(""); 
		 this.empresa.setUf(""); 
		 this.empresa.setNumero(null); 
	} 
	
	public void salvar() {
		gestaoEmpresa.salvar(empresa);
	    empresa = new Empresa();
		
		FacesMessage msg = new FacesMessage("Empresa salva com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoEmpresa.excluir(empresa);
	    empresa = new Empresa();
		
		FacesMessage msg = new FacesMessage("Empresa excluida com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Empresa> getTodasEmpresas() {
		
		List<Empresa> lista = new ArrayList<Empresa>();
		lista = gestaoEmpresa.obeterTodas();
		empresas = lista;
		return lista;
	}
	
	

	public void verificaCNPJ() {
		selectedCNPJ = empresa.getCnpj().toUpperCase();
    }
	
	 public void save() {
	        addMessage("Success", "Data saved");
	    }
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
