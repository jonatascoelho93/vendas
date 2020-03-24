package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.FormaDePagamentoEntity;
import br.com.vendas.repository.FormaDePagamentoRepository;

//teste em banco real
//funciona apenas com findAll
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@RunWith(SpringRunner.class)
@DataJpaTest
public class FormaDePagamentoRepositoryTest {
	
	@Autowired
	private FormaDePagamentoRepository formaPgtoRep;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
		
	@Test
	public void createShouldPersistData() {
		FormaDePagamentoEntity formaPgto = new FormaDePagamentoEntity();
		formaPgto.setCodigoFormaDePgto(901l);
		formaPgto.setDescricaoFormaDePgto("À vista");
		this.formaPgtoRep.save(formaPgto);
		Assertions.assertThat(formaPgto.getIdFormaDePgto()).isNotNull();
		Assertions.assertThat(formaPgto.getCodigoFormaDePgto()).isEqualTo(901l);
		Assertions.assertThat(formaPgto.getDescricaoFormaDePgto()).isEqualTo("À vista");
	}
	@Test
	public void deleteShouldRemoveData() {
		FormaDePagamentoEntity formaPgto = new FormaDePagamentoEntity();
		formaPgto.setCodigoFormaDePgto(902l);
		formaPgto.setDescricaoFormaDePgto("A prazo");
		this.formaPgtoRep.save(formaPgto);
		this.formaPgtoRep.delete(formaPgto);
		Assertions.assertThat(formaPgtoRep.findById(formaPgto.getIdFormaDePgto())).isNotNull();
		
	}
	@Test
	public void updateShouldChangeData() {
		FormaDePagamentoEntity formaPgto = new FormaDePagamentoEntity();
		this.formaPgtoRep.save(formaPgto);
		
		formaPgto.setCodigoFormaDePgto(904l);
		formaPgto.setDescricaoFormaDePgto("À vista");
		formaPgto = this.formaPgtoRep.save(formaPgto);
		
		Assertions.assertThat(formaPgto.getCodigoFormaDePgto()).isEqualTo(904l);
		Assertions.assertThat(formaPgto.getDescricaoFormaDePgto()).isEqualTo("À vista");
		
	}
	@Test
	public void findAllShouldShowAllData() {
		FormaDePagamentoEntity formaPgto1 = new FormaDePagamentoEntity();
		FormaDePagamentoEntity formaPgto2 = new FormaDePagamentoEntity();
		FormaDePagamentoEntity formaPgto3 = new FormaDePagamentoEntity();
		
		formaPgto1.setCodigoFormaDePgto(904l);
		formaPgto1.setDescricaoFormaDePgto("À vista");
		
		formaPgto2.setCodigoFormaDePgto(905l);
		formaPgto2.setDescricaoFormaDePgto("A prazo");
		
		formaPgto3.setCodigoFormaDePgto(906l);
		formaPgto3.setDescricaoFormaDePgto("À vista");
		
		
		this.formaPgtoRep.save(formaPgto1);
		this.formaPgtoRep.save(formaPgto2);
		this.formaPgtoRep.save(formaPgto3);
		
		Assertions.assertThat(formaPgtoRep.findAll()).isNotNull();
	}
} 