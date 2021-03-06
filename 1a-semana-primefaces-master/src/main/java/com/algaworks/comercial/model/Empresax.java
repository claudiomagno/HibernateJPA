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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Empresax generated by hbm2java
 */
@Entity
@Table(name = "empresax", catalog = "semana")
public class Empresax implements java.io.Serializable {

	private Long id;
	private String cnpj;
	private String nome;
	private Set<Setor> setors = new HashSet<Setor>(0);
	private Set<Produto> produtos = new HashSet<Produto>(0);
	private Set<Funcionario> funcionarios = new HashSet<Funcionario>(0);

	public Empresax() {
	}

	public Empresax(String cnpj, String nome, Set<Setor> setors,
			Set<Produto> produtos, Set<Funcionario> funcionarios) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.setors = setors;
		this.produtos = produtos;
		this.funcionarios = funcionarios;
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

	@Column(name = "cnpj")
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresax")
	public Set<Setor> getSetors() {
		return this.setors;
	}

	public void setSetors(Set<Setor> setors) {
		this.setors = setors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresax")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresax")
	public Set<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
