package com.dev.library.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Reserve implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateBorn;
	
	@Digits(integer=1, fraction=0, message="Status da Reserva deve ser preechido")
	private Integer status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
		
}
