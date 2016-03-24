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
import com.algaworks.comercial.model.Estado;
import com.algaworks.comercial.model.Municipio;
import com.algaworks.comercial.model.Orcamento;
import com.algaworks.comercial.model.OrcamentoItem;

public class MunicipioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
		
	public Municipio guardar(Municipio municipio) {
		return manager.merge(municipio);
	}
	
	public List<Municipio> todos() {
		List<Municipio> municipios = new ArrayList<Municipio>();	
		municipios = manager.createQuery("from Municipio", Municipio.class).getResultList();
		
		return municipios;
	}

	public void excluir(Municipio municipio){
		Municipio empr = manager.find(Municipio.class, municipio.getId());
		manager.remove(empr);
	}
	
	
	public List<Municipio> getMunicipiosEstado(Estado estado) {
		
		Query query = manager.createNamedQuery(Municipio.FIND_DESCRICAO);
		query.setParameter("estado", estado);
		
		return query.getResultList();
	}



}