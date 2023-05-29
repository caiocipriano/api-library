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


	public Tape(Integer id, @NotNull(message = "O atributo de 'Danificada' deve ser preenchido") Boolean damaged,
			@NotNull(message = "O atributo de 'Disponivel' deve ser preenchido") Boolean available,
			@NotNull(message = "O Filme da Fita deve ser preenchido") Movie movie) {
		super();
		this.id = id;
		this.damaged = damaged;
		this.available = available;
		this.movie = movie;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getDamaged() {
		return damaged;
	}


	public void setDamaged(Boolean damaged) {
		this.damaged = damaged;
	}


	public Boolean getAvailable() {
		return available;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
