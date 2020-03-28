package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.model.ItensPedido;
import br.com.herbertleone.controle_de_estoque.api.service.ItensPedidoService;
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
@RequestMapping("/itenspedido")
public class ItensPedidoController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final ItensPedidoService itensPedidoService;

    @Autowired
    public ItensPedidoController(ItensPedidoService itensPedidoService) {
        this.itensPedidoService = itensPedidoService;
    }

    @PostMapping
    public ResponseEntity<ItensPedido> cria(@Validated @RequestBody ItensPedido ItensPedido, HttpServletResponse response) {
        ItensPedido itensPedidoSalvo = itensPedidoService.salva(ItensPedido );

        publisher.publishEvent(new HeaderLocationEvento(this, response, itensPedidoSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itensPedidoSalvo );
    }

    @GetMapping
    public List<ItensPedido> todos() {
        return itensPedidoService.todos();
    }

    @GetMapping("/{id}")
    public ItensPedido buscaPor(@PathVariable Integer id) {
        return itensPedidoService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensPedido> atualiza(@PathVariable Integer id, @Validated @RequestBody ItensPedido ItensPedido) {
        ItensPedido itensPedidoManager = itensPedidoService.atualiza(ItensPedido, id );
        return ResponseEntity.ok(itensPedidoManager );
    }
}
