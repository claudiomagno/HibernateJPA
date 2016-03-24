package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.comercial.model.Aquisicao;
import com.algaworks.comercial.model.Estoque;
import com.algaworks.comercial.model.Funcionario;
import com.algaworks.comercial.model.MPrima;


public class M_PrimaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public MPrima guardar(MPrima m_prima) {
		return manager.merge(m_prima);
	}
	
	public List<MPrima> todos() {
		List<MPrima> m_primas = null;	
		
		try {
			m_primas = manager.createQuery("from MPrima", MPrima.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return m_primas;
	}

	public void excluir(MPrima m_prima){
		MPrima est = manager.find(MPrima.class, m_prima.getId());
		manager.remove(est);
	}
	
	
	public List<MPrima> getMPrimaes() {
		List<MPrima> m_primaes = null;	
		
		try {
			m_primaes = manager.createQuery("from MPrima", MPrima.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return m_primaes;
	}
	
	public Estoque getEstoqueMPrima(MPrima m_prima){
		
		Estoque est = new Estoque();
		
		return est = manager.find(Estoque.class, m_prima.getId());
		
	}
	
	
}