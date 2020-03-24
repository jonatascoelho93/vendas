package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.CorEntity;
import br.com.vendas.repository.CorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CorRepositoryTest {

	@Autowired
	private CorRepository corRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		CorEntity cor1 = new CorEntity();
		cor1.setDescricaoCor("Rosa");
		this.corRepository.save(cor1);
		
		Assertions.assertThat(cor1.getIdCor()).isNotNull();
		Assertions.assertThat(cor1.getDescricaoCor()).isEqualTo("Rosa");
				
	}
	@Test
	public void deleteShouldRemoveData() {
		CorEntity cor2 = new CorEntity();
		cor2.setDescricaoCor("Preto");
		this.corRepository.save(cor2);
		this.corRepository.delete(cor2);
		
		Assertions.assertThat(corRepository.findById(cor2.getIdCor())).isNotNull();
		
	}
	@Test
	public void updateShouldChangeData() {
		CorEntity cor3 = new CorEntity();
		cor3.setDescricaoCor("Cinza");
		Assertions.assertThat(cor3.getDescricaoCor()).isEqualTo("Cinza");
	}
	@Test
	public void findAllShouldShowAllData() {
		CorEntity cor1 = new CorEntity();
		CorEntity cor2 = new CorEntity();
		CorEntity cor3 = new CorEntity();
		cor1.setDescricaoCor("Azul");
		cor2.setDescricaoCor("Branco");
		cor3.setDescricaoCor("Rosa");
		this.corRepository.save(cor1);
		this.corRepository.save(cor2);
		this.corRepository.save(cor3);
		
		Assertions.assertThat(corRepository.findAll()).isNotNull();
	
	}
}
