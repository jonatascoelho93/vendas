package br.com.vendas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItensRepository extends JpaRepository<PedidoItensEntity, Long> {
	
	List<PedidoItensEntity> findAllByNumeroPedido(Long numeroPedido);
	Optional<PedidoItensEntity> findByCodProdutoAndNumeroPedido(Long cod, Long numeroP);

}
