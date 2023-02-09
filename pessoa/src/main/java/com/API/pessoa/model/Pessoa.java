package com.API.pessoa.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name ="tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	
    @NotNull(message="O campo nome é obrigatório!")
	private String nome;
	
	@NotNull(message="O campo data é obrigatório!")
	
	private LocalDate dataNascimento ;
	

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("pessoa")
	private List<Endereco> endereco;


	public Pessoa(Long id, String nome, LocalDate dataNascimento, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		}

	
	public Pessoa(Long id, String nome, LocalDate dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		}



	public Pessoa() {}	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public  LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento( LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	

}
