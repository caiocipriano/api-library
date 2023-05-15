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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length=50)
    @NotBlank(message = "Nome da Pessoa deve ser preenchido")
	@Size(min = 2, max = 50, message = "Nome da Pessoa deve ter entre 2 e 50 letras")
	private String name;
	
	
    @Column(length = 50)
    @NotBlank(message = "CPF da Pessoa deve ser preenchido")
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "CPF da Pessoa deve seguir o padrão NNN.NNN.NNN-NN")
	private String cpf;
    
    @NotBlank(message = "Numero da Pessoa deve ser preenchido")
    @Size(min = 1, max = 11, message = "Número com padrão 11 dígitos")
	private String phone;
}
