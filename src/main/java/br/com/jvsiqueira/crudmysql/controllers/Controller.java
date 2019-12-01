package br.com.jvsiqueira.crudmysql.controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping(path = "/teste/")
	public void teste() {
		System.out.println("Chegou aqui");
	}
}
