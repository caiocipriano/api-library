package com.dev.library.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Client extends Person{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="O campo de data não pode ser vazio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateBorn;
	

	public Client(Integer id,String name,String cpf,String street, int number, Date dateBorn) {
		super(id, name, cpf, street, number);
		this.dateBorn = dateBorn;	}


	public Date getDateBorn() {
		return dateBorn;
	}


	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
