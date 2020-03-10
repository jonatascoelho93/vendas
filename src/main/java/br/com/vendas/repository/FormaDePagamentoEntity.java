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
	private Integer parcele3;
	private Integer parcele4;
	private Integer parcele5;
	private Integer parcele6;
	
	

	public FormaDePagamentoEntity(Long codigoFormaDePgto, String descricaoFormaDePgto) {
		super();
		this.codigoFormaDePgto = codigoFormaDePgto;
		this.descricaoFormaDePgto = descricaoFormaDePgto;

	}

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

	public Integer getParcele3() {
		return parcele3;
	}

	public void setParcele3(Integer parcele3) {
		this.parcele3 = parcele3;
	}

	public Integer getParcele4() {
		return parcele4;
	}

	public void setParcele4(Integer parcele4) {
		this.parcele4 = parcele4;
	}

	public Integer getParcele5() {
		return parcele5;
	}

	public void setParcele5(Integer parcele5) {
		this.parcele5 = parcele5;
	}

	public Integer getParcele6() {
		return parcele6;
	}

	public void setParcele6(Integer parcele6) {
		this.parcele6 = parcele6;
	}

}
