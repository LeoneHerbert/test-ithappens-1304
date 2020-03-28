package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.model.PedidoEstoque;
import br.com.herbertleone.controle_de_estoque.api.service.PedidoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/pedidoestoque")
public class PedidoEstoqueController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final PedidoEstoqueService pedidoEstoqueService;

    @Autowired
    public PedidoEstoqueController(PedidoEstoqueService pedidoEstoqueService) {
        this.pedidoEstoqueService = pedidoEstoqueService;
    }

    @PostMapping
    public ResponseEntity<PedidoEstoque> cria(@Validated @RequestBody PedidoEstoque pedidoEstoque, HttpServletResponse response) {
        PedidoEstoque pedidoEstoqueSalvo = pedidoEstoqueService.salva(pedidoEstoque);

        publisher.publishEvent(new HeaderLocationEvento(this, response, pedidoEstoqueSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoEstoqueSalvo );
    }

    @GetMapping
    public List<PedidoEstoque> todos() {
        return pedidoEstoqueService.todos();
    }

    @GetMapping("/{id}")
    public PedidoEstoque buscaPor(@PathVariable Integer id) {
        return pedidoEstoqueService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoEstoque> atualiza(@PathVariable Integer id, @Validated @RequestBody PedidoEstoque pedidoEstoque) {
        PedidoEstoque pedidoEstoqueManager = pedidoEstoqueService.atualiza(pedidoEstoque, id );
        return ResponseEntity.ok(pedidoEstoqueManager );
    }
}
