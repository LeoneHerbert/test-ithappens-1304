package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.Produto;
import br.com.herbertleone.controle_de_estoque.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    private final GenericoService<Produto> genericoService;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        this.genericoService = new GenericoService<Produto>(produtoRepository);
    }

    @Transactional
    public Produto salva(Produto produto ) {
        return this.genericoService.salva(produto);
    }

    @Transactional(readOnly = true)
    public Produto buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }


    @Transactional(readOnly = true)
    public List<Produto> todos() {
        return genericoService.todos();
    }

    @Transactional(readOnly = true)
    public Optional<Produto> buscaPor(String nome) {
        return Optional.ofNullable( produtoRepository.findByNome(nome ) );
    }


    @Transactional
    public Produto atualiza(Produto produto, Integer id) {
        return this.genericoService.atualiza(produto, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
