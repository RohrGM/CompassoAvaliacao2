package com.compasso.estados.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.compasso.estados.modelo.EstadoRegiao;
import com.compasso.estados.validacao.constraints.RegiaoValida;

public class RegiaoValidation implements ConstraintValidator<RegiaoValida, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(StringUtils.hasText(value)) {
			EstadoRegiao regioes = new EstadoRegiao();
			return regioes.getRegioes().contains(value);
		}
		
		return true;
	}
}
