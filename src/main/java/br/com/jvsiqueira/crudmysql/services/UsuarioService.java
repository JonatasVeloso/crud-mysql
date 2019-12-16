package br.com.jvsiqueira.crudmysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvsiqueira.crudmysql.model.Perfil;
import br.com.jvsiqueira.crudmysql.model.Usuario;
import br.com.jvsiqueira.crudmysql.repositories.PerfilRepository;
import br.com.jvsiqueira.crudmysql.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public String save(Usuario usuario) {
		
		if(perfilRepository.count() > 0) {
			if(usuario.getPerfil() == null) {
				Perfil perfil = perfilRepository.findDefault();
				usuario.setPerfil(perfil);
			}
			usuarioRepository.save(usuario);
			return "Salvo com sucesso";
		}
		return "Não existe nenhum perfil, favor cadastrar um perfil.";
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public String delete(Long id) {
		if(usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return "Usuário Deletado com Sucesso!";
		}
		return "Usuário não existe!";	
	}
	
	public String update(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return "Alterado com sucesso";
		} catch (Exception e) {
			return "Erro ao alterar usuário: " + e;
		}			
	}
}
