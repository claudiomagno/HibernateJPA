package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.repository.FuncionarioRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioRepository funcionarios;
	
	@Transacional
	public void salvar(Funcionario funcionario) {
		funcionarios.guardar(funcionario);
	}
	
	@Transacional
	public List<Funcionario> obeterTodos() {
		List<Funcionario> lista = null;
		
		try {
			lista = funcionarios.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<Funcionario> getFuncionarioes() {
			
		return funcionarios.getFuncionarioes();
	}
	
	
	@Transacional
	public void excluir(Funcionario  funcionario){
		funcionarios.excluir(funcionario);
	}

}