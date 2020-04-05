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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.repository.VendedoresEntity;
import br.com.vendas.repository.VendedoresRepository;

@RestController
@RequestMapping("/vendedores")
@CrossOrigin
public class VendedoresController {

	public static final Logger logger = LoggerFactory.getLogger(VendedoresController.class);

	@Autowired
	public VendedoresRepository vendedorRepository;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar Vendedores");			
			return new ResponseEntity<>(vendedorRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar vendedores", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarVendedores(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de Vendedores por id");
			Optional<VendedoresEntity> entity = vendedorRepository.findById(id);
			if (entity.isPresent()) {
				VendedoresEntity vendedorEntity = entity.get();
				return new ResponseEntity<>(vendedorEntity, HttpStatus.OK);
			} else {
				logger.info("Vendedor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar Vendedor por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarVendedor(@RequestBody VendedoresEntity vendedorEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de vendedores");
			vendedorRepository.save(vendedorEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar vendedor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterarVendedor(@RequestBody VendedoresEntity vendedorEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de vendedor");
			Optional<VendedoresEntity> entity = vendedorRepository.findById(id);
			if (entity.isPresent()) {
				vendedorEntity.setId(id);
				vendedorRepository.save(vendedorEntity);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Vendedor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar Vendedor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarVendedor(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de Vendedor");
			Optional<VendedoresEntity> entity = vendedorRepository.findById(id);
			if (entity.isPresent()) {
				vendedorRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("vendedor não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar vendedor", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/c")  // http://localhost:8080/vendedores/c?cod=*
	public ResponseEntity<?> buscarProdutoPorCod(@RequestParam(name = "cod") Long cod) {
		try {
			logger.info("Acesando busca de produtos por codigo");
			Optional<VendedoresEntity> entity = vendedorRepository.findByCodVendedor(cod);
			if (entity.isPresent()) {
				VendedoresEntity vendedorEntity = entity.get();
				return new ResponseEntity<>(vendedorEntity, HttpStatus.OK);
			} else {
				logger.info("Vendedor não encontrado cod:" + cod);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar vendedor por cod", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}