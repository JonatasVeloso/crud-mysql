package br.com.jvsiqueira.crudmysql.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.jvsiqueira.crudmysql.model.Perfil;

public interface PerfilRepository extends CrudRepository<Perfil, Long>{

	List<Perfil> findAll();
	
	@Query(value = "select * from Perfil p where p.perfil_default = 'SIM'",
			nativeQuery = true)
	public Perfil findDefault();
}
