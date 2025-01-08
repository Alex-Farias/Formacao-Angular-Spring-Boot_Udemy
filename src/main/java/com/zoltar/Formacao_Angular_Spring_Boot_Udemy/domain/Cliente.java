package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Cliente extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@ManyToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		// TODO Auto-generated constructor stub
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
}
