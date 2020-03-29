package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
        Item findByNome(String nome);
}
