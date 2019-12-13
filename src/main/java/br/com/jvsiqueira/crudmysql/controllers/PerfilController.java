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

import br.com.jvsiqueira.crudmysql.model.Perfil;
import br.com.jvsiqueira.crudmysql.services.PerfilService;

@RestController
@RequestMapping("/perfil/")
public class PerfilController {

	@Autowired
	PerfilService perfilService;
	
	@PostMapping(path = "salva")
	public void save(@RequestBody Perfil perfil) {
		perfilService.save(perfil);
	}
	
	@GetMapping(path = "consulta")
	public String find(Model model) {
		List<Perfil> perfilList = perfilService.findAll();
		model.addAttribute("perfilList", perfilList);
		return "perfis";
	}	
	
	@PutMapping(path = "altera")
	public void update(@RequestBody Perfil perfil) {
		perfilService.update(perfil);
	}
	
	@DeleteMapping(path = "deleta/{id}")
	public void delete(@PathVariable("id") Long id ) {
		perfilService.delete(id);
	}
}
