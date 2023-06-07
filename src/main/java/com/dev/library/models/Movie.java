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
	
	
	@NotNull(message = "Tipo de Filme deve ser preenchido")
	@ManyToOne
	@JoinColumn(name="movieType_id")
	private MovieType movieType;


	public Movie(Integer id,String tittle,String gener, String time,MovieType movieType) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.gener = gener;
		this.time = time;
		this.movieType = movieType;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}


	public String getGener() {
		return gener;
	}


	public void setGener(String gener) {
		this.gener = gener;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public MovieType getMovieType() {
		return movieType;
	}


	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
