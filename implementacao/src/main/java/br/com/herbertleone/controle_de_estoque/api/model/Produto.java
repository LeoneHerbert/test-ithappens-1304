package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column
    private String nome;

    @NotEmpty
    @Column(unique = true)
    private String sequencial;

    @NotNull
    @Column(unique = true)
    private Integer codigoDeBarras;

    @NotEmpty
    @Column(unique = true)
    private String descricao;

    @NotNull
    @Column
    private BigDecimal valorUnitarioProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estoque estoque;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ItensPedido itensPedido;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSequencial() {
        return sequencial;
    }

    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    public Integer getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(Integer codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ItensPedido getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ItensPedido itensPedido) {
        this.itensPedido = itensPedido;
    }

    public BigDecimal getValorUnitarioProduto() {
        return valorUnitarioProduto;
    }

    public void setValorUnitarioProduto(BigDecimal valorUnitarioProduto) {
        this.valorUnitarioProduto = valorUnitarioProduto;
    }
}