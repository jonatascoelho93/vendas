package br.com.vendas.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "cor")
public class CorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCor;
	@Column(unique = true)
	@NotNull(message = "{Descrição não pode ser nulo}")
	@Size(min = 5, max = 20, message = "{O nome deve ter no min 5 caracteres e no max 20}")
	private String descricaoCor;
	@Column(unique = true)
	@Min(value = 1, message = "o numero não pode ser menor que um")
	@Max(value = 999, message = "o numero não pode ser maior que 999")
	private Long codCor;

	public Long getIdCor() {
		return idCor;
	}

	public void setIdCor(Long idCor) {
		this.idCor = idCor;
	}

	public String getDescricaoCor() {
		return descricaoCor;
	}

	public void setDescricaoCor(String descricaoCor) {
		this.descricaoCor = descricaoCor;
	}

	public Long getCodCor() {
		return codCor;
	}

	public void setCodCor(Long codCor) {
		this.codCor = codCor;
	}

}
