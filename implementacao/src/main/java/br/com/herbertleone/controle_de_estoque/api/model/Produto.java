package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private String codigoDeBarras;

    @NotEmpty
    @Column(unique = true)
    private String descricao;

    @NotNull
    @Column
    private BigDecimal valorUnitarioProduto;

    @OneToMany(mappedBy = "id.produto", cascade = CascadeType.ALL)
    private Set<Estoque> estoque = new LinkedHashSet<>();

    @OneToMany(
            mappedBy = "produto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ItensPedido> itensPedido = new LinkedHashSet<>();


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

    public BigDecimal getValorUnitarioProduto() {
        return valorUnitarioProduto;
    }

    public void setValorUnitarioProduto(BigDecimal valorUnitarioProduto) {
        this.valorUnitarioProduto = valorUnitarioProduto;
    }

    public void setEstoque(Set<Estoque> estoque) {
        this.estoque = estoque;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
}