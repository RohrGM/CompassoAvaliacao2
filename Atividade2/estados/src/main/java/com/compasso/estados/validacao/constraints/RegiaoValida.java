package com.compasso.estados.validacao.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.compasso.estados.validacao.RegiaoValidation;

@Documented
@Constraint(validatedBy = RegiaoValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface RegiaoValida {

	String message() default "Regiao invalida";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};	
}
