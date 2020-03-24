package br.com.vendas;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.ClienteEntity;
import br.com.vendas.repository.ClienteRepository;

//teste em banco real
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createShouldPersistData() {
		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNomeCompleto("Anderson Moralez");
		cliente1.setEmail("anderson@anderson");
		this.clienteRepository.save(cliente1);
		
		Assertions.assertThat(cliente1.getIdCliente()).isNotNull();
		Assertions.assertThat(cliente1.getNomeCompleto()).isEqualTo("Anderson Moralez");
		Assertions.assertThat(cliente1.getEmail()).isEqualTo("anderson@anderson");
		
	}
	@Test
	public void deleteShouldRemoveData() {
		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNomeCompleto("Anderson Moralez");
		cliente1.setEmail("anderson@anderson");
		this.clienteRepository.save(cliente1);
		this.clienteRepository.delete(cliente1);
		Assertions.assertThat(clienteRepository.findAll()).isNotNull();
	}
	@Test
	public void updateShouldRemoveData() {
		ClienteEntity cliente1 = new ClienteEntity();
		cliente1.setNomeCompleto("Anderson M P Moralez");
		cliente1.setEmail("adnderson@anderson.com");
		this.clienteRepository.save(cliente1);
		this.clienteRepository.delete(cliente1);
		Assertions.assertThat(clienteRepository.findAll()).isNotNull();
	}
	
}
