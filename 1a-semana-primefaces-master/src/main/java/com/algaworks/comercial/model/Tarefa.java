package com.algaworks.comercial.model;

// Generated 23/03/2016 10:12:00 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tarefa generated by hbm2java
 */
@Entity
@Table(name = "tarefa", catalog = "semana")
public class Tarefa implements java.io.Serializable {

	private Long id;
	private Date dataFinalizacao;
	private String descricao;
	private boolean finalizado;

	public Tarefa() {
	}

	public Tarefa(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Tarefa(Date dataFinalizacao, String descricao, boolean finalizado) {
		this.dataFinalizacao = dataFinalizacao;
		this.descricao = descricao;
		this.finalizado = finalizado;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "dataFinalizacao", length = 10)
	public Date getDataFinalizacao() {
		return this.dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "finalizado", nullable = false)
	public boolean isFinalizado() {
		return this.finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

}
