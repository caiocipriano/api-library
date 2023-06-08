package com.dev.library.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dev.library.models.Client;
import com.dev.library.repositories.ClientRepository;
import com.dev.library.service.exeptions.DataIntegrityException;
import com.dev.library.service.exeptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	  public Collection<Client> findAll() {
	        return repository.findAll();
	    }

	public Client post( Client client){ 
		try {
			return repository.save(client);
    } catch (DataIntegrityViolationException e) {
        throw new DataIntegrityViolationException("Campo(s) obrigatório(s) do Cliente não foi(foram) preenchido(s): Bairro ou Telefone");
    }
  }
	
	public Client update(Client client) {
    	Client obj = findById(client.getId());
    	if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Tipo:" + Client.class.getName());
    	}
    	try {
			return repository.save(client);
		}catch(DataIntegrityException e) {
            throw new DataIntegrityViolationException("Não é possível atualizar um cliente, verifique os dados!");
		}
	}
	
	public Client findById(Integer id) {
		Client obj = repository.findById(id).get();
		if(obj ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Tipo:" + Client.class.getName());
		}
		return obj;
	}
	
	public void delete(Integer id) {
		Client obj =  findById(id);
		if(obj ==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id:"+ id +",Tipo:" + Client.class.getName());
		}
        try {
   		 repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir um Cliente associado a Reservas ou Empréstimos!");
        }
	}
}

