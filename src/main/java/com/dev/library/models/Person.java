package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable{	
		

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	@Column(length=50)
	@NotBlank(message = "Nome da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "Nome da Pessoa deve ter entre 2 e 50 letras")
	private String name;
	
	
	@Column(length = 50)
    @NotBlank(message = "CPF da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "CPF da Pessoa deve ter entre 2 e 50 letras")
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "CPF da Pessoa deve seguir o padrão NNN.NNN.NNN-NN")
	private String cpf;
	
	
	@Column(length = 50)
    @NotBlank(message = "Rua da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "Rua da Pessoa deve ter entre 2 e 50 letras")
	private String street;
	
    @Digits(integer=4, fraction=0, message = "Número da Casa da Pessoa deve ser preenchido com um valor inteiro")
	private int number;

	public Person(Integer id,String name, String cpf,String street,int number) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.street = street;
		this.number = number;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}

