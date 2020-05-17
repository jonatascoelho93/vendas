package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "pedidosentrada")
public class PedidoEntradaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoDeEntrada;
	private Long numeroNFE;
	@NotNull(message = "{Nome não pode ser nulo}")
	private String fornecedor;
	@Size(min = 10, max = 10, message = "{O nome deve ter no min 10 caracteres e no max 10}")
	private String dataNFE;
	private Float totalProdutos;
	private Float totalNFE;
	private Float totalFrete;
	private Float desconto;
	private Float totalDeDesconto;
	private String entregue;

	public Long getIdPedidoDeEntra() {
		return idPedidoDeEntrada;
	}

	public void setIdPedidoDeEntra(Long idPedidoDeEntrada) {
		this.idPedidoDeEntrada = idPedidoDeEntrada;
	}

	public Long getNumeroNFE() {
		return numeroNFE;
	}

	public void setNumeroNFE(Long numeroNFE) {
		this.numeroNFE = numeroNFE;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDataNFE() {
		return dataNFE;
	}

	public void setDataNFE(String dataNFE) {
		this.dataNFE = dataNFE;
	}

	public Float getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(Float totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public Float getTotalNFE() {
		return totalNFE;
	}

	public void setTotalNFE(Float totalNFE) {
		this.totalNFE = totalNFE;
	}

	public Float getTotalFrete() {
		return totalFrete;
	}

	public void setTotalFrete(Float totalFrete) {
		this.totalFrete = totalFrete;
	}

	public Float getDesconto() {
		return desconto;
	}

	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}

	public Float getTotalDeDesconto() {
		return totalDeDesconto;
	}

	public void setTotalDeDesconto(Float totalDeDesconto) {
		this.totalDeDesconto = totalDeDesconto;
	}

	public String getEntregue() {
		return entregue;
	}

	public void setEntregue(String entregue) {
		this.entregue = entregue;
	}

}
