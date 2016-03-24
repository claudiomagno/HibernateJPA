package com.algaworks.comercial.model;

public enum TipoMovimento {

	ENTRADA("Entrada"),
	SAIDA("Saída");
	
	private String descricao;

	TipoMovimento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}