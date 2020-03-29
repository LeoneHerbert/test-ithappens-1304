package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
