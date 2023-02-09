package com.API.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.PessoaRepository;
import com.API.pessoa.services.PessoaService;


@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
    @Autowired
    private PessoaService service;
    
    @Autowired
    private PessoaRepository repository;
    
    @GetMapping
	public List<Pessoa> findPessoas(){
		
		return service.findPessoas();
	}
    
    
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Pessoa>>getByName (@PathVariable String nome ){
    	
    	return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));	
    }
    
	
    
    
    @PostMapping
    public ResponseEntity<Pessoa>post(@RequestBody Pessoa pessoa){
    		
    	  return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));	
    }
    
    
    
    @PutMapping
    public ResponseEntity<Pessoa>put(@RequestBody Pessoa pessoa){
    		
    	  return ResponseEntity.status(HttpStatus.OK).body(repository.save(pessoa));
    }	
    
    
}
