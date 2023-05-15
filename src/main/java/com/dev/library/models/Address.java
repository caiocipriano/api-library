package com.dev.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length=50)
	@NotNull(message="O campo de rua não precisa ser preechido")
	private String street;
	
	@Column(length=50)
	@NotNull(message="O campo de bairro precisa ser preechido")
	private String district;
	
	
	@Column(length=50)
	@NotNull(message="O campo de cidade precisa ser preechido")
	private String city;
	
	
	@OneToOne
	private Client client;
}
