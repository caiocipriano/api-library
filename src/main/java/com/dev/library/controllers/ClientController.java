package com.dev.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.library.models.Client;
import com.dev.library.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	ClientService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public Client post(@Valid @RequestBody Client cliente) {
		return service.post(cliente);
	}
}
