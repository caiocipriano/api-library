package com.dev.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dev.library.models.Client;
import com.dev.library.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	

	public Client post( Client client){ 
		try {
			return repository.save(client);
    } catch (DataIntegrityViolationException e) {
        throw new DataIntegrityViolationException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s): Bairro ou Telefone");
    }
  }
}

