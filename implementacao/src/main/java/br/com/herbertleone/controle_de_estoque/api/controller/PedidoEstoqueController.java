package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.PedidoEstoqueDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
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
import java.util.Objects;

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
    public ResponseEntity<Resposta<PedidoEstoque>> atualiza(@PathVariable Integer id, @Validated @RequestBody PedidoEstoqueDTO pedidoEstoqueDTO) {
        PedidoEstoque pedidoEstoque = pedidoEstoqueDTO.atualizaIgnorandoNuloA(pedidoEstoqueService.buscaPor(id));

        List<Erro> erros = this.getErros(new PedidoEstoqueDTO(pedidoEstoque) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        PedidoEstoque pedidoEstoqueAtualizado = pedidoEstoqueService.atualiza(pedidoEstoque, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new PedidoEstoqueDTO(pedidoEstoqueAtualizado )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(PedidoEstoqueDTO dto) {
        Validacao<PedidoEstoqueDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
