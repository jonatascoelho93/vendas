package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VendedoresRepository extends CrudRepository<VendedoresEntity, Long>{
	
	Optional<VendedoresEntity> findByCodVendedor(Long codVendedor);

}
