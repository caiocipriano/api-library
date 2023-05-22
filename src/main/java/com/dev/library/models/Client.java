package com.dev.library.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
public class Client extends Person{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message="O campo de data não pode ser vazio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateBorn;
	
	

	public Client(String name, String cpf, String phone,Date dateBorn) {
		super(name, cpf, phone);
		this.dateBorn=dateBorn;
	}

	public Date getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}


	 
}
