package br.com.herbertleone.controle_de_estoque.api.repository;

import br.com.herbertleone.controle_de_estoque.api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> { }