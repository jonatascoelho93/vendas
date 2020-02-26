package br.com.vendas.vendas.controller;

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

import br.com.vendas.vendas.repository.FormaDePagamentoEntity;
import br.com.vendas.vendas.repository.FormaDePagamentoRepository;

@RestController
@RequestMapping("/formadepagamento")
@CrossOrigin
public class FormaDePagamentoController {

	public static final Logger logger = LoggerFactory.getLogger(FormaDePagamentoController.class);

	@Autowired
	public FormaDePagamentoRepository formaDePamentoRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando listar formas de pagamento");
			return new ResponseEntity<>(formaDePamentoRepository.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Erro em listar formas de pagamento", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarFormaDePamento(@PathVariable(value = "id") Long id) {
		try {
			logger.info("Acesando busca de forma de pagamento por id");
			Optional<FormaDePagamentoEntity> entity = formaDePamentoRepository.findById(id);
			if (entity.isPresent()) {
				FormaDePagamentoEntity formaPgto = entity.get();
				return new ResponseEntity<>(formaPgto, HttpStatus.OK);
			} else {
				logger.info("Forma de pagamento não encontrada id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em procurar forma de pagamento por id");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<?> cadastrarFormaDePagamento(@RequestBody FormaDePagamentoEntity formaPgto) {
		try {
			logger.info("Acessando o sistema de cadastro de forma de pagamento");
			formaDePamentoRepository.save(formaPgto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Erro em cadastrar forma de pagamento", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarFormaDePagamento(@PathVariable(value = "id") Long id,
			@RequestBody FormaDePagamentoEntity formaPgto) {
		try {
			logger.info("Acessando sistema de alteração de forma de pagamento");
			Optional<FormaDePagamentoEntity> entity = formaDePamentoRepository.findById(id);
			if (entity.isPresent()) {
				formaPgto.setIdFormaDePgto(id);
				formaDePamentoRepository.save(formaPgto);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Forma de pagamento não encontrada id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em alterar forma de pagamento", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarFormaDePagamento(@PathVariable(value = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de forma de pagamento");
			Optional<FormaDePagamentoEntity> entity = formaDePamentoRepository.findById(id);
			if (entity.isPresent()) {
				formaDePamentoRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Forma de pagamento não encontrada id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em excluir forma de pagamento", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
