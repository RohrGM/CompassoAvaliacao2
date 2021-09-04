package com.compasso.estados.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.compasso.estados.controller.dto.EstadoDto;
import com.compasso.estados.controller.form.AtualizaEstadoForm;
import com.compasso.estados.controller.form.EstadoForm;
import com.compasso.estados.modelo.Estado;
import com.compasso.estados.repository.EstadoRepository;
import java.net.URI;

@RestController
@RequestMapping("/api/states")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	@GetMapping
	public List<EstadoDto> lista(){
		
		List<Estado> estados = estadoRepository.findAll(); 

		return EstadoDto.converter(estados);
	}
	
	@GetMapping(path="/regiao")
	public List<EstadoDto> listaNome(String regiao){
		
		List<Estado> estados = estadoRepository.findByRegiao(regiao); 

		return EstadoDto.converter(estados);
	}
	
	@GetMapping(path="/populacao")
	public List<EstadoDto> listaPopulacao(){
		
		List<Estado> estados = estadoRepository.findAll(); 
		estados.sort(Comparator.comparing(Estado::getPopulacao));

		return EstadoDto.converter(estados);
	}
	
	@GetMapping(path="/area")
	public List<EstadoDto> listaArea(){
		
		List<Estado> estados = estadoRepository.findAll(); 
		estados.sort(Comparator.comparing(Estado::getArea));

		return EstadoDto.converter(estados);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> detalhar(@PathVariable Long id) {
		Optional<Estado> optional = Optional.ofNullable(estadoRepository.findById(id));
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(new EstadoDto(optional.get()));
		}
		
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaEstadoForm form) {
		Optional<Estado> optional = Optional.ofNullable(estadoRepository.findById(id));
		
		if(optional.isPresent()) {
			Estado estado = form.atualizar(id, estadoRepository);	
			return ResponseEntity.ok(new EstadoDto(estado));
		}
		
		return ResponseEntity.notFound().build();

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Estado> optional = Optional.ofNullable(estadoRepository.findById(id));
		
		if(optional.isPresent()) {
			estadoRepository.deleteById(id);	
			return ResponseEntity.ok().build();	
		}		
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm estadoForm, UriComponentsBuilder uriBuilder) {
		
		Estado estado = estadoForm.converter(estadoForm);
		estadoRepository.save(estado);
		
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(estado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
	}
	
}