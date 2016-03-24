package com.algaworks.comercial.model;

// Generated 23/03/2016 10:12:00 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Unidade generated by hbm2java
 */
@Entity
@Table(name = "unidade", catalog = "semana")
public class Unidade implements java.io.Serializable {

	private Long id;
	private Estoque estoque;
	private String descricao;
	private int quantidade;

	public Unidade() {
	}

	public Unidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Unidade(Estoque estoque, String descricao, int quantidade) {
		this.estoque = estoque;
		this.descricao = descricao;
		this.quantidade = quantidade;
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
	@JoinColumn(name = "estoque_id")
	public Estoque getEstoque() {
		return this.estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
