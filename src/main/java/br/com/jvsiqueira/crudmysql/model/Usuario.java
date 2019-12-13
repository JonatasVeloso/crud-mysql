package br.com.jvsiqueira.crudmysql.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jvsiqueira.crudmysql.repositories.PerfilRepository;

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
	
	@ManyToOne
	private Perfil perfil;
	
	@ManyToMany
	private Set<Carro> carro;
		
	public Usuario() {}
	
	public Usuario(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public Set<Carro> getCarro() {
		return carro;
	}

	public void setCarro(Set<Carro> carro) {
		this.carro = carro;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", perfil=" + perfil + ", carro=" + carro
				+ "]";
	}
}
