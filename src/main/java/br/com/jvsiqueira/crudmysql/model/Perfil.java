package br.com.jvsiqueira.crudmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.context.properties.bind.DefaultValue;

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
public class Perfil {

	@Id
	@Column(name = "perfil_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "perfil_grau")
	private int grau;
	
	@Column(name = "perfil_descricao")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPerfil status;
	
	public Perfil() {
		status = StatusPerfil.ATIVO;
	}
	
	public StatusPerfil getStatus() {
		return status;
	}

	public void setStatus(StatusPerfil status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
