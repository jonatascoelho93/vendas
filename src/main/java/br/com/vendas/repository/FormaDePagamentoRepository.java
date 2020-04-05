package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface FormaDePagamentoRepository extends CrudRepository<FormaDePagamentoEntity, Long> {
	
	Optional<FormaDePagamentoEntity> findByCodigoFormaDePgto(Long codigoFormaDePgto);

}
