package br.com.herbertleone.controle_de_estoque.api.model;

import br.com.herbertleone.controle_de_estoque.api.model.enums.FormaDePagamento;
import br.com.herbertleone.controle_de_estoque.api.model.enums.TipoDoPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "pedido_estoque")
public class PedidoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Filial filial;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "itens_pedido_id", nullable = false )
    private ItensPedido itensPedido;

    @Column(nullable = false)
    private String observacaoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDoPedido tipoDoPedido;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormaDePagamento formaDePagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estoque estoque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacaoEntrega() {
        return observacaoEntrega;
    }

    public void setObservacaoEntrega(String observacaoEntrega) {
        this.observacaoEntrega = observacaoEntrega;
    }

    public TipoDoPedido getTipoDoPedido() {
        return tipoDoPedido;
    }

    public void setTipoDoPedido(TipoDoPedido tipoDoPedido) {
        this.tipoDoPedido = tipoDoPedido;
    }

    public FormaDePagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public ItensPedido getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ItensPedido itensPedido) {
        this.itensPedido = itensPedido;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
