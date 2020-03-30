package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.ClienteDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
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
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
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
        Cliente clienteSalvo = clienteService.salva(cliente);

        publisher.publishEvent(new HeaderLocationEvento(this, response, clienteSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteSalvo);
    }

    @GetMapping
    public List<Cliente> todos() {
        return clienteService.todos();
    }

    @GetMapping("/{id}")
    public Resposta<ClienteDTO> buscaPor(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscaPor(id);
        return Resposta.comDadosDe(new ClienteDTO(cliente));
    }

    @GetMapping("/{nome}")
    public Optional<Cliente> buscaPor(@PathVariable String nome) {
        return clienteService.buscaPor(nome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<ClienteDTO>> atualiza(@PathVariable Integer id, @Validated @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.atualizaIgnorandoNuloA(clienteService.buscaPor(id));

        List<Erro> erros = this.getErros(new ClienteDTO(cliente));
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros));
        }

        Cliente clienteAtualizado = clienteService.atualiza(cliente, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new ClienteDTO(clienteAtualizado)));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull(erros) && !erros.isEmpty();
    }

    private List<Erro> getErros(ClienteDTO dto) {
        Validacao<ClienteDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}

