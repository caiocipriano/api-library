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
	private Date date;
	
	@Digits(integer=1, fraction=0, message="Status da Reserva deve ser preechido")
	private Integer status;
	
	
	@NotNull(message = "A Fita da Reserva deve ser preenchida")
	@ManyToOne
	@JoinColumn(name="tape_id")
	private Tape tape;
	
	@NotNull(message = "O Cliente da Reserva deve ser preenchido")
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	public Reserve(Integer id, Date date,
			@Digits(integer = 1, fraction = 0, message = "Status da Reserva deve ser preechido") Integer status,
			@NotNull(message = "A Fita da Reserva deve ser preenchida") Tape tape,
			@NotNull(message = "O Cliente da Reserva deve ser preenchido") Client client) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.tape = tape;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateBorn() {
		return date;
	}

	public void setDateBorn(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Tape getTape() {
		return tape;
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
