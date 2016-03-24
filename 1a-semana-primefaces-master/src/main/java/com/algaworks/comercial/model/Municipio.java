package com.algaworks.comercial.model;

// Generated 23/03/2016 10:12:00 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Municipio generated by hbm2java
 */
@Entity
@Table(name = "municipio", catalog = "semana")
@NamedQueries({
	@NamedQuery(name="Municipio.findDescricao", 
			query="select d from Municipio d where d.estado = :estado")
})
public class Municipio implements java.io.Serializable {

	private Long id;
	private Estado estado;
	private String descricao;
	private String status;
	
	
	public static final String FIND_DESCRICAO= "Municipio.findDescricao";


	public Municipio() {
	}

	public Municipio(Estado estado, String descricao, String status) {
		this.estado = estado;
		this.descricao = descricao;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_uf")
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}