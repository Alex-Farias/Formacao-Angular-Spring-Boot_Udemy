package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Chamado;

public class ChamadoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	@NotNull(message = "O campo PRIORIDADE é requerido")
	private Integer prioridade;
	@NotNull(message = "O campo STATUS é requerido")
	private Integer status;
	@NotNull(message = "O campo TITULO é requerido")
	private String titulo;
	@NotNull(message = "O campo OBSERVAÇÕES é requerido")
	private String observacoes;
	@NotNull(message = "O campo TÉCNICO é requerido")
	private Integer tecnico;
	@NotNull(message = "O campo CLIENTE é requerido")
	private Integer cliente;
	private String nomeTecnico;
	private String nomeCliente;
	
	public ChamadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public Integer getStatus() {
		return status;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public Integer getCliente() {
		return cliente;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
