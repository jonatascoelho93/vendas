package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "produtos")
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProduto;
	private Long codEan;
	private Long codProduto;
	private String ref;
	private String descricao;
	private String descricaoReduzida;
	private String cor;
	private String gradeVenda;
	private String descricaoUnidadeVend;
	private Long unidadeVenda;
	private Long origem;
	private Long ncm;
	private Float custo;
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

	public Long getOrigem() {
		return origem;
	}

	public void setOrigem(Long origem) {
		this.origem = origem;
	}

	public Long getNcm() {
		return ncm;
	}

	public void setNcm(Long ncm) {
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
