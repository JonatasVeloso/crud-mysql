package br.com.jvsiqueira.crudmysql.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	
	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "usuario_nome")
	private String nome;
	
	@Column(name = "usuario_email")
	private String email;
	
	@ManyToMany
	private Set<Perfil> perfil;
	
	public Set<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(Set<Perfil> perfil) {
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
