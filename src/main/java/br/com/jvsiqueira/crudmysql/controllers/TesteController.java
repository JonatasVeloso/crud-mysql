package br.com.jvsiqueira.crudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jvsiqueira.crudmysql.model.Usuario;
import br.com.jvsiqueira.crudmysql.services.UsuarioService;

@Controller
@RequestMapping("/")
public class TesteController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(path = "usuarios")
	public String listaUsuario(Model model) {
		List<Usuario> lista = usuarioService.consultaTodos(); 
		model.addAttribute("userList", lista);
		model.addAttribute("usuario", new Usuario());
		return "usuarios";
	}
	
	@PostMapping(path = "usuarios")
	public String salvaUsuario(@ModelAttribute Usuario usuario) {
		usuarioService.salvar(usuario);
		//model.addAttribute("usuarios", usuario);
		return "salvo-com-sucesso";
	}
	
	@GetMapping(path = "teste")
	public void teste() {
		System.out.println("Chegou aqui");
	}
}