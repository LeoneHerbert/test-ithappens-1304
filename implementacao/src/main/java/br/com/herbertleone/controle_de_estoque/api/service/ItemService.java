package br.com.herbertleone.controle_de_estoque.api.service;

import br.com.herbertleone.controle_de_estoque.api.model.Item;
import br.com.herbertleone.controle_de_estoque.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final GenericoService<Item> genericoService;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.genericoService = new GenericoService<Item>(itemRepository);
    }

    @Transactional
    public Item salva(Item item ) {
        return this.genericoService.salva(item);
    }

    @Transactional(readOnly = true)
    public Item buscaPor(Integer id) {
        return this.genericoService.buscaPor(id );
    }

    @Transactional(readOnly = true)
    public List<Item> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Item atualiza(Item item, Integer id) {
        return this.genericoService.atualiza(item, id);
    }

    @Transactional
    public void excluir(Integer id) {
        this.genericoService.excluirPor(id );
    }
}
