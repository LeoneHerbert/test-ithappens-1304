package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;

@Entity
public class Filial {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedidoestoque_id", referencedColumnName = "id")
    private PedidoEstoque pedidoFilial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoque_id", referencedColumnName = "id")
    private Estoque estoque;

    @Column(nullable = false)
    private Integer quantidadeTotalDeProdutos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}