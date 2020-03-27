package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilialRepository extends JpaRepository<Filial, Integer> {

}
