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

import br.com.vendas.repository.CorEntity;
import br.com.vendas.repository.CorRepository;


@RestController
@RequestMapping("/cor")
@CrossOrigin
public class CorController {
	
	public static final Logger logger = LoggerFactory.getLogger(CorController.class);
	
	@Autowired
	public CorRepository corRepository;
	
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar Cores");
			return new ResponseEntity<>(corRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar cores", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarCor(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de cor por id");
			Optional<CorEntity> entity = corRepository.findById(id);
			if (entity.isPresent()) {
				CorEntity corEntity = entity.get();
				return new ResponseEntity<>(corEntity, HttpStatus.OK);
			} else {
				logger.info("Cor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar cor por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarCores(@RequestBody CorEntity corEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de cores");
			corRepository.save(corEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar cor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarCor(@RequestBody CorEntity corEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de cores");
			Optional<CorEntity> entity = corRepository.findById(id);
			if (entity.isPresent()) {
				corEntity.setIdCor(id);
				corRepository.save(corEntity);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Cor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar cor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCor(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de cor");
			Optional<CorEntity> entity = corRepository.findById(id);
			if (entity.isPresent()) {
				corRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("Cor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar cor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
