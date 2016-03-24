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
 * Producao generated by hbm2java
 */
@Entity
@Table(name = "producao", catalog = "semana")
public class Producao implements java.io.Serializable {

	private Long id;
	private ConsumoProducao consumoProducao;
	private Produto produto;
	private TempoProducao tempoProducao;
	private String descricao;
	private boolean moi;
	private int quantidade;

	public Producao() {
	}

	public Producao(boolean moi, int quantidade) {
		this.moi = moi;
		this.quantidade = quantidade;
	}

	public Producao(ConsumoProducao consumoProducao, Produto produto,
			TempoProducao tempoProducao, String descricao, boolean moi,
			int quantidade) {
		this.consumoProducao = consumoProducao;
		this.produto = produto;
		this.tempoProducao = tempoProducao;
		this.descricao = descricao;
		this.moi = moi;
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
	@JoinColumn(name = "consumo_producao_id")
	public ConsumoProducao getConsumoProducao() {
		return this.consumoProducao;
	}

	public void setConsumoProducao(ConsumoProducao consumoProducao) {
		this.consumoProducao = consumoProducao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id")
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tempo_producao_id")
	public TempoProducao getTempoProducao() {
		return this.tempoProducao;
	}

	public void setTempoProducao(TempoProducao tempoProducao) {
		this.tempoProducao = tempoProducao;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "moi", nullable = false)
	public boolean isMoi() {
		return this.moi;
	}

	public void setMoi(boolean moi) {
		this.moi = moi;
	}

	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}