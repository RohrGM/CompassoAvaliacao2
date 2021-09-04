package com.compasso.estados.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.compasso.estados.modelo.Estado;
import com.compasso.estados.modelo.EstadoRegiao;

public class EstadoDto {
	
	private long populacao;
	private double area;
	private String nome;
	private EstadoRegiao regiao;
	private String capital;
	
	
	public EstadoDto(Estado estado) {
		this.nome = estado.getNome(); 
		this.area = estado.getArea();
		this.regiao = estado.getRegiao();
		this.capital = estado.getCapital();
		this.populacao = estado.getPopulacao();
	}
	
	public static List<EstadoDto> converter (List<Estado> estados){
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

	public long getPopulacao() {
		return populacao;
	}

	public double getArea() {
		return area;
	}

	public String getNome() {
		return nome;
	}

	public EstadoRegiao getRegiao() {
		return regiao;
	}

	public String getCapital() {
		return capital;
	}	
}
