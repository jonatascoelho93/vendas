package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedoresRepository extends JpaRepository<VendedoresEntity, Long>{
	
	Optional<VendedoresEntity> findByCodVendedor(Long codVendedor);
	Optional<VendedoresEntity> findByEmailVendedor(String emailVendedor);
	
	
	

}
