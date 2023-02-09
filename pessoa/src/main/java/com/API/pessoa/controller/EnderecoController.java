package com.API.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.API.pessoa.model.Endereco;
import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.EnderecoRepository;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository ;
	
     
	@GetMapping
	public ResponseEntity<List<Endereco>>getAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Endereco> post( @RequestBody Endereco endereco){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
		
	}
	
	

}
