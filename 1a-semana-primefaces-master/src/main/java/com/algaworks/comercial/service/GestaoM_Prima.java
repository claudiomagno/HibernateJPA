package com.algaworks.comercial.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.MPrima;
import com.algaworks.comercial.repository.M_PrimaRepository;
import com.algaworks.comercial.util.Transacional;

public class GestaoM_Prima implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private M_PrimaRepository m_primas;
	
	@Transacional
	public void salvar(MPrima m_prima) {
		m_primas.guardar(m_prima);
	}
	
	@Transacional
	public List<MPrima> obeterTodos() {
		List<MPrima> lista = null;
		
		try {
			lista = m_primas.todos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	@Transacional
	public List<MPrima> getMPrimaes() {
			
		return m_primas.getMPrimaes();
	}
	
	
	@Transacional
	public void excluir(MPrima  m_prima){
		m_primas.excluir(m_prima);
	}
	
	@Transacional
	public Estoque getEstoqueMPrima(MPrima m_prima){
		
		return m_primas.getEstoqueMPrima(m_prima);
		
	}

}