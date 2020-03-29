package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements CalculoValorTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(
            mappedBy = "itensPedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Item> itens = new LinkedHashSet<>();

    @OneToOne(mappedBy = "itensPedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PedidoEstoque pedidoEstoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }

    @Override
    public BigDecimal valorTotal(){
        return itens.stream()
                .map(Item::getValorUnitario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
