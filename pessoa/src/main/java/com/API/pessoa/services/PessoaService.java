package com.API.pessoa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> findPessoas(){
		
		return repository.findAll();
		
	}
}
