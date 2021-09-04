package com.compasso.estados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compasso.estados.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, String>{

	List<Estado> findByPopulacao(String populacao);

	List<Estado> findByArea(String area);

	List<Estado> findByRegiao(String regiao);

	Estado findById(Long id);

	void deleteById(Long id);

}
