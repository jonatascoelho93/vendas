package br.com.vendas.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "vendedores")
public class VendedoresEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVendedor;
	@NotNull(message = "{Codigo não pode ser nulo}")
	@Min(value = 1, message = "o numero não pode ser menor que um")
	@Max(value = 999, message = "o numero não pode ser maior que 999")
	@Column(unique = true)
	private Long codVendedor;
	@NotNull(message = "{Nome não pode ser nulo}")
	@Size(min = 5, max = 50, message = "{O nome deve ter no min 5 caracteres e no max 50}")
	private String nome;
	@Email
	@NotNull(message = "{Email não pode ser nulo}")
	@Size(min = 5, max = 40, message = "{O email deve ter no min 5 caracteres e no max 40}")
	private String emailVendedor;
	@Size(min = 14, max = 15, message = "{Numero de telefone incompleto}")
	private String telefone;
	@NotNull(message = "{O numero de telefone não pode ser nulo}")
	@Size(min = 14, max = 15, message = "{Numero de celular incompleto}")
	private String celular;
	@NotNull(message = "{Funcionario não pode ser nulo}")
	private String funcionario;

	public Long getId() {
		return idVendedor;
	}

	public void setId(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Long getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Long codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmailVendedor() {
		return emailVendedor;
	}

	public void setEmailVendedor(String emailVendedor) {
		this.emailVendedor = emailVendedor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

}
