package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.ItemDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
import br.com.herbertleone.controle_de_estoque.api.model.Item;
import br.com.herbertleone.controle_de_estoque.api.service.ItemService;
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
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> cria(@Validated @RequestBody Item item, HttpServletResponse response) {
        Item itemSalvo = itemService.salva(item);

        publisher.publishEvent(new HeaderLocationEvento(this, response, itemSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemSalvo);
    }

    @GetMapping
    public List<Item> todos() {
        return itemService.todos();
    }

    @GetMapping("/{id}")
    public Resposta<ItemDTO> buscaPor(@PathVariable Integer id) {
        Item item = itemService.buscaPor(id);
        return Resposta.comDadosDe(new ItemDTO(item));
    }

    @GetMapping("/{nome}")
    public Optional<Item> buscaPor(@PathVariable String nome) {
        return itemService.buscaPor(nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<ItemDTO>> atualiza(@PathVariable Integer id, @Validated @RequestBody ItemDTO itemDTO) {
        Item item = itemDTO.atualizaIgnorandoNuloA(itemService.buscaPor(id));

        List<Erro> erros = this.getErros(new ItemDTO(item));
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros));
        }

        Item itemAtualizado = itemService.atualiza(item, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new ItemDTO(itemAtualizado)));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull(erros) && !erros.isEmpty();
    }

    private List<Erro> getErros(ItemDTO dto) {
        Validacao<ItemDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
