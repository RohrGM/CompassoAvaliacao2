package com.compasso.estados.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compasso.estados.modelo.Estado;

public interface EstadoRepository extends PagingAndSortingRepository<Estado, String>, JpaSpecificationExecutor<Estado> {

	Estado findById(Long id);

	void deleteById(Long id);

}
