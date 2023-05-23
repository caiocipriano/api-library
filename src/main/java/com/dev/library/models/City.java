package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(length = 50)
	 @NotBlank(message = "Nome do Bairro deve ser preenchido")
	 @Size(min = 2, max = 50, message = "Nome do Bairro deve ter entre 2 e 50 letras")
	 private String name;
	 
	 @NotNull(message = "A UF da Cidade deve ser preenchida") 
	 @ManyToOne
	 @JoinColumn(name = "uf_id")
     private UF uf;

	public City(Integer id,String name, UF uf) {
		this.id = id;
		this.name = name;
		this.uf = uf;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
	 
	 
	
}
