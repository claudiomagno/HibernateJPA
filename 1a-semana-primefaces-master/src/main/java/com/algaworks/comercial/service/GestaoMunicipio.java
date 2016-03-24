package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.model.Municipio;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.repository.EmpresaRepository;
import com.algaworks.comercial.repository.EstadoRepository;
import com.algaworks.comercial.repository.MunicipioRepository;
import com.algaworks.comercial.repository.OrcamentosRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoMunicipio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MunicipioRepository municipios;
	
	@Transacional
	public void salvar(Municipio municipio) {
		municipios.guardar(municipio);
	}
	
	@Transacional
	public List<Municipio> obeterTodas() {
		return municipios.todos();
	}
	

	
	@Transacional
	public List<Municipio> getMunicipiosEstado(Estado estado) {			
		return municipios.getMunicipiosEstado(estado);
	}
	
	@Transacional
	public void excluir(Municipio  estado){
		municipios.excluir(estado);
	}

}