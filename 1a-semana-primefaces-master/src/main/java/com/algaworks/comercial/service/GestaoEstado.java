package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.repository.EmpresaRepository;
import com.algaworks.comercial.repository.EstadoRepository;
import com.algaworks.comercial.repository.OrcamentosRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoEstado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoRepository estados;
	
	@Transacional
	public void salvar(Estado estado) {
		estados.guardar(estado);
	}
	
	
	public List<Estado> obeterTodas() {
		List<Estado> lista = null;
		
		try {
			lista = estados.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	

	
	@Transacional
	public Estado getUF(String uf) {
		return estados.getUF(uf);
	}
	
	@Transacional
	public void excluir(Estado  estado){
		estados.excluir(estado);
	}

}