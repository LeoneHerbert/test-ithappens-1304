package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.PedidoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Integer> {
}
