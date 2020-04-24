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

import br.com.vendas.repository.EstoqueEntity;
import br.com.vendas.repository.EstoqueRepository;

@RestController
@RequestMapping("/estoque")
@CrossOrigin
public class EstoqueController {

	public static final Logger logger = LoggerFactory.getLogger(EstoqueController.class);

	@Autowired
	public EstoqueRepository estoqueRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar estoque");

			return new ResponseEntity<>(estoqueRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar estoque", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarEstoque(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de estoque por id");
			Optional<EstoqueEntity> entity = estoqueRepository.findById(id);
			if (entity.isPresent()) {
				EstoqueEntity estoqueEntity = entity.get();
				return new ResponseEntity<>(estoqueEntity, HttpStatus.OK);
			} else {
				logger.info("Estoque não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar estoque por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarEstoque(@RequestBody EstoqueEntity estoqueEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de estoque");
			estoqueEntity.setQtdVendida(0L);
			estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque());
			estoqueRepository.save(estoqueEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar estoque", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarEstoque(@RequestBody EstoqueEntity estoqueEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de estoque");
			Optional<EstoqueEntity> entity = estoqueRepository.findById(id);
			estoqueEntity.setQtdSaldo(estoqueEntity.getQtdEstoque() - entity.get().getQtdVendida());
			if (entity.isPresent() && estoqueEntity.getQtdSaldo() >= 0) {
				estoqueEntity.setIdEstoque(id);
				estoqueEntity.setQtdVendida(entity.get().getQtdVendida());
				logger.info(estoqueEntity.getIdEstoque() + "," +estoqueEntity.getQtdVendida() + "," + estoqueEntity.getQtdSaldo());
				estoqueRepository.save(estoqueEntity);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Estoque não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar estoque", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarEstoque(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de estoque");
			Optional<EstoqueEntity> entity = estoqueRepository.findById(id);
			if (entity.isPresent()) {
				estoqueRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("Estoque não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar estoque", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}