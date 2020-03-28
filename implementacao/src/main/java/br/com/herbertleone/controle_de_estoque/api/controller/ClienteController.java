package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.model.Cliente;
import br.com.herbertleone.controle_de_estoque.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cria(@Validated @RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvo = clienteService.salva(cliente );

        publisher.publishEvent(new HeaderLocationEvento(this, response, clienteSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteSalvo );
    }

    @GetMapping
    public List<Cliente> todos() {
        return clienteService.todos();
    }

    @GetMapping("/{id}")
    public Cliente buscaPor(@PathVariable Integer id) {
        return clienteService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Cliente> buscaPor(@PathVariable String nome) {
        return clienteService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@PathVariable Integer id, @Validated @RequestBody Cliente cliente) {
        Cliente clienteManager = clienteService.atualiza(cliente, id );
        return ResponseEntity.ok(clienteManager );
    }

}

