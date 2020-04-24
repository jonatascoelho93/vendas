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

import br.com.vendas.repository.EstoqueEntity;
import br.com.vendas.repository.EstoqueRepository;
import br.com.vendas.repository.PedidoItensEntity;
import br.com.vendas.repository.PedidoItensRepository;

@RestController
@RequestMapping("/pedidositens")
@CrossOrigin
public class PedidoItensController {

	public static final Logger logger = LoggerFactory.getLogger(PedidoItensController.class);

	@Autowired
	public PedidoItensRepository pedidoItensRepository;

	@Autowired
	public EstoqueRepository estoqueRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar pedidosItens");
			return new ResponseEntity<>(pedidoItensRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar pedidosItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de pedidoItens por id");
			Optional<PedidoItensEntity> entity = pedidoItensRepository.findById(id);
			if (entity.isPresent()) {
				PedidoItensEntity pedidoItensEntity = entity.get();
				return new ResponseEntity<>(pedidoItensEntity, HttpStatus.OK);
			} else {
				logger.info("PedidoItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar pedidoItens por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarPedidoItens(@RequestBody PedidoItensEntity pedidoItensEntity) {

		try {
			logger.info("Acessando o sitema de cadastro de pedidoItens");

			if (pedidoItensRepository.findByCodProdutoAndNumeroPedido(pedidoItensEntity.getCodProduto(),
					pedidoItensEntity.getNumeroPedido()).isPresent()) {

				logger.info("O intem já está no pedido COD:" + pedidoItensEntity.getCodProduto());
				return new ResponseEntity<>(
						"{'erro':'Pedido já possui o produto cod:'}" + pedidoItensEntity.getCodProduto(),
						HttpStatus.BAD_REQUEST);

			} else {
				EstoqueEntity estoqueEntity = estoqueRepository.findByCodProduto(pedidoItensEntity.getCodProduto());

				if (estoqueEntity.getQtdSaldo() >= pedidoItensEntity.getQuantidade()) {
					estoqueEntity.setQtdVendida(estoqueEntity.getQtdVendida() + pedidoItensEntity.getQuantidade());
					estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - estoqueEntity.getQtdVendida());
					estoqueRepository.save(estoqueEntity);
					return new ResponseEntity<>(pedidoItensRepository.save(pedidoItensEntity), HttpStatus.CREATED);
				} else {
					logger.info("Quantidade solicita indisponivel COD:" + pedidoItensEntity.getCodProduto() + " QTD:"
							+ pedidoItensEntity.getQuantidade());
					return new ResponseEntity<>(
							"{'erro':'Quantidade solicita indisponivel saldo:'}" + estoqueEntity.getQtdSaldo(),
							HttpStatus.BAD_REQUEST);
				}
			}

		} catch (Exception e) {
			logger.error("Erro em cadastrar pedidoItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> alterarPedidoItens(@RequestBody PedidoItensEntity pedidoItensEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de pedidoItens");

			Optional<PedidoItensEntity> entity = pedidoItensRepository.findById(id);
			if (entity.isPresent()) {
				PedidoItensEntity itens = entity.get();
				EstoqueEntity estoqueEntity = estoqueRepository.findByCodProduto(pedidoItensEntity.getCodProduto());
				estoqueEntity.setQtdSaldo(estoqueEntity.getQtdVendida() - itens.getQuantidade());
				estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - estoqueEntity.getQtdVendida());

				if (estoqueEntity.getQtdSaldo() >= pedidoItensEntity.getQuantidade()) {
					estoqueEntity.setQtdVendida(estoqueEntity.getQtdVendida() + pedidoItensEntity.getQuantidade());
					estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - estoqueEntity.getQtdVendida());
					estoqueRepository.save(estoqueEntity);

					pedidoItensEntity.setIdPedidoItens(id);
					pedidoItensEntity.setTotalItens(pedidoItensEntity.getPreco() * pedidoItensEntity.getQuantidade());
					return new ResponseEntity<>(pedidoItensRepository.save(pedidoItensEntity), HttpStatus.OK);
				} else {
					logger.info("Quantidade solicita indisponivel COD:" + pedidoItensEntity.getCodProduto() + " QTD:"
							+ pedidoItensEntity.getQuantidade());
					return new ResponseEntity<>(
							"{'erro':'Quantidade solicita indisponivel saldo:'}" + estoqueEntity.getQtdSaldo(),
							HttpStatus.BAD_REQUEST);
				}
			} else {
				logger.info("PedidoItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar pedidoItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPedidoItens(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de pedidoItens");
			Optional<PedidoItensEntity> entity = pedidoItensRepository.findById(id);
			if (entity.isPresent()) {
				EstoqueEntity estoqueEntity = estoqueRepository.findByCodProduto(entity.get().getCodProduto());
				estoqueEntity.setQtdSaldo(estoqueEntity.getQtdVendida() - entity.get().getQuantidade());
				estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - estoqueEntity.getQtdVendida());
				pedidoItensRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("PedidoItens não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar pedidoItens", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/p") // http://localhost:8080/pedidositens/p?numero=*
	public ResponseEntity<?> buscarItensPedido(@RequestParam(name = "numero") Long numero) {
		try {
			logger.info("Acesando busca de produtos por codigo");
			List<PedidoItensEntity> entity = pedidoItensRepository.findAllByNumeroPedido(numero);
			return new ResponseEntity<>(entity, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Erro em procurar produto por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}