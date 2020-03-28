package br.com.herbertleone.controle_de_estoque.api.model;

import br.com.herbertleone.controle_de_estoque.api.model.enums.TipoDoPedido;

import javax.persistence.*;

public class PedidoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "pedidoFilial")
    private Filial filial;

    @OneToOne(mappedBy = "pedidoUsuario")
    private Usuario usuario;

    @OneToOne(mappedBy = "pedidoCliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String observacaoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDoPedido tipoDoPedido;

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
}
