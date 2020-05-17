package br.com.vendas.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.repository.PedidoEntradaEntity;
import br.com.vendas.repository.PedidoEntradaItensEntity;
import br.com.vendas.repository.PedidoEntradaItensRepository;
import br.com.vendas.repository.PedidoEntradaRepository;

@RestController
@RequestMapping("/pedidosentradaitens")
@CrossOrigin
public class PedidoEntradaItensController {

	public static final Logger logger = LoggerFactory.getLogger(PedidoEntradaItensController.class);

	@Autowired
	public PedidoEntradaItensRepository pedidoEntradaItensRepository;

	@Autowired
	public PedidoEntradaRepository pedidoRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar pedidosItens");
			return new ResponseEntity<>(pedidoEntradaItensRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar pedidosItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de pedidoEntradaItens por id");
			Optional<PedidoEntradaItensEntity> entity = pedidoEntradaItensRepository.findById(id);
			if (entity.isPresent()) {
				PedidoEntradaItensEntity pedidoEntradaItensEntity = entity.get();
				return new ResponseEntity<>(pedidoEntradaItensEntity, HttpStatus.OK);
			} else {
				logger.info("PedidoEntradaItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar pedidoEntradaItens por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarPedidoEntradaItens(
			@RequestBody PedidoEntradaItensEntity pedidoEntradaItensEntity) {

		try {
			logger.info("Acessando o sitema de cadastro de pedidoEntradaItens");

			if (pedidoEntradaItensRepository.findByCodProdutoAndNumeroPedido(pedidoEntradaItensEntity.getCodProduto(),
					pedidoEntradaItensEntity.getNumeroPedido()).isPresent()) {

				logger.info("O intem já está no pedido COD:" + pedidoEntradaItensEntity.getCodProduto());
				return new ResponseEntity<>(
						"{'erro':'Pedido já possui o produto cod:'}" + pedidoEntradaItensEntity.getCodProduto(),
						HttpStatus.BAD_REQUEST);

			}

			PedidoEntradaEntity pedido = pedidoRepository.findById(pedidoEntradaItensEntity.getNumeroPedido()).get();
			pedido.setTotalProdutos(pedido.getTotalProdutos()
					+ pedidoEntradaItensEntity.getPreco() * pedidoEntradaItensEntity.getQuantidade());
			pedidoRepository.save(pedido);

			return new ResponseEntity<>(pedidoEntradaItensRepository.save(pedidoEntradaItensEntity),
					HttpStatus.CREATED);

		} catch (

		Exception e) {
			logger.error("Erro em cadastrar pedidoEntradaItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> alterarPedidoEntradaItens(@RequestBody PedidoEntradaItensEntity pedidoEntradaItensEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de pedidoEntradaItens");

			Optional<PedidoEntradaItensEntity> entity = pedidoEntradaItensRepository.findById(id);
			if (entity.isPresent()) {
				PedidoEntradaItensEntity itens = entity.get();

					pedidoEntradaItensEntity.setIdPedidoItens(id);
					pedidoEntradaItensEntity.setTotalItens(
							pedidoEntradaItensEntity.getPreco() * pedidoEntradaItensEntity.getQuantidade());

					PedidoEntradaEntity pedido = pedidoRepository.findById(pedidoEntradaItensEntity.getNumeroPedido()).get();
					pedido.setTotalProdutos(pedido.getTotalProdutos()
							+ pedidoEntradaItensEntity.getPreco() * pedidoEntradaItensEntity.getQuantidade()
							- itens.getTotalItens());
					pedidoRepository.save(pedido);

					return new ResponseEntity<>(pedidoEntradaItensRepository.save(pedidoEntradaItensEntity),
							HttpStatus.OK);
				} else {
				logger.info("PedidoEntradaItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar pedidoEntradaItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPedidoEntradaItens(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de pedidoEntradaItens");
			Optional<PedidoEntradaItensEntity> entity = pedidoEntradaItensRepository.findById(id);
			if (entity.isPresent()) {
				PedidoEntradaEntity pedido = pedidoRepository.findById(entity.get().getNumeroPedido()).get();
				pedido.setTotalProdutos(pedido.getTotalProdutos() -
				entity.get().getTotalItens());
				pedidoRepository.save(pedido);
				pedidoEntradaItensRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("PedidoEntradaItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar pedidoEntradaItens " + id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/p") // http://localhost:8080/pedidositens/p?numero=*
	public ResponseEntity<?> buscarItensPedido(@RequestParam(name = "numero") Long numero) {
		try {
			logger.info("Acesando busca de produtos por codigo");
			List<PedidoEntradaItensEntity> entity = pedidoEntradaItensRepository.findAllByNumeroPedido(numero);
			return new ResponseEntity<>(entity, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Erro em procurar produto por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}