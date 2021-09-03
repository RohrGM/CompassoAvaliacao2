package com.compasso.carros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compasso.carros.modelo.Carro;

public interface CarroRepository extends JpaRepository<Carro, String> {

	List<Carro> findByNome(String nomeCarro);

	List<Carro> findByMarca(String marca);

	List<Carro> findByCor(String cor);

}
