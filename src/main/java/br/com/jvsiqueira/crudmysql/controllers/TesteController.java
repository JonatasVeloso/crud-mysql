package br.com.jvsiqueira.crudmysql.controllers;

import java.util.List;

import org.hibernate.cache.spi.AbstractRegionFactory;
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
	public void find(Model model) {
		List<Perfil> perfilList = perfilService.findAll();
		model.addAttribute("perfilList", perfilList);
	}
	
	@PostMapping(path = "usuarios")
	public String salvaUsuario(@ModelAttribute Usuario usuario, Model model) {
		String mensagem = usuarioService.save(usuario);
		model.addAttribute("mensagem", mensagem);
		return "salvo-com-sucesso";
	}

	@GetMapping(path = "lambda")
	public void lambda(){

		// FAZENDO SEM UTILIZAR O LAMBDA
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("TESTE");
			}
		};

		// FAZENDO UTILIZANDO O LAMBDA
		Runnable r2 = () -> System.out.println("TESTE2");

		r1.run();
		r2.run();
	}
}