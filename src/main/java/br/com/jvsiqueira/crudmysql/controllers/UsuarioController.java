package br.com.jvsiqueira.crudmysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jvsiqueira.crudmysql.model.Usuario;
import br.com.jvsiqueira.crudmysql.repositories.UsuarioRepository;
import br.com.jvsiqueira.crudmysql.services.UsuarioService;

@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping(path = "consulta")
	public List<Usuario> consultaTodos() {
		List<Usuario> lista = usuarioService.consultaTodos();
		System.out.println(lista);
		return lista;
	}
	
	@PostMapping(path = "salva")
	public void salvar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}
	
	@DeleteMapping(path = "deleta/id")
	public void deletar(@PathVariable("id") Long id) {
		usuarioService.deletar(id);
	}
	
	@PutMapping(path = "altera")
	public void alterar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}
	
}
