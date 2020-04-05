package br.com.vendas.repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class PedidoItensEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoItens;
	@ManyToOne
    @JoinColumn(name = "idPedido")
	private PedidoEntity pedido;
	@OneToOne
	private ProdutoEntity produto;
	private Float quantidade;
	private Float totalItens;
	public Long getIdPedidoItens() {
		return idPedidoItens;
	}
	public void setIdPedidoItens(Long idPedidoItens) {
		this.idPedidoItens = idPedidoItens;
	}
	public ProdutoEntity getProduto() {
		return produto;
	}
	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	public Float getTotalItens() {
		return totalItens;
	}
	public void setTotalItens(Float totalItens) {
		this.totalItens = totalItens;
	}

}
