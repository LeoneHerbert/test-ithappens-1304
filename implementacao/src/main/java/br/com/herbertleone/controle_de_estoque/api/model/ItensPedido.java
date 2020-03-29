package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(
            mappedBy = "itensPedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Item> itens = new LinkedHashSet<>();

    @Column(nullable = false)
    private BigDecimal valorTotalDoPedido;

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

    public BigDecimal getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }
}
