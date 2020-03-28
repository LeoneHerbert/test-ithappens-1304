package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.PedidoEstoque;
import br.com.herbertleone.controle_de_estoque.api.repository.PedidoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoEstoqueService {
    private final PedidoEstoqueRepository pedidoEstoqueRepository;

    private final GenericoService<PedidoEstoque> genericoService;

    @Autowired
    public PedidoEstoqueService(PedidoEstoqueRepository pedidoEstoqueRepository) {
        this.pedidoEstoqueRepository = pedidoEstoqueRepository;
        this.genericoService = new GenericoService<PedidoEstoque>(pedidoEstoqueRepository);
    }

    @Transactional
    public PedidoEstoque salva(PedidoEstoque pedidoEstoque ) {
        return this.genericoService.salva(pedidoEstoque);
    }

    @Transactional(readOnly = true)
    public PedidoEstoque buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public List<PedidoEstoque> todos() {
        return genericoService.todos();
    }

    @Transactional
    public PedidoEstoque atualiza(PedidoEstoque pedidoEstoque, Integer id) {
        return this.genericoService.atualiza(pedidoEstoque, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
