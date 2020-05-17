package br.com.vendas.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.repository.EstoqueEntity;
import br.com.vendas.repository.EstoqueRepository;
import br.com.vendas.repository.PedidoEntradaEntity;
import br.com.vendas.repository.PedidoEntradaItensEntity;
import br.com.vendas.repository.PedidoEntradaItensRepository;
import br.com.vendas.repository.PedidoEntradaRepository;

@RestController
@RequestMapping("/pedidosentrada")
@CrossOrigin
public class PedidoEntradaController {

	public static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	public PedidoEntradaRepository pedidoEntradaRepository;

	@Autowired
	public PedidoEntradaItensRepository pedidoItensRepository;
	
	@Autowired
	public EstoqueRepository estoqueRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar pedidos");
			return new ResponseEntity<>(pedidoEntradaRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar pedidos", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de pedido por id");
			Optional<PedidoEntradaEntity> entity = pedidoEntradaRepository.findById(id);
			if (entity.isPresent()) {
				PedidoEntradaEntity pedidoEntradaEntity = entity.get();
				return new ResponseEntity<>(pedidoEntradaEntity, HttpStatus.OK);
			} else {
				logger.info("Pedido não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar pedido por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarPedido(@RequestBody PedidoEntradaEntity pedidoEntradaEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de pedido");
			return new ResponseEntity<>(pedidoEntradaRepository.save(pedidoEntradaEntity), HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar pedido", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarPedido(@RequestBody PedidoEntradaEntity pedidoEntradaEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de pedido");
			Optional<PedidoEntradaEntity> entity = pedidoEntradaRepository.findById(id);
			if (entity.isPresent()) {
				pedidoEntradaEntity.setIdPedidoDeEntra(id);
				;
				pedidoEntradaRepository.save(pedidoEntradaEntity);

				if (pedidoEntradaEntity.getEntregue().equals("Sim")) {
					List<PedidoEntradaItensEntity> lista = pedidoItensRepository
							.findAllByNumeroPedido(pedidoEntradaEntity.getIdPedidoDeEntra());
					
					for(PedidoEntradaItensEntity item: lista) {
						EstoqueEntity estoqueEntity = estoqueRepository.findByCodProduto(item.getCodProduto());
						logger.info("1");
						estoqueEntity.setQtdEstoque(estoqueEntity.getQtdEstoque() + item.getQuantidade());
						logger.info("1");
						estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - estoqueEntity.getQtdVendida());
						logger.info("1");
						estoqueRepository.save(estoqueEntity);
						logger.info("1");
					}

				}

				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Pedido não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar pedido", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPedido(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de pedido");
			Optional<PedidoEntradaEntity> entity = pedidoEntradaRepository.findById(id);
			if (entity.isPresent()) {
				pedidoEntradaRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("Pedido não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar pedido", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}