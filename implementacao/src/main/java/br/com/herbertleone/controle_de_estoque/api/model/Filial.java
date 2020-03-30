package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "filial")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column
    private String nome;

    @OneToMany(
            mappedBy = "filial",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PedidoEstoque> pedidosFilial = new LinkedHashSet<>();

    @OneToMany(mappedBy = "id.filial", cascade = CascadeType.ALL)
    private Set<Estoque> estoque = new LinkedHashSet<>();

    @OneToOne(mappedBy = "filial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPedidosFilial(Set<PedidoEstoque> pedidosFilial) {
        this.pedidosFilial = pedidosFilial;
    }

    public void setEstoque(Set<Estoque> estoque) {
        this.estoque = estoque;
    }
}