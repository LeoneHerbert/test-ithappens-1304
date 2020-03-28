package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByNome(String nome);
}
