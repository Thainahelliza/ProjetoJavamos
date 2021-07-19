package com.javamos.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javamos.projeto.model.Conta;
import com.javamos.projeto.repo.ContaRepo;

@RestController

public class ContaController {
	@Autowired
	private ContaRepo repo;

	@GetMapping("/contas")
	public java.util.List<Conta> recuperarTudo() {
		return (java.util.List<Conta>) repo.findAll();
	}
	
	@GetMapping("/conta/{codigo}")
	public ResponseEntity<Conta> show(@PathVariable int codigo){
		var conta = repo.findById(codigo).orElse(null);
		return ResponseEntity.ok(conta);
	}

}
