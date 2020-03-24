package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.VendedorEntity;
import br.com.vendas.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VendedorRepositoryTest {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
		
	@Test
	public void createShouldPersistData() {
		VendedorEntity vendedor1 = new VendedorEntity();
		vendedor1.setNome("Leandro");
		vendedor1.setEmailVendedor("leandro@leandro.com");
		vendedor1.setCelular(123456789L);
		
		this.vendedorRepository.save(vendedor1);
		Assertions.assertThat(vendedor1.getId()).isNotNull();
		Assertions.assertThat(vendedor1.getNome()).isEqualTo("Leandro");
		Assertions.assertThat(vendedor1.getEmailVendedor()).isEqualTo("leandro@leandro.com");
		Assertions.assertThat(vendedor1.getCelular()).isEqualTo(123456789L);
		
	}   
	@Test
	public void deleteShouldRemoveData() {
		VendedorEntity vendedor1 = new VendedorEntity();
		vendedor1.setNome("Leandro");
		vendedor1.setEmailVendedor("leandro@leandro.com");
		vendedor1.setTelefone(123456789l);
		
		this.vendedorRepository.save(vendedor1);
		this.vendedorRepository.delete(vendedor1);
		Assertions.assertThat(vendedorRepository.findById(vendedor1.getId())).isNotNull();
		
	}
	@Test
	public void updateShouldChangeData() {
		VendedorEntity vendedor1 = new VendedorEntity();
		vendedor1.setNome("Maria");
		vendedor1.setEmailVendedor("maria@maria.com");
		vendedor1.setCelular(987654321L);
		this.vendedorRepository.save(vendedor1);
		
		Assertions.assertThat(vendedor1.getNome()).isEqualTo("Maria");
		Assertions.assertThat(vendedor1.getEmailVendedor()).isEqualTo("maria@maria.com");
		Assertions.assertThat(vendedor1.getCelular()).isEqualTo(987654321L);
	
	}
	@Test
	public void findAllShouldShowAllData() {
		VendedorEntity vendedor1 = new VendedorEntity();
		VendedorEntity vendedor2 = new VendedorEntity();
		VendedorEntity vendedor3 = new VendedorEntity();
		
		vendedor1.setNome("Leandro");
		vendedor1.setEmailVendedor("leandro@leandro.com");
		vendedor1.setTelefone(123456789l);
		vendedor2.setNome("Lucas");
		vendedor2.setEmailVendedor("lucas@lucas.com");
		vendedor2.setTelefone(202012122L);
		vendedor3.setNome("Sabrina");
		vendedor3.setEmailVendedor("sabrina@sabrina.com");
		vendedor3.setTelefone(303013131L);
		
		this.vendedorRepository.save(vendedor1);
		this.vendedorRepository.save(vendedor2);
		this.vendedorRepository.save(vendedor3);

		Assertions.assertThat(vendedorRepository.findAll()).isNotNull();
	}
}