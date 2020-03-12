package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cor")
public class CorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCor;
	private String descricaoCor;
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
