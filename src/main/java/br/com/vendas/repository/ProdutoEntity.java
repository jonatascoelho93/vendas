package br.com.vendas.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "produdo")
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long codEan;
	private Long codReduzido;
	private String ref;
	private String descricao;
	private String descricaoReduzida;
	@ManyToOne
	private CorEntity cor;
	private String gradeVenda;
	private String descricaoUnidadeVend;
	private Long unidadeVenda;
	private Long origem;
	private Long ncm;
	private Float preco;
	private Long estoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodEan() {
		return codEan;
	}

	public void setCodEan(Long codEan) {
		this.codEan = codEan;
	}

	public Long getCodReduzido() {
		return codReduzido;
	}

	public void setCodReduzido(Long codReduzido) {
		this.codReduzido = codReduzido;
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

	public CorEntity getCor() {
		return cor;
	}

	public void setCor(CorEntity cor) {
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

}
