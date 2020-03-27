package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
