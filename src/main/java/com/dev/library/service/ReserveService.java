package com.dev.library.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dev.library.models.Client;
import com.dev.library.models.Reserve;
import com.dev.library.repositories.ClientRepository;
import com.dev.library.repositories.ReserveRepository;
import com.dev.library.service.exeptions.BusinessRuleException;
import com.dev.library.service.exeptions.DataIntegrityException;
import com.dev.library.service.exeptions.ObjectNotFoundException;

@Service
public class ReserveService {
	
	   @Autowired
	   private ReserveRepository repository;
	   @Autowired
	   private ClientRepository clientRepository;
	   
	   
	   
	   public Collection<Reserve> findAll() {
	        return repository.findAll();
	    }
	   
	   
	   
	   public Reserve findById(Integer id) {
		   try {
			   Reserve obj = repository.findById(id).get();
			   return obj;
		   }catch (NoSuchElementException e) {
	        	throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Reserve.class.getName());
	        }
	   }
	   
	   
	   
	   public Reserve insert(Reserve obj) {
		return repository.save(obj); 
	   }
	   
	   
	   public Reserve update(Reserve obj) {
	      Reserve find =  findById(obj.getId());
	      if(find == null) {
	    	  throw new ObjectNotFoundException("Objeto não encontrado! Tipo: " + Reserve.class.getName());
	      }try {
	        	return repository.save(obj);
	        } catch (DataIntegrityViolationException e) {
	            throw new DataIntegrityException("Não é possível atualizar uma reserva, verifique os dados!");
	        }
	   }
	   
	   public void delete(Integer id) {
		   Reserve find = findById(id);
		   if(find == null) {
		    	  throw new ObjectNotFoundException("Objeto não encontrado! Tipo: " + Reserve.class.getName());
		      }try {
		    		 repository.deleteById(id);
		        }catch(DataIntegrityViolationException e){
		            throw new DataIntegrityException("Não foi possível excluir esta Reserva!");
		        }
	   }
	   
	   public boolean verificarRegrasDeNegocio(Reserve obj) throws BusinessRuleException{
	 		
	 		Collection<Client> devedores = clientRepository.findDevedores();
	 		boolean clienteDevedor = false;
	 		for (Client devedor : devedores) {
	 			if (devedor.getId() == obj.getClient().getId()) {
	 				clienteDevedor = true;
	 			}
	 		}
	 		if (clienteDevedor) {
	 			throw new BusinessRuleException("Este cliente deve multas anteriores!");
	 		}
	 		return true;
	 	}
}
