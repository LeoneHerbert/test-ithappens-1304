package br.com.herbertleone.controle_de_estoque.api.model;

import org.hibernate.validator.constraints.br.CPF;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column
    private String nome;

    @NotEmpty
    @CPF
    @Column(unique = true)
    private String cpf;

    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<PedidoEstoque> pedidosCliente = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<PedidoEstoque> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(Set<PedidoEstoque> pedidosCliente) {
        this.pedidosCliente = pedidosCliente;
    }
}