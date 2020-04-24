package br.com.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {
	
	EstoqueEntity findByCodProduto(Long cod);

}
