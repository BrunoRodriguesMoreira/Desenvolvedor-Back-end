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

import com.API.pessoa.model.Pessoa;
import com.API.pessoa.repositories.PessoaRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaRepositoryTest {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@BeforeAll
	void start() {
	
		LocalDate data = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("21/05/1996");
		String dataFormatada = data.format(formatter);
		pessoaRepository.save( new Pessoa(0L, "Bruno Rodrigues", data));
		
		LocalDate data1 = LocalDate.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("21/05/1997");
		String dataFormatada1 = data1.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Carlos Rodrigues", data1));
		
		LocalDate data2 = LocalDate.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("21/05/1998");
		String dataFormatada2 = data2.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Ytallo Rodrigues", data2));
		

		LocalDate data3 = LocalDate.now();
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("21/05/1999");
		String dataFormatada3 = data3.format(formatter1);
		pessoaRepository.save( new Pessoa(0L, "Nilce Aparecida", data3));
		
	
		
		
	}
		
	@Test
	@DisplayName("Retorna 1 pessoa")
	@Order(1)
	public void deveRetornarUmaPessoa() {
		
    	Optional<Pessoa> pessoa = pessoaRepository.findByNome("Carlos");
    	assertTrue(pessoa.get().getNome().equals("Carlos"));
	}

	
	@Test
	@DisplayName("Retorna 3 pessoas")
	@Order(2)
	public void deveRetornarTresPessoas() {
		
		List<Pessoa> listaDePessoas = pessoaRepository.findAllByNomeContainingIgnoreCase("Rodrigues");
		assertEquals(3,listaDePessoas.size());
		assertTrue(listaDePessoas.get(0).getNome().equals("Bruno Rodrigues"));
		assertTrue(listaDePessoas.get(1).getNome().equals("Carlos Rodrigues"));
		assertTrue(listaDePessoas.get(2).getNome().equals("Ytallo Rodrigues"));	
		
	}
	

}
