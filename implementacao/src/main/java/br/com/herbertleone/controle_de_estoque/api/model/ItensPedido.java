package br.com.herbertleone.controle_de_estoque.api.model;

import br.com.herbertleone.controle_de_estoque.api.model.enums.StatusItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido implements CalculoValorTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @NotNull
    @Min(0)
    @Column
    private Integer quantidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusItem statusItem;

    @ManyToOne(fetch = FetchType.LAZY)
    private PedidoEstoque pedidoEstoque;

    @NotNull
    @Column
    private BigDecimal valorUnitarioItem;

    @PrePersist
    private void prePersist() {
        this.valorUnitarioItem = produto.getValorUnitarioProduto();
    }

    @Transient
    @JsonIgnore
    public BigDecimal valorTotal(){
        BigDecimal valor = new BigDecimal(quantidade);
        return valorUnitarioItem.multiply(valor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

    public PedidoEstoque getPedidoEstoque() {
        return pedidoEstoque;
    }

    public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
        this.pedidoEstoque = pedidoEstoque;
    }

    public void setValorUnitarioItem(BigDecimal valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
