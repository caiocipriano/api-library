package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person implements Serializable{	
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=50)
	@Size(min = 2, max = 50, message = "Nome da Pessoa deve ter entre 2 e 50 letras")
	private String name;
	
	
    @Column(length = 50)
	private String cpf;
    
    @Size(min = 1, max = 11, message = "Número com padrão 11 dígitos")
	private String phone;
}
