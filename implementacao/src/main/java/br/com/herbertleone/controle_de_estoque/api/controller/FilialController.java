package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.FilialDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
import br.com.herbertleone.controle_de_estoque.api.model.Filial;
import br.com.herbertleone.controle_de_estoque.api.service.FilialService;
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
@RequestMapping("/filiais")
@CrossOrigin
public class FilialController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final FilialService filialService;

    @Autowired
    public FilialController(FilialService filialService) {
        this.filialService = filialService;
    }

    @PostMapping
    public ResponseEntity<Filial> cria(@Validated @RequestBody Filial filial, HttpServletResponse response) {
        Filial filialSalvo = filialService.salva(filial );

        publisher.publishEvent(new HeaderLocationEvento(this, response, filialSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(filialSalvo );
    }

    @GetMapping
    public List<Filial> todos() {
        return filialService.todos();
    }

    @GetMapping("/{id}")
    public Filial buscaPor(@PathVariable Integer id) {
        return filialService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Filial> buscaPor(@PathVariable String nome) {
        return filialService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Filial>> atualiza(@PathVariable Integer id, @Validated @RequestBody FilialDTO filialDTO) {
        Filial filial = filialDTO.atualizaIgnorandoNuloA(filialService.buscaPor(id));

        List<Erro> erros = this.getErros(new FilialDTO(filial) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        Filial filialAtualizada = filialService.atualiza(filial, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new FilialDTO(filialAtualizada )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(FilialDTO dto) {
        Validacao<FilialDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
