package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	
	Optional<ProdutoEntity> findByCodProduto(Long cod);

}
