package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.dtos;

public class CredenciaisDTO {
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
