package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.ItensPedido;
import br.com.herbertleone.controle_de_estoque.api.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoService {
    private final ItensPedidoRepository itensPedidoRepository;

    private final GenericoService<ItensPedido> genericoService;

    @Autowired
    public ItensPedidoService(ItensPedidoRepository itensPedidoRepository) {
        this.itensPedidoRepository = itensPedidoRepository;
        this.genericoService = new GenericoService<ItensPedido>(itensPedidoRepository);
    }

    @Transactional
    public ItensPedido salva(ItensPedido itensPedido ) {
        return this.genericoService.salva(itensPedido);
    }

    @Transactional(readOnly = true)
    public ItensPedido buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public List<ItensPedido> todos() {
        return genericoService.todos();
    }

    @Transactional
    public ItensPedido atualiza(ItensPedido itensPedido, Integer id) {
        return this.genericoService.atualiza(itensPedido, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
