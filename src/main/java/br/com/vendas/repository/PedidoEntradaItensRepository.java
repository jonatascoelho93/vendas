package br.com.vendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoEntradaItensRepository extends JpaRepository<PedidoEntradaItensEntity, Long>{
	
	List<PedidoEntradaItensEntity> findAllByNumeroPedido(Long numeroPedido);
	Optional<PedidoEntradaItensEntity> findByCodProdutoAndNumeroPedido(Long cod, Long numeroP);


}
