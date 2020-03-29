package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.EstoqueDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
import br.com.herbertleone.controle_de_estoque.api.model.Estoque;
import br.com.herbertleone.controle_de_estoque.api.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<Estoque> cria(@Validated @RequestBody Estoque estoque, HttpServletResponse response) {
        Estoque estoqueSalvo = estoqueService.salva(estoque );

        publisher.publishEvent(new HeaderLocationEvento(this, response, estoqueSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estoqueSalvo );
    }

    @GetMapping
    public List<Estoque> todos() {
        return estoqueService.todos();
    }

    @GetMapping("/{id}")
    public Estoque buscaPor(@PathVariable Integer id) {
        return estoqueService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Estoque>> atualiza(@PathVariable Integer id, @Validated @RequestBody EstoqueDTO estoqueDTO ) {
        Estoque estoque = estoqueDTO.atualizaIgnorandoNuloA(estoqueService.buscaPor(id));

        List<Erro> erros = this.getErros(new EstoqueDTO(estoque) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        Estoque estoqueAtualizado = estoqueService.atualiza(estoque, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new EstoqueDTO(estoqueAtualizado )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(EstoqueDTO dto) {
        Validacao<EstoqueDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }

}

