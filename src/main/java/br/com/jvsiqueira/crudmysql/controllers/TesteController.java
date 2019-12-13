package br.com.jvsiqueira.crudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jvsiqueira.crudmysql.model.Perfil;
import br.com.jvsiqueira.crudmysql.model.Usuario;
import br.com.jvsiqueira.crudmysql.services.PerfilService;
import br.com.jvsiqueira.crudmysql.services.UsuarioService;

@Controller
@RequestMapping("/")
public class TesteController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PerfilService perfilService;
	
	@GetMapping(path = "usuarios")
	public String listaUsuario(Model model) {
		List<Usuario> lista = usuarioService.findAll(); 
		Perfil perfil = perfilService.findDefault();
		model.addAttribute("userList", lista);
		Usuario usuario= new Usuario(perfil);
		System.out.println(usuario);
		model.addAttribute("usuario", usuario);
		return "usuarios";
	}
	
	@GetMapping(path = "perfis")
	public String find(Model model) {
		List<Perfil> perfilList = perfilService.findAll();
		model.addAttribute("perfilList", perfilList);
		return "perfis";
	}
	
	@PostMapping(path = "usuarios")
	public String salvaUsuario(@ModelAttribute Usuario usuario, Model model) {
		String mensagem = usuarioService.save(usuario);
		model.addAttribute("mensagem", mensagem);
		return "salvo-com-sucesso";
	}
}