package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class UF implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(length = 2)
	@NotBlank(message = "Sigla da UF deve ser preenchida")
	@Size(min = 2, max = 2, message = "Sigla da UF deve ter 2 letras")
    private String sigla;

	public UF(Integer id,String sigla) {
		this.id = id;
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
