package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "pedidosentradaitens")
public class PedidoEntradaItensEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoItens;
	private Long numeroPedido;
	@NotNull(message = "{Campo não pode ser nulo}")
	private Long codProduto;
	private String refProduto;
	@NotNull(message = "{Campo não pode ser nulo}")
	private String descricaoProduto;
	@NotNull(message = "{Campo não pode ser nulo}")
	private String corProduto;
	@NotNull(message = "{Campo não pode ser nulo}")
	private String embalagem;
	@NotNull(message = "{Campo não pode ser nulo}")
	private Float preco;
	@NotNull(message = "{Campo não pode ser nulo}")
	private Long quantidade;
	@NotNull(message = "{Campo não pode ser nulo}")
	private Float totalItens;

	public Long getIdPedidoItens() {
		return idPedidoItens;
	}

	public void setIdPedidoItens(Long idPedidoItens) {
		this.idPedidoItens = idPedidoItens;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getRefProduto() {
		return refProduto;
	}

	public void setRefProduto(String refProduto) {
		this.refProduto = refProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getCorProduto() {
		return corProduto;
	}

	public void setCorProduto(String corProduto) {
		this.corProduto = corProduto;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Float getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(Float totalItens) {
		this.totalItens = totalItens;
	}

}
