package br.com.vendas;



import javax.print.DocFlavor.URL;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendas.repository.ClienteEntity;
import br.com.vendas.repository.ClienteRepository;
import br.com.vendas.repository.FormaDePagamentoEntity;
import br.com.vendas.repository.FormaDePagamentoRepository;
import br.com.vendas.repository.PedidoEntity;
import br.com.vendas.repository.PedidoRepository;
import br.com.vendas.repository.VendedoresEntity;
import br.com.vendas.repository.VendedoresRepository;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidosRepositoryTeste extends TestCase {
	
	URL url = new URL("http://localhost:8080");
	
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	public ClienteRepository cliente;
	@Autowired
	public FormaDePagamentoRepository pgto;
	@Autowired
	public VendedoresRepository vendedor;
	@Autowired
	public PedidoRepository pedido;
	
	@Test
	public void testeCabecalhoPedidos(){
		
		
		
		ClienteEntity cliente1 = cliente.findByCodCliente(10001L).get();
		ClienteEntity cliente2 = cliente.findByCodCliente(10002L).get();
		
		FormaDePagamentoEntity pgto1 = pgto.findByCodigoFormaDePgto(901L).get();
		FormaDePagamentoEntity pgto2 = pgto.findByCodigoFormaDePgto(902L).get();
		
		VendedoresEntity vendedor1 = vendedor.findByCodVendedor(901L).get();
		VendedoresEntity vendedor2 = vendedor.findByCodVendedor(902L).get();
		
		PedidoEntity pedido1 = new PedidoEntity();
		PedidoEntity pedido2 = new PedidoEntity();
		
		//Pedido 1
		pedido1.setCodCliente(cliente1.getCodCliente());
		pedido1.setRegistroFederal(cliente1.getRegistroFederal());
		pedido1.setNomeCliente(cliente1.getNomeCompleto());
		pedido1.setRazaoSocial(cliente1.getRazaoSocial());
		pedido1.setCodVendedor(vendedor1.getCodVendedor());
		pedido1.setNomeVendedor(vendedor1.getNome());
		pedido1.setCodFormaPgto(pgto1.getCodigoFormaDePgto());
		pedido1.setDescricaoFormaPgto(pgto1.getDescricaoFormaDePgto());
		pedido.save(pedido1);
		
		//Pedido 2
		pedido2.setCodCliente(cliente2.getCodCliente());
		pedido2.setRegistroFederal(cliente2.getRegistroFederal());
		pedido2.setNomeCliente(cliente2.getNomeCompleto());
		pedido2.setRazaoSocial(cliente2.getRazaoSocial());
		pedido2.setCodVendedor(vendedor2.getCodVendedor());
		pedido2.setNomeVendedor(vendedor2.getNome());
		pedido2.setCodFormaPgto(pgto2.getCodigoFormaDePgto());
		pedido2.setDescricaoFormaPgto(pgto2.getDescricaoFormaDePgto());
		pedido.save(pedido2);

		Assertions.assertThat(pedido1.getIdPedido()).isNotNull();
		Assertions.assertThat(pedido2.getIdPedido()).isNotNull();
		
		
		
	}

}
