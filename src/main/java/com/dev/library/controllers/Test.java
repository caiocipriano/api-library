package com.dev.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Test {
	@GetMapping("/hello")
	public String hello(){
		return "Hello Word!";
	}
}
