package br.com.herbertleone.controle_de_estoque.api.controller;

import br.com.herbertleone.controle_de_estoque.api.controller.dto.UsuarioDTO;
import br.com.herbertleone.controle_de_estoque.api.controller.event.HeaderLocationEvento;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Erro;
import br.com.herbertleone.controle_de_estoque.api.controller.response.Resposta;
import br.com.herbertleone.controle_de_estoque.api.controller.validation.Validacao;
import br.com.herbertleone.controle_de_estoque.api.model.Usuario;
import br.com.herbertleone.controle_de_estoque.api.service.UsuarioService;
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
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cria(@Validated @RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalvo = usuarioService.salva(usuario );

        publisher.publishEvent(new HeaderLocationEvento(this, response, usuarioSalvo.getId()) );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioSalvo );
    }

    @GetMapping
    public List<Usuario> todos() {
        return usuarioService.todos();
    }

    @GetMapping("/{id}")
    public Usuario buscaPor(@PathVariable Integer id) {
        return usuarioService.buscaPor(id );
    }

    @GetMapping("/{nome}")
    public Optional<Usuario> buscaPor(@PathVariable String nome) {
        return usuarioService.buscaPor(nome );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Usuario>> atualiza(@PathVariable Integer id, @Validated @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.atualizaIgnorandoNuloA(usuarioService.buscaPor(id));

        List<Erro> erros = this.getErros(new UsuarioDTO(usuario) );
        if (existe(erros)) {
            return ResponseEntity.badRequest().body(Resposta.com(erros) );
        }

        Usuario usuarioAtualizado = usuarioService.atualiza(usuario, id);
        return ResponseEntity.ok(Resposta.comDadosDe(new UsuarioDTO(usuarioAtualizado )));
    }

    private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(UsuarioDTO dto) {
        Validacao<UsuarioDTO> validacao = new Validacao<>();
        return validacao.valida(dto);
    }
}
