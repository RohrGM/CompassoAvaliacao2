package com.compasso.estados.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado implements Comparable<Estado>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long populacao;
	private double area;
	private String nome;
	@Enumerated(EnumType.STRING)
	private EstadoRegiao regiao;
	private String capital;
	
	public Estado(long populacao, double area, String nome, EstadoRegiao regiao, String capital) {
		this.populacao = populacao;
		this.area = area;
		this.nome = nome;
		this.regiao = regiao;
		this.capital = capital;
	}
	public Estado(){}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public EstadoRegiao getRegiao() {
		return regiao;
	}
	public void setRegiao(EstadoRegiao regiao) {
		this.regiao = regiao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public int compareTo(Estado estado) {
		return this.nome.compareTo(estado.getNome());	
	}
}
