package com.API.pessoa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.API.pessoa.model.Endereco;
import com.API.pessoa.repositories.EnderecoRepository;
import com.API.pessoa.repositories.PessoaRepository;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnderecoControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private EnderecoRepository repository;
	
	@Test
	@Order(1)
	@DisplayName("Criar uma endereco")	
	public void deveCEriarUmaEndereco() {
		
		
		
	
	
		
		HttpEntity<Endereco> requisicao = new HttpEntity<Endereco>(new Endereco(0L, false, "Rua das Flores",12345677,23,"São paulo"));
		ResponseEntity<Endereco> resposta= testRestTemplate.exchange("/endereco",HttpMethod.POST, requisicao ,
			 Endereco.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getCep(), resposta.getBody().getCep());
		assertEquals(requisicao.getBody().getCidade(), resposta.getBody().getCidade());
		assertEquals(requisicao.getBody().getLogradouro(), resposta.getBody().getLogradouro());
		assertEquals(requisicao.getBody().getNumero(), resposta.getBody().getNumero());
		assertEquals(requisicao.getBody().isEnderecoPrincipal(), resposta.getBody().isEnderecoPrincipal());
		
	
	}

	@Test
	@Order(2)
	@DisplayName("Mostrar todos os Enderecos")
	public void deveMostrarTodosOsEnderecos() {

		Endereco createEndereco=  repository.save(new Endereco(0L,false ,"Rua Das Flores",12345678,11,"São paulo"));
		
		Endereco createEndereco2=  repository.save(new Endereco(0L,false , "Passagem Das Flores",12345678,11,"São paulo"));
				
		
		ResponseEntity<String> resposta = testRestTemplate
			.exchange("/endereco",  HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
}
