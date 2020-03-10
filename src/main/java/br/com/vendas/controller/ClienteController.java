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

import br.com.vendas.repository.ClienteEntity;
import br.com.vendas.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteController {

	public static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	public ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar clientes");
			return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar clientes", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCliente(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de clientes por id");
			Optional<ClienteEntity> entity = clienteRepository.findById(id);
			if (entity.isPresent()) {
				ClienteEntity clienteEntity = entity.get();
				return new ResponseEntity<>(clienteEntity, HttpStatus.OK);
			} else {
				logger.info("Cliente não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar cliente por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestBody ClienteEntity clienteEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de clientes");
			clienteRepository.save(clienteEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar cliente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCliente(@RequestBody ClienteEntity clienteEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de cliente");
			Optional<ClienteEntity> entity = clienteRepository.findById(id);
			if (entity.isPresent()) {
				clienteEntity.setIdCliente(id);
				clienteRepository.save(clienteEntity);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Cliente não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar cliente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCliente(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de cliente");
			Optional<ClienteEntity> entity = clienteRepository.findById(id);
			if (entity.isPresent()) {
				clienteRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("Cliente não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar cliente", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
