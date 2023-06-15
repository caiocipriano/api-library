package com.dev.library.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="O campo de data não pode ser vazio")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Min(value=1, message="Valor do emprestimo deve ser maior que zero")
	@NotNull(message="O valor de emprestimo deve ser preenchido")
	@Digits(integer=6, fraction=2, message="Valor do Empréstimo deve ser preenchido com dígitos")	
	private Double valor;
	
	@NotNull(message = "O Cliente do Empréstimo deve ser preenchido")
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	private Collection<ItemLoan> itens = new ArrayList<>();
}
