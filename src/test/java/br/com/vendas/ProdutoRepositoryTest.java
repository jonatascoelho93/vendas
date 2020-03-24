package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.ProdutoEntity;
import br.com.vendas.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
		
	@Test
	public void createShouldPersistData() {
		ProdutoEntity produto1 = new ProdutoEntity();
		produto1.setPreco(1.50F);
		produto1.setDescricao("Pão");
		produto1.setIdProduto(123L);
		
		produtoRepository.save(produto1);
		Assertions.assertThat(produto1.getIdProduto()).isNotNull();
		Assertions.assertThat(produto1.getPreco()).isEqualTo(1.5F);
		Assertions.assertThat(produto1.getDescricao()).isEqualTo("Pão");
	}   
	@Test
	public void deleteShouldRemoveData() {
		ProdutoEntity produto2 = new ProdutoEntity();
		produto2.setPreco(1.50F);
		produto2.setDescricao("Pão");
		produto2.setIdProduto(123L);
		
		Assertions.assertThat(produto2.getIdProduto()).isNotNull();
		Assertions.assertThat(produto2.getPreco()).isEqualTo(1.5F);
		produto2.setIdProduto(123L);
		
		this.produtoRepository.save(produto2);
		this.produtoRepository.delete(produto2);
		Assertions.assertThat(produtoRepository.findById(produto2.getIdProduto())).isNotNull();
		
	}
	@Test
	public void updateShouldChangeData() {
		ProdutoEntity produto3 = new ProdutoEntity();
		produto3.setPreco(1.50F);
		produto3.setDescricao("Pão");
		produto3.setIdProduto(123L);

		produto3.setDescricao("Leite");
		produto3.setPreco(3.0F);
		this.produtoRepository.save(produto3);
				
		Assertions.assertThat(produto3.getPreco()).isEqualTo(3.0F);
		Assertions.assertThat(produto3.getDescricao()).isEqualTo("Leite");
	
	}
	@Test
	public void findAllShouldShowAllData() {
		ProdutoEntity produto1 = new ProdutoEntity();
		ProdutoEntity produto2 = new ProdutoEntity();
		ProdutoEntity produto3 = new ProdutoEntity();
		
		produto1.setDescricao("Manteiga");
		produto1.setPreco(2.50F);
		produto2.setDescricao("Sal");
		produto2.setPreco(2.19F);
		produto3.setDescricao("Acucar");
		produto3.setPreco(2.0F);
		
		this.produtoRepository.save(produto1);
		this.produtoRepository.save(produto2);
		this.produtoRepository.save(produto3);

		Assertions.assertThat(produtoRepository.findAll()).isNotNull();
	}
}