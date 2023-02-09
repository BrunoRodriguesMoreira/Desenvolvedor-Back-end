package com.API.pessoa.repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.API.pessoa.model.Endereco;
import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.EnderecoRepository;
import com.API.pessoa.repositories.PessoaRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@BeforeAll
	void start() {
	 enderecoRepository.save(new Endereco(0L,false , "Rudas das Flores",12345678,11,"São paulo"));
	}
		
	
	@Test
	@DisplayName("Retorna 1 endereco")
	@Order(1)
	public void deveRetornarUmaPessoa() {
    	Optional<Endereco> endereco = enderecoRepository.findByCidade("São paulo");
    	assertTrue(endereco.get().getCidade().equals("São paulo"));
	}

	
	
	

}