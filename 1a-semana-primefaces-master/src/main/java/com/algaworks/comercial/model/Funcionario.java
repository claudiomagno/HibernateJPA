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
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name = "funcionario", catalog = "semana")
public class Funcionario implements java.io.Serializable {

	private Long id;
	private Empresax empresax;
	private Setor setor;
	private String cpf;
	private String nome;

	public Funcionario() {
	}

	public Funcionario(Empresax empresax, Setor setor, String cpf, String nome) {
		this.empresax = empresax;
		this.setor = setor;
		this.cpf = cpf;
		this.nome = nome;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "setor_id")
	public Setor getSetor() {
		return this.setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Column(name = "cpf")
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
