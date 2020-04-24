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

@Entity(name = "produtos")
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	@Column(unique = true)
	private Long codEan;
	@Column(unique = true)
	private Long codProduto;
	@NotNull
	@Size(min = 1, max = 10)
	private String ref;
	@NotNull(message = "{descrição não pode ser nulo}")
	@Size(min = 5, max = 60, message = "{O descrição deve ter no min 5 caracteres e no max 50}")
	private String descricao;
	private String descricaoReduzida;
	@NotNull
	private String cor;
	@NotNull
	@Size(min = 2, max = 2)
	private String gradeVenda;
	@NotNull
	@Size(min = 2, max = 10)
	private String descricaoUnidadeVend;
	@NotNull
	@Min(value = 1)
	@Max(value = 1000)
	private Long unidadeVenda;
	@NotNull
	@Min(value = 0)
	@Max(value = 2)
	private Integer origem;
	private String ncm;
	@NotNull
	private Float custo;
	@NotNull
	private Float preco;
	private Long estoque;
	private Float altura;
	private Float largura;
	private Float comprimento;
	private Float peso;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getCodEan() {
		return codEan;
	}

	public void setCodEan(Long codEan) {
		this.codEan = codEan;
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoReduzida() {
		return descricaoReduzida;
	}

	public void setDescricaoReduzida(String descricaoReduzida) {
		this.descricaoReduzida = descricaoReduzida;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getGradeVenda() {
		return gradeVenda;
	}

	public void setGradeVenda(String gradeVenda) {
		this.gradeVenda = gradeVenda;
	}

	public String getDescricaoUnidadeVend() {
		return descricaoUnidadeVend;
	}

	public void setDescricaoUnidadeVend(String descricaoUnidadeVend) {
		this.descricaoUnidadeVend = descricaoUnidadeVend;
	}

	public Long getUnidadeVenda() {
		return unidadeVenda;
	}

	public void setUnidadeVenda(Long unidadeVenda) {
		this.unidadeVenda = unidadeVenda;
	}

	public Integer getOrigem() {
		return origem;
	}

	public void setOrigem(Integer origem) {
		this.origem = origem;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public Float getCusto() {
		return custo;
	}

	public void setCusto(Float custo) {
		this.custo = custo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getLargura() {
		return largura;
	}

	public void setLargura(Float largura) {
		this.largura = largura;
	}

	public Float getComprimento() {
		return comprimento;
	}

	public void setComprimento(Float comprimento) {
		this.comprimento = comprimento;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

}
