package com.dev.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.library.models.Reserve;
import com.dev.library.service.ReserveService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
	
	@Autowired
	ReserveService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public Reserve post(@Valid @RequestBody Reserve reserve) {
		return service.insert(reserve);
		
	}
}
