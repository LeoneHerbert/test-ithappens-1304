package br.com.herbertleone.controle_de_estoque.api.model;

import br.com.herbertleone.controle_de_estoque.api.model.enums.FormaDePagamento;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Item> itens = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormaDePagamento formaDePagamento;

    @Column(nullable = false)
    private double valorTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
