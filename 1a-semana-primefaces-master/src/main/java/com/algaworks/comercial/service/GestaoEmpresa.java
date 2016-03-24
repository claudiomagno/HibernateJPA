package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;
import com.algaworks.comercial.repository.EmpresaRepository;
import com.algaworks.comercial.repository.OrcamentosRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transacional
	public List<Empresa> obeterTodas() {
		return empresas.todos();
	}
	
//	@Transacional
//	public List<Matriz> obeterMatrizes() {
//		return empresas.todasMatrizes();
//	}
//	
//	@Transacional
//	public Empresa getEmpresaCpf(String cnpj) {
//		return empresas.getEmpresaCpf(cnpj);
//	}
//	
	@Transacional
	public void excluir(Empresa empresa){
		empresas.excluir(empresa);
	}

}