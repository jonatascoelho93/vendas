package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "formadepamento")
public class FormaDePagamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFormaDePgto;
	private Long codigoFormaDePgto;
	private String descricaoFormaDePgto;
	private Integer parcela1;
	private Integer parcela2;
	private Integer parcela3;
	private Integer parcela4;
	private Integer parcela5;
	private Integer parcela6;

	public Long getIdFormaDePgto() {
		return idFormaDePgto;
	}

	public void setIdFormaDePgto(Long idFormaDePgto) {
		this.idFormaDePgto = idFormaDePgto;
	}

	public Long getCodigoFormaDePgto() {
		return codigoFormaDePgto;
	}

	public void setCodigoFormaDePgto(Long codigoFormaDePgto) {
		this.codigoFormaDePgto = codigoFormaDePgto;
	}

	public String getDescricaoFormaDePgto() {
		return descricaoFormaDePgto;
	}

	public void setDescricaoFormaDePgto(String descricaoFormaDePgto) {
		this.descricaoFormaDePgto = descricaoFormaDePgto;
	}

	public Integer getParcela1() {
		return parcela1;
	}

	public void setParcela1(Integer parcela1) {
		this.parcela1 = parcela1;
	}

	public Integer getParcela2() {
		return parcela2;
	}

	public void setParcela2(Integer parcela2) {
		this.parcela2 = parcela2;
	}

	public Integer getParcela3() {
		return parcela3;
	}

	public void setParcela3(Integer parcela3) {
		this.parcela3 = parcela3;
	}

	public Integer getparcela4() {
		return parcela4;
	}

	public void setparcela4(Integer parcela4) {
		this.parcela4 = parcela4;
	}

	public Integer getparcela5() {
		return parcela5;
	}

	public void setparcela5(Integer parcela5) {
		this.parcela5 = parcela5;
	}

	public Integer getparcela6() {
		return parcela6;
	}

	public void setparcela6(Integer parcela6) {
		this.parcela6 = parcela6;
	}

}
