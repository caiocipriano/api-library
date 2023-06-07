package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class MovieType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	@NotBlank(message = "Nome do Tipo de Filme deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do Tipo de Filme deve ter entre 2 e 50 letras")
	private String name;
	
	@Digits(integer=1, fraction=0, message = "Prazo do Tipo de Filme deve ser preenchido com um valor inteiro")
	private Integer term;
	
	@NotNull(message = "Preço do Tipo de Filme deve ser preenchido")
	private Double price;

	public MovieType(Integer id,String name,Integer term,Double price) {
		super();
		this.id = id;
		this.name = name;
		this.term = term;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
