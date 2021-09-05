package com.compasso.carros.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.compasso.carros.modelo.Carro;

public interface CarroRepository extends PagingAndSortingRepository<Carro, String>, JpaSpecificationExecutor<Carro> {
	
	Collection<Carro> findAll();

	List<Carro> findByNome(String nomeCarro);

	List<Carro> findByMarca(String marca);

	List<Carro> findByCor(String cor);

}
