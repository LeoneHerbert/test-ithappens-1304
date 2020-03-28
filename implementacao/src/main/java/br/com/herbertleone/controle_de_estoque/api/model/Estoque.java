package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "estoque")
    private Filial filial;

    @OneToMany(
            mappedBy = "estoque",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Produto> produtos = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}