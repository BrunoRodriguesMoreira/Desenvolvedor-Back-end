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
import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.PessoaRepository;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private PessoaRepository repository;
	
	@Test
	@Order(1)
	@DisplayName("Criar uma Pessoa")	
	public void deveCriarUmaPessoa() {
		

		LocalDate data = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("21/05/1996");
		String dataFormatada = data.format(formatter);
		
		HttpEntity<Pessoa> requisicao = new HttpEntity<Pessoa>(new Pessoa(0L,"Bruno Rodrigues",data));
		
		ResponseEntity<Pessoa> resposta = testRestTemplate.exchange("/pessoas",HttpMethod.POST, requisicao ,
			 Pessoa.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getDataNascimento(), resposta.getBody().getDataNascimento());
		
		
	
	}
	@Test
	@Order(2)
	@DisplayName("Alterar uma Pessoa")
	public void deveAtualizarUmUsuario() {

		
	     	LocalDate data = LocalDate.now();
	     	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("21/05/1996");
	    	String dataFormatada = data.format(formatter);
		
			Pessoa createPessoa=  repository.save(new Pessoa(0L, 
			"Juliana Andrews", data ));
			
			LocalDate data1 = LocalDate.now();
	     	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("21/05/1997");
	    	String dataFormatada1 = data1.format(formatter1);

	         Pessoa pessoaUpdate = new Pessoa(createPessoa.getId(),
			"Juliana Andrews Ramos", data1);
		
		HttpEntity<Pessoa> requisicao = new HttpEntity<Pessoa>(pessoaUpdate);

	   ResponseEntity<Pessoa> resposta = testRestTemplate.exchange("/pessoas", HttpMethod.PUT, requisicao, Pessoa.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals(pessoaUpdate.getNome(), resposta.getBody().getNome());
		assertEquals(pessoaUpdate.getDataNascimento(), resposta.getBody().getDataNascimento());
	}
	@Test
	@Order(4)
	@DisplayName("Listar todos os Usuários")
	public void deveMostrarTodasAsPessoa() {

		LocalDate data = LocalDate.now();
     	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("21/05/1996");
    	String dataFormatada = data.format(formatter);
		Pessoa createPessoa=  repository.save(new Pessoa(0L, 
		"Enzo Carlos", data ));
		
		
		LocalDate data1 = LocalDate.now();
     	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("21/05/1997");
    	String dataFormatada1 = data1.format(formatter1);

		Pessoa createPessoa2=  repository.save(new Pessoa(0L, "Juliana Andrews", data1 ));
				
		
		

		ResponseEntity<String> resposta = testRestTemplate
			.exchange("/pessoas", HttpMethod.GET, null, String.class);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	
	
	
	
}
