package com.dev.library.models;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Tape implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O atributo de 'Danificada' deve ser preenchido")
	private Boolean damaged;
	
	@NotNull(message="O atributo de 'Disponivel' deve ser preenchido")
	private Boolean available;
	
	
	//Tape could be OneToOne?
	@NotNull(message="O Filme da Fita deve ser preenchido")
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;

}
