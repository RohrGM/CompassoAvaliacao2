package com.compasso.estados.controller.form;

import javax.validation.constraints.NotNull;

import com.compasso.estados.modelo.Estado;
import com.compasso.estados.repository.EstadoRepository;

public class AtualizaEstadoForm {
	
	@NotNull
	private long populacao;
	@NotNull
	private double area;	
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
	
	public Estado atualizar(Long id, EstadoRepository estadoRepository) {

		Estado estado = estadoRepository.findById(id);
		estado.setPopulacao(this.populacao);
		estado.setArea(this.area);
		
		return estado;
	}
}
