package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.Cliente;
import br.com.herbertleone.controle_de_estoque.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final GenericoService<Cliente> genericoService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.genericoService = new GenericoService<Cliente>(clienteRepository);
    }

    @Transactional
    public Cliente salva(Cliente cliente ) {
        return this.genericoService.salva(cliente);
    }

    @Transactional(readOnly = true)
    public Cliente buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> buscaPor(String nome) {
        return Optional.ofNullable( clienteRepository.findByNome(nome ) );
    }

    @Transactional(readOnly = true)
    public List<Cliente> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Cliente atualiza(Cliente cliente, Integer id) {
        return this.genericoService.atualiza(cliente, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
