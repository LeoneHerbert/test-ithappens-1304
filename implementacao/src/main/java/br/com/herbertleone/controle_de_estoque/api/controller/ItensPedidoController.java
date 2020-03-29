package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.ItensPedidoDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
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
import java.util.Objects;

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
    public ResponseEntity<Resposta<ItensPedido>> atualiza(@PathVariable Integer id, @Validated @RequestBody ItensPedidoDTO itensPedidoDTO) {
        ItensPedido itensPedido = itensPedidoDTO.atualizaIgnorandoNuloA(itensPedidoService.buscaPor(id));

        List<Erro> erros = this.getErros(new ItensPedidoDTO(itensPedido) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        ItensPedido itensPedidoAtualizados = itensPedidoService.atualiza(itensPedido, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new ItensPedidoDTO(itensPedidoAtualizados )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(ItensPedidoDTO dto) {
        Validacao<ItensPedidoDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
