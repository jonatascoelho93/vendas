package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.FormaDePagamentoEntity;
import br.com.vendas.repository.FormaDePagamentoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FormaDePagamentoRepositoryTest {
	
	@Autowired
	private FormaDePagamentoRepository formaPgtoRep;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		FormaDePagamentoEntity formaPgto = new FormaDePagamentoEntity(901l, "Avista");
		this.formaPgtoRep.save(formaPgto);
		Assertions.assertThat(formaPgto.getIdFormaDePgto()).isNotNull();
		Assertions.assertThat(formaPgto.getCodigoFormaDePgto()).isEqualTo(901l);
		Assertions.assertThat(formaPgto.getDescricaoFormaDePgto()).isEqualTo("Avista");
	}
	
	

}
 