
package com.API.pessoa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo texto é Obrigatório!")
	@Size(min = 5, max = 1000, message = "O campo logradouro deve ter de 10 á 100 caracteres.")
	private String logradouro;
	
	@NotNull(message = "O campo cep é Obrigatório!")
   	private int cep;
	
 	@NotNull(message = "O campo numero é Obrigatório!")
	private int  numero ;
	
	@NotNull(message = "O campo cidade é Obrigatório!")
	@Size(min = 5, max =50 , message = "O campo texto deve ter no mínimo 10 e no máximo 100 caracteres.")
	private String cidade;	
	
	@NotNull(message = "O campo endereçoPrincipal é obrigatóro.")
	private boolean enderecoPrincipal;

	@ManyToOne
	@JsonIgnoreProperties("endereco")
	private Pessoa pessoa;
	
	
	


	public Endereco(Long id,
			   boolean enderecoPrincipal,
			String logradouro,
		    int cep,
		    int numero,
		   String cidade 
		
		) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade ;
		this.enderecoPrincipal = enderecoPrincipal;
		
	}

	
	public boolean isEnderecoPrincipal() {
		return enderecoPrincipal;
	}



	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	
	
	public Endereco() {
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public int getCep() {
		return cep;
	}


	public void setCep(int cep) {
		this.cep = cep;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}