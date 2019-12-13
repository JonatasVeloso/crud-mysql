package br.com.jvsiqueira.crudmysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvsiqueira.crudmysql.model.Perfil;
import br.com.jvsiqueira.crudmysql.repositories.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public String save(Perfil perfil) {
		try {
			perfilRepository.save(perfil);
			return "Salvo com sucesso: " + perfil;
		} catch (Exception e) {
			return "Falha ao gravar: " + perfil + " ERRO: " + e;
		}
	}
	
	public List<Perfil> findAll(){
		return perfilRepository.findAll();
	}
	
	public String delete(Long id) {
		try {
			perfilRepository.deleteById(id);
			return "Deletado com sucesso!";
		} catch (Exception e) {
			return "Erro ao deletar: " + e;
		}
	}
	
	public String update(Perfil perfil) {
		try {
			perfilRepository.save(perfil);
			return "Alterado com sucesso: " + perfil;
		} catch (Exception e) {
			return "Falha ao alterar: " + perfil + " ERRO: " + e;
		}
	}
	
	public Perfil findDefault() {
		return perfilRepository.findDefault();
	}
	
	
}
