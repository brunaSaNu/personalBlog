package com.brusanu.personalblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brusanu.personalblog.model.Tema;
import com.brusanu.personalblog.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable Long id){
		return temaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByTitle(@PathVariable String descricao){
		return ResponseEntity.ok(temaRepository
				.findAllByDescricaoContainingIgnoreCase(descricao));
	}
}
