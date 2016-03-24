package com.algaworks.comercial.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.algaworks.comercial.model.Empresa;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;

public class EmpresaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public List<Empresa> todos() {
		List<Empresa> empresas = new ArrayList<Empresa>();	
		empresas = manager.createQuery("from Empresa", Empresa.class).getResultList();
		
		return empresas;
	}

	public void excluir(Empresa empresa){
		Empresa empr = manager.find(Empresa.class, empresa.getId());
		manager.remove(empr);
	}
	
	
//	public Empresa getEmpresaCpf(String cnpj) {
//		
//		Query query = manager.createNamedQuery(Empresa.FIND_CNPJ);
//		query.setParameter("CNPJ", cnpj);
//		
//		return (Empresa) query.getSingleResult();
//	}
//
//	public List<Matriz> todasMatrizes(){
//		return manager.createQuery("from Matriz", Matriz.class).getResultList();
//	}


}