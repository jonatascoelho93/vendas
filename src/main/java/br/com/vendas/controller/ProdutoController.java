package br.com.vendas.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
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

import br.com.vendas.repository.EstoqueRepository;
import br.com.vendas.repository.ProdutoEntity;
import br.com.vendas.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin
public class ProdutoController {
	
	public static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public EstoqueRepository estoqueRepository;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			logger.info("Acessando o sistema de listar produtos");
			NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
			
			List<ProdutoEntity> lista = produtoRepository.findAll();
			
			for(ProdutoEntity i : lista) {
				i.setDescricaoReduzida(moedaFormat.format(i.getPreco()));
			}
			
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Erro em listar produtos", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acesando busca de produtos por id");
			Optional<ProdutoEntity> entity = produtoRepository.findById(id);
			if (entity.isPresent()) {
				ProdutoEntity produtoEntity = entity.get();
				return new ResponseEntity<>(produtoEntity, HttpStatus.OK);
			} else {
				logger.info("Produto não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar produto por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoEntity produtoEntity) {
		try {
			logger.info("Acessando o sitema de cadastro de produto");
			produtoRepository.save(produtoEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			logger.error("Erro em cadastrar produto", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterarProduto(@RequestBody ProdutoEntity produtoEntity,
			@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de alteração de produto");
			Optional<ProdutoEntity> entity = produtoRepository.findById(id);
			if (entity.isPresent()) {
				produtoEntity.setIdProduto(id);
				produtoRepository.save(produtoEntity);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				logger.info("Produto não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em alterar produto", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable(name = "id") Long id) {
		try {
			logger.info("Acessando sistema de exclusão de produto");
			Optional<ProdutoEntity> entity = produtoRepository.findById(id);
			if (entity.isPresent()) {
				produtoRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				logger.info("Produto não encontrado id:" + id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			logger.error("Erro em deletar produto", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/p")  // http://localhost:8080/produtos/p?cod=*
	public ResponseEntity<?> buscarProdutoPorCod(@RequestParam(name = "cod") Long cod) {
		try {
			logger.info("Acesando busca de produtos por codigo");
			Optional<ProdutoEntity> entity = produtoRepository.findByCodProduto(cod);
			if (entity.isPresent()) {
				ProdutoEntity produtoEntity = entity.get();
				Long saldo = estoqueRepository.findByCodProduto(cod).getQtdSaldo();
				produtoEntity.setEstoque(saldo);
				return new ResponseEntity<>(produtoEntity, HttpStatus.OK);
			} else {
				logger.info("Produto não encontrado cod:" + cod);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error("Erro em procurar produto por id", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
