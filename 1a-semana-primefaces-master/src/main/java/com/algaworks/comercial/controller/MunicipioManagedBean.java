package com.algaworks.comercial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartType;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.model.Municipio;
import com.algaworks.comercial.service.GestaoEmpresa;
import com.algaworks.comercial.service.GestaoEstado;
import com.algaworks.comercial.service.GestaoMunicipio;
 


@Named("municipio")
@ViewScoped
public class MunicipioManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestaoMunicipio gestaoMunicipio;

	
	private Municipio municipio = new Municipio(); 
	private List<Municipio> municipios = new ArrayList<Municipio>(); 
	private Estado estado;
	private List<Municipio> filtros; 
		
	public MunicipioManagedBean(){
		
		//empresas = gestaoEmpresa.obeterTodas();
		municipio = new Municipio();
		estado = new Estado();
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

	public List<Municipio> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<Municipio> filtros) {
		this.filtros = filtros;
	}

	public void salvar() {
		municipio.setEstado(estado);
		gestaoMunicipio.salvar(municipio);
		municipio = new Municipio();
		
		FacesMessage msg = new FacesMessage("Municipio salvo com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void excluir() {
		gestaoMunicipio.excluir(municipio);
		municipio = new Municipio();
		
		FacesMessage msg = new FacesMessage("Municipio excluido com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Municipio> getTodosMunicipios() {
		
		List<Municipio> lista = new ArrayList<Municipio>();
		lista = gestaoMunicipio.obeterTodas();
		municipios = lista;
		return lista;
	}
	
	
	
	public void getMunicipiosEstado() {	
		
		List<Municipio> lista = new ArrayList<Municipio>();
		lista =  gestaoMunicipio.getMunicipiosEstado(estado);
		municipios = lista;
	}
	
	public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
 
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }
	
	private GChartModel chartModel = null;  
	  
    public GChartModel getChart(){ 
    	generateModel();
        return chartModel;  
    }  
  
    //@PostConstruct  
    public void generateModel() {  
        chartModel = new GChartModelBuilder().setChartType(GChartType.COLUMN)  
                .addColumns("Ano", "Orçados","Efetivados")  
                .addRow("2010",  1000, 400)  
                .addRow("2011",  1200, 800)  
                .addRow("2012",  2000, 1800)  
                .addRow("2013",  1500, 1800)  
                .addRow("2014",  1300, 1000)  
                .build();  
    }  
}
