package br.com.jvsiqueira.crudmysql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.jvsiqueira.crudmysql.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	List<Usuario> findAll();
	
}
