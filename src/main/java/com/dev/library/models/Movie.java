package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Movie implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	@NotBlank(message = "Título do Filme deve ser preenchido")
	@Size(min = 2, max = 50, message = "Título do Filme deve ter entre 2 e 50 letras")
	private String tittle;
	
	@Column(length = 50)
	@NotBlank(message = "Gênero do Filme deve ser preenchido")
	@Size(min = 2, max = 50, message = "Título do Filme deve ter entre 2 e 50 letras")
	private String gener;
	
	@Column(length = 50)
	@NotBlank(message = "Duração do Filme deve ser preenchido")
	@Size(min = 2, max = 50, message = "Título do Filme deve ter entre 2 e 50 letras")
    @Pattern(regexp="\\d{2}\\:\\d{2}", message = "Duração do Filme deve seguir o formato: hh:mm")
	private String time;
	
}
