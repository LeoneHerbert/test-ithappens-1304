package br.com.herbertleone.controle_de_estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.herbertleone.controle_de_estoque.api.model")
public class ControleDeEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleDeEstoqueApplication.class, args);
	}

}
