package br.com.vendas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
	
	Optional<ClienteEntity> findByRegistroFederal(String registroFederal);

}
