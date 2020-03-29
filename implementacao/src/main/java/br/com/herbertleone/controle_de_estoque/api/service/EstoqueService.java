package br.com.herbertleone.controle_de_estoque.api.service;


import br.com.herbertleone.controle_de_estoque.api.model.Estoque;
import br.com.herbertleone.controle_de_estoque.api.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    private final GenericoService<Estoque> genericoService;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
        this.genericoService = new GenericoService<Estoque>(estoqueRepository);
    }

    @Transactional
    public Estoque salva(Estoque estoque ) {
        return this.genericoService.salva(estoque);
    }

    @Transactional(readOnly = true)
    public Estoque buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public List<Estoque> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Estoque atualiza(Estoque estoque, Integer id) {
        return this.genericoService.atualiza(estoque, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
