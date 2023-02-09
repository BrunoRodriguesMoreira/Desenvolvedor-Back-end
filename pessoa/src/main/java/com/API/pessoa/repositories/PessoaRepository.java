package com.API.pessoa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


import com.API.pessoa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	
    public Optional<Pessoa>findByNome(String nome);  
    
   
	
	public List <Pessoa> findAllByNomeContainingIgnoreCase(String nome);

}
