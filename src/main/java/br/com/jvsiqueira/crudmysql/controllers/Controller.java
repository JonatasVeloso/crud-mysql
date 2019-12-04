package br.com.jvsiqueira.crudmysql.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.jvsiqueira.crudmysql.model.Usuario;
import br.com.jvsiqueira.crudmysql.services.UsuarioService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(path = "teste")
	public void teste() {
		System.out.println("Chegou aqui");
	}
	
	@GetMapping(path = "usuarios")
	public String listaUsuario(Model model) {
		List<Usuario> lista = usuarioService.consultaTodos(); 
		model.addAttribute("userList", lista);
		return "usuarios";
	}
}