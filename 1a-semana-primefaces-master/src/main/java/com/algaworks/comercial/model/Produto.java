package com.algaworks.comercial.model;

// Generated 23/03/2016 10:12:00 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name = "produto", catalog = "semana")
public class Produto implements java.io.Serializable {

	private Long id;
	private Empresax empresax;
	private String descricao;
	private String modelo;
	private double precoCompra;
	private double precoVenda;
	private int qtdMaxima;
	private int qtdMinima;
	private int saldoAtual;
	private String status;
	private Set<Venda> vendas = new HashSet<Venda>(0);
	private Set<EstoqueProduto> estoqueProdutos = new HashSet<EstoqueProduto>(0);
	private Set<Producao> producaos = new HashSet<Producao>(0);
	private Set<MPrima> MPrimas = new HashSet<MPrima>(0);

	public Produto() {
	}

	public Produto(double precoCompra, double precoVenda, int qtdMaxima,
			int qtdMinima, int saldoAtual) {
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.qtdMaxima = qtdMaxima;
		this.qtdMinima = qtdMinima;
		this.saldoAtual = saldoAtual;
	}

	public Produto(Empresax empresax, String descricao, String modelo,
			double precoCompra, double precoVenda, int qtdMaxima,
			int qtdMinima, int saldoAtual, String status, Set<Venda> vendas,
			Set<EstoqueProduto> estoqueProdutos, Set<Producao> producaos,
			Set<MPrima> MPrimas) {
		this.empresax = empresax;
		this.descricao = descricao;
		this.modelo = modelo;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.qtdMaxima = qtdMaxima;
		this.qtdMinima = qtdMinima;
		this.saldoAtual = saldoAtual;
		this.status = status;
		this.vendas = vendas;
		this.estoqueProdutos = estoqueProdutos;
		this.producaos = producaos;
		this.MPrimas = MPrimas;
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
	@JoinColumn(name = "empresax_id")
	public Empresax getEmpresax() {
		return this.empresax;
	}

	public void setEmpresax(Empresax empresax) {
		this.empresax = empresax;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "modelo")
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "preco_compra", nullable = false, precision = 22, scale = 0)
	public double getPrecoCompra() {
		return this.precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	@Column(name = "preco_venda", nullable = false, precision = 22, scale = 0)
	public double getPrecoVenda() {
		return this.precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Column(name = "qtd_maxima", nullable = false)
	public int getQtdMaxima() {
		return this.qtdMaxima;
	}

	public void setQtdMaxima(int qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}

	@Column(name = "qtd_minima", nullable = false)
	public int getQtdMinima() {
		return this.qtdMinima;
	}

	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	@Column(name = "saldo_atual", nullable = false)
	public int getSaldoAtual() {
		return this.saldoAtual;
	}

	public void setSaldoAtual(int saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<EstoqueProduto> getEstoqueProdutos() {
		return this.estoqueProdutos;
	}

	public void setEstoqueProdutos(Set<EstoqueProduto> estoqueProdutos) {
		this.estoqueProdutos = estoqueProdutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<Producao> getProducaos() {
		return this.producaos;
	}

	public void setProducaos(Set<Producao> producaos) {
		this.producaos = producaos;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "m_prima_produto", catalog = "semana", joinColumns = { @JoinColumn(name = "produto_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "m_prima_id", nullable = false, updatable = false) })
	public Set<MPrima> getMPrimas() {
		return this.MPrimas;
	}

	public void setMPrimas(Set<MPrima> MPrimas) {
		this.MPrimas = MPrimas;
	}

}