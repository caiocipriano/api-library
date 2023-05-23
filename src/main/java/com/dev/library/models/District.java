package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class District implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(length = 50)
	@NotBlank(message = "Nome do Bairro deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome do Bairro deve ter entre 2 e 50 letras")
    private String name;
	
    @NotNull(message = "Cidade do Bairro deve ser preenchida")
	@ManyToOne
    @JoinColumn(name = "city_id")
	private City city;
    
   
	public District(Integer id, String name, City city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
}
