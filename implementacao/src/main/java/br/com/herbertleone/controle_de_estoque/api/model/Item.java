package br.com.herbertleone.controle_de_estoque.api.model;

import br.com.herbertleone.controle_de_estoque.api.model.enums.StatusItem;

import javax.persistence.*;

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "item")
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private double valorUnitario;

    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne
    private ItensPedido itensPedido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusItem statusItem;
}
