package com.brusanu.personalblog.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.brusanu.personalblog.model.Tema;
import com.brusanu.personalblog.repository.TemaRepository;

public class TemaController {
	
	private TemaRepository temaRepository;
	
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}

}
