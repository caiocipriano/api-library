package com.dev.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.library.models.Reserve;
import com.dev.library.repositories.ReserveRepository;

@Service
public class ReserveService {
	   @Autowired
	   private ReserveRepository repository;
	  
	   public Reserve insert(Reserve obj) {
		return repository.save(obj); 
	   }
}
