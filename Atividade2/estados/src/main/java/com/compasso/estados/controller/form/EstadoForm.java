package com.compasso.estados.controller.form;

import javax.validation.constraints.NotBlank;
import com.compasso.estados.modelo.Estado;
import com.compasso.estados.modelo.EstadoRegiao;

public class EstadoForm {
	
	private long populacao;
	private double area;
	@NotBlank
	private String nome;
	private EstadoRegiao regiao;
	private String capital;

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setRegiao(EstadoRegiao regiao) {
		this.regiao = regiao;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Estado converter(EstadoForm estadoForm) {
		return new Estado(populacao, area, nome, regiao, capital);
	}

}
