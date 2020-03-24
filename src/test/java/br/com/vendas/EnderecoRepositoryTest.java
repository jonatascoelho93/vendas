package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.EnderecoEntity;
import br.com.vendas.repository.EnderecoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
		
	@Test
	public void createShouldPersistData() {
		EnderecoEntity endereco1 = new EnderecoEntity();
		endereco1.setCep("12345-678");
		endereco1.setLogradouro("Av. Paulista");
		endereco1.setNumero("123");
		
		this.enderecoRepository.save(endereco1);
		Assertions.assertThat(endereco1.getIdEndereco()).isNotNull();
		Assertions.assertThat(endereco1.getLogradouro()).isEqualTo("Av. Paulista");
		Assertions.assertThat(endereco1.getNumero()).isEqualTo("123");
	}   
	@Test
	public void deleteShouldRemoveData() {
		EnderecoEntity endereco2 = new EnderecoEntity();
		endereco2.setCep("12345-678");
		endereco2.setLogradouro("Av. Paulista");
		endereco2.setNumero("123");
		this.enderecoRepository.save(endereco2);
		this.enderecoRepository.delete(endereco2);
		Assertions.assertThat(enderecoRepository.findById(endereco2.getIdEndereco())).isNotNull();
		
	}
	@Test
	public void updateShouldChangeData() {
		EnderecoEntity endereco3 = new EnderecoEntity();
		endereco3.setCep("87654-321");
		endereco3.setLogradouro("Av. Dos Andrades");
		endereco3.setComplementoNumero("321");
		this.enderecoRepository.save(endereco3);
				
		Assertions.assertThat(endereco3.getCep()).isEqualTo("87654-321");
		Assertions.assertThat(endereco3.getLogradouro()).isEqualTo("Av. Dos Andrades");
		Assertions.assertThat(endereco3.getComplementoNumero()).isEqualTo("321");
	
	}
	@Test
	public void findAllShouldShowAllData() {
		EnderecoEntity endereco1 = new EnderecoEntity();
		EnderecoEntity endereco2 = new EnderecoEntity();
		EnderecoEntity endereco3 = new EnderecoEntity();
		
		endereco1.setCep("12345-678");
		endereco1.setLogradouro("Av. Paulista");
		endereco1.setNumero("123");
		
		endereco2.setCep("12345-678");
		endereco2.setLogradouro("Av. Paulista");
		endereco2.setNumero("123");
		
		endereco3.setCep("87654-321");
		endereco3.setLogradouro("Av. Dos Andrades");
		endereco3.setComplementoNumero("321");
		
		this.enderecoRepository.save(endereco1);
		this.enderecoRepository.save(endereco2);
		this.enderecoRepository.save(endereco3);

		Assertions.assertThat(enderecoRepository.findAll()).isNotNull();
	}
}