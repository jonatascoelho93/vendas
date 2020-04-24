package br.com.vendas.repository;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@Column(unique = true)
	private Long codCliente;
	@Column(unique = true)
	private String registroFederal;
	private Boolean pessoaJuridica;
	@Column(unique = true)
	private String inscricaoEstadual;
	@NotNull(message = "{Nome não pode ser nulo}")
	@Size(min = 5, max = 50, message = "{O nome deve ter no min 5 caracteres e no max 50}")
	private String nomeCompleto;
	@Size(max = 50, message = "{O nome deve ter no min 5 caracteres e no max 50}")
	private String razaoSocial;
	@Size(max = 50, message = "{O nome deve ter no min 5 caracteres e no max 50}")
	private String nomeFantazia;
	private Boolean bloqueado;
	@NotNull(message = "{O numero de telefone não pode ser nulo}")
	@Size(min = 14, max = 15, message = "{Numero de telefone incompleto}")
	private String numeroTelefone;
	@NotNull(message = "{O numero de telefone não pode ser nulo}")
	@Size(min = 14, max = 15, message = "{Numero de celular incompleto}")
	private String numeroCelular;
	@Email
	@NotNull(message = "{Email não pode ser nulo}")
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

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
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
