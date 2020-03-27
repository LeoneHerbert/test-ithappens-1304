package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.Filial;
import br.com.herbertleone.controle_de_estoque.api.repository.FilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FilialService {

    private final FilialRepository filialRepository;

    private final GenericoService<Filial> genericoService;

    @Autowired
    public FilialService(FilialRepository filialRepository) {
        this.filialRepository = filialRepository;
        this.genericoService = new GenericoService<Filial>(filialRepository);
    }

    @Transactional
    public Filial salva(Filial filial ) {
        return this.genericoService.salva(filial);
    }

    @Transactional(readOnly = true)
    public Filial buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public Optional<Filial> buscaPor(String nome) {
        return Optional.ofNullable( filialRepository.findByNome(nome ) );
    }

    @Transactional(readOnly = true)
    public List<Filial> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Filial atualiza(Filial filial, Integer id) {
        return this.genericoService.atualiza(filial, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
