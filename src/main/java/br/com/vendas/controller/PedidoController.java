package br.com.vendas.controller;

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

import br.com.vendas.repository.PedidoEntity;
import br.com.vendas.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoController {

	public static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	public PedidoRepository pedidoRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar pedidos");
			return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar pedidos", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de pedido por id");
			Optional<PedidoEntity> entity = pedidoRepository.findById(id);
			if (entity.isPresent()) {
				PedidoEntity pedidoEntity = entity.get();
				return new ResponseEntity<>(pedidoEntity, HttpStatus.OK);
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
	public ResponseEntity<?> cadastrarPedido(@RequestBody PedidoEntity pedidoEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de pedido");
			pedidoRepository.save(pedidoEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar pedido", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarPedido(@RequestBody PedidoEntity pedidoEntity, @PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de pedido");
			Optional<PedidoEntity> entity = pedidoRepository.findById(id);
			if (entity.isPresent()) {
				pedidoEntity.setIdPedido(id);
				pedidoRepository.save(pedidoEntity);
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
			Optional<PedidoEntity> entity = pedidoRepository.findById(id);
			if (entity.isPresent()) {
				pedidoRepository.deleteById(id);
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
