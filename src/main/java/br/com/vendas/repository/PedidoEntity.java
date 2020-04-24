package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@NotNull(message = "{Codigo cliente não pode ser nulo}")
	private Long codCliente;
	@NotNull(message = "{Registro federal não pode ser nulo}")
	private String registroFederal;
	private String nomeCliente;
	private String razaoSocial;
	@NotNull(message = "{Codigo não pode ser nulo}")
	@Min(value = 1, message = "o numero não pode ser menor que um")
	@Max(value = 999, message = "o numero não pode ser maior que 999")
	private Long codVendedor;
	@NotNull(message = "{Nome não pode ser nulo}")
	@Size(min = 5, max = 50, message = "{O nome deve ter no min 5 caracteres e no max 50}")
	private String nomeVendedor;
	@NotNull(message = "{valor não pode ser nulo}")
	@Min(value = 1, message = "{Valor minimo é 1}" )
	@Max(value = 999, message = "{Valor maximo é 999}")
	private Long codFormaPgto;
	@NotNull(message = "{valor não pode ser nulo}")
	@Size(min = 4, max = 30, message = "{O campo descrição de pagamento deve ter no minimo 4 e no maximo 30 caracteres}")
	private String descricaoFormaPgto;

	// @OneToMany(mappedBy = "pedidoEntity")
	// private ArrayList<PedidoItensEntity> pedidoItens;

	private Float totalProdutos;
	private Float descontoPerc;
	private Float descontoTotal;
	private Float totalPedido;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Long codVendedor) {
		this.codVendedor = codVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Long getCodFormaPgto() {
		return codFormaPgto;
	}

	public void setCodFormaPgto(Long codFormaPgto) {
		this.codFormaPgto = codFormaPgto;
	}

	public String getDescricaoFormaPgto() {
		return descricaoFormaPgto;
	}

	public void setDescricaoFormaPgto(String descricaoFormaPgto) {
		this.descricaoFormaPgto = descricaoFormaPgto;
	}

	public Float getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(Float totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public Float getDescontoPerc() {
		return descontoPerc;
	}

	public void setDescontoPerc(Float descontoPerc) {
		this.descontoPerc = descontoPerc;
	}

	public Float getDescontoTotal() {
		return descontoTotal;
	}

	public void setDescontoTotal(Float descontoTotal) {
		this.descontoTotal = descontoTotal;
	}

	public Float getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Float totalPedido) {
		this.totalPedido = totalPedido;
	}

}
