package com.compasso.estados.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.compasso.estados.modelo.Estado;
import com.compasso.estados.validacao.constraints.RegiaoValida;


public class BuscaEstadoForm {
	
	@RegiaoValida
	private String regiao;

	public BuscaEstadoForm(String regiao, String maiores) {
		this.regiao = regiao;
	}
	
	public Specification<Estado> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(regiao)) {
				Path<String> campoRegiao = root.<String>get("regiao");
				Predicate predicadoRegiao = builder.equal(campoRegiao, regiao);
				predicados.add(predicadoRegiao);
			}			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}
