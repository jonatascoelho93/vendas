package br.com.vendas.repository;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@OneToOne
	private ClienteEntity cliente;

	@OneToOne
	private VendedoresEntity vendedor;

	@OneToOne
	private FormaDePagamentoEntity formaPgto;

	@OneToMany(mappedBy = "pedido")
	private ArrayList<PedidoItensEntity> pedidoItens;
	private Long totalProdutos;
	private Long descontoPerc;
	private Long descontoTotal;
	private Long totalPedido;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public VendedoresEntity getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedoresEntity vendedor) {
		this.vendedor = vendedor;
	}

	public FormaDePagamentoEntity getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaDePagamentoEntity formaPgto) {
		this.formaPgto = formaPgto;
	}

	public ArrayList<PedidoItensEntity> getPedidoItens() {
		return pedidoItens;
	}

	public void setPedidoItens(ArrayList<PedidoItensEntity> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}

	public Long getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(Long totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public Long getDescontoPerc() {
		return descontoPerc;
	}

	public void setDescontoPerc(Long descontoPerc) {
		this.descontoPerc = descontoPerc;
	}

	public Long getDescontoTotal() {
		return descontoTotal;
	}

	public void setDescontoTotal(Long descontoTotal) {
		this.descontoTotal = descontoTotal;
	}

	public Long getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Long totalPedido) {
		this.totalPedido = totalPedido;
	}

}
