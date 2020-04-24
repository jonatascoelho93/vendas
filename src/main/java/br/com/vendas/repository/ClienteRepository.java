package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	Optional<ClienteEntity> findByRegistroFederal(String registroFederal);
	Optional<ClienteEntity> findByCodCliente(Long codCliente);

}
