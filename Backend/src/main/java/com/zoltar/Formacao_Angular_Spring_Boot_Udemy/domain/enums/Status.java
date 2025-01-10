package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.enums;

public enum Status {
	ABERTO(0, "ABERTO"),
	ANDAMENTO(1, "ANDAMENTO"),
	ENCERRADO(2, "ENCERRADO");
	
	private int codigo;
	private String descricao;
	private Status(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null){
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status Inválido!");
	}
}
