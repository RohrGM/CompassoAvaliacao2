package com.compasso.estados.modelo;

import java.util.Arrays;
import java.util.Collection;

public class EstadoRegiao {

	private static Collection<String> regioes = Arrays.asList("norte", "nordeste", "sul", "sudeste", "centro-oeste");
	
	
	public Collection<String> getRegioes() {
		return regioes;
	}
}
