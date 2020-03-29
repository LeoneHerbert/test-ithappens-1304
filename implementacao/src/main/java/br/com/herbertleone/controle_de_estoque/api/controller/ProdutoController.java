package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.ProdutoDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
import br.com.herbertleone.controle_de_estoque.api.model.Produto;
import br.com.herbertleone.controle_de_estoque.api.service.ProdutoService;
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
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ApplicationEventPublisher publisher;

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> cria(@Validated @RequestBody Produto produto, HttpServletResponse response) {
        Produto produtoSalvo = produtoService.salva(produto );

        publisher.publishEvent(new HeaderLocationEvento(this, response, produtoSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoSalvo );
    }

    @GetMapping
    public List<Produto> todos() {
        return produtoService.todos();
    }

    @GetMapping("/{id}")
    public Produto buscaPor(@PathVariable Integer id) {
        return produtoService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Produto> buscaPor(@PathVariable String nome) {
        return produtoService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Produto>> atualiza(@PathVariable Integer id, @Validated @RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.atualizaIgnorandoNuloA(produtoService.buscaPor(id));

        List<Erro> erros = this.getErros(new ProdutoDTO(produto) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        Produto produtoAtualizado = produtoService.atualiza(produto, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new ProdutoDTO(produtoAtualizado )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(ProdutoDTO dto) {
        Validacao<ProdutoDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
