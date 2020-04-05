package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Long> {
	
	Optional<ProdutoEntity> findByCodProduto(Long cod);

}
