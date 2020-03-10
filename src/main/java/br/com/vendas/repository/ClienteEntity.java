package br.com.vendas.repository;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCliente;
	private String registroFederal;
	private Boolean pessoaJuridica;
	private String inscricaoEstadual;
	private String nomeCompleto;
	private String razaoSocial;
	private String nomeFantazia;
	private Boolean bloqueado;
	private Byte codArea;
	private String numeroTelefone;
	private String numeroCelular;
	private String email;
	private String observacao;
	@OneToOne(cascade = CascadeType.ALL)
	private EnderecoEntity enderecoEntity;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getRegistroFederal() {
		return registroFederal;
	}

	public void setRegistroFederal(String registroFederal) {
		this.registroFederal = registroFederal;
	}

	public Boolean getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(Boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantazia() {
		return nomeFantazia;
	}

	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Byte getCodArea() {
		return codArea;
	}

	public void setCodArea(Byte codArea) {
		this.codArea = codArea;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public EnderecoEntity getEnderecoEntity() {
		return enderecoEntity;
	}

	public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
		this.enderecoEntity = enderecoEntity;
	}

}
