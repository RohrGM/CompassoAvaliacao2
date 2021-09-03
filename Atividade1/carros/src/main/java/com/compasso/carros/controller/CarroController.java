package com.compasso.carros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.carros.controller.dto.CarroDto;
import com.compasso.carros.controller.form.CarroForm;
import com.compasso.carros.modelo.Carro;
import com.compasso.carros.repository.CarroRepository;

import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping
	public List<CarroDto> listaOdem(String ordem){
		
		List<Carro> carros = carroRepository.findAll(); 

		switch (ordem) {
		case "nome":
			Collections.sort(carros);
			break;
		case "ano":
			carros.sort(Comparator.comparing(Carro::getAno));
			break;
		case "valor":
			carros.sort(Comparator.comparing(Carro::getValor));
			break;
		}

		return CarroDto.converter(carros);
	}
	
	@GetMapping(path="/")
	public List<CarroDto> lista(){
		
		List<Carro> carros = carroRepository.findAll(); 
		return CarroDto.converter(carros);
	}
	
	@GetMapping(path="/nome")
	public List<CarroDto> listaPorNome(String nome){
		List<Carro> carros = carroRepository.findByNome(nome);
		return CarroDto.converter(carros);
	}
	
	@GetMapping(path="/marca")
	public List<CarroDto> listaPorMarca(String marca){
		List<Carro> carros = carroRepository.findByMarca(marca); 
		return CarroDto.converter(carros);
	}
	
	@GetMapping(path="/cor")
	public List<CarroDto> listaPorCor(String cor){
		List<Carro> carros = carroRepository.findByCor(cor); 
		return CarroDto.converter(carros);
	}	
	
	@PostMapping
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		Carro carro = carroForm.converter(carroForm);
		carroRepository.save(carro);
		
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(carro.getChassi()).toUri();
		
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}
}