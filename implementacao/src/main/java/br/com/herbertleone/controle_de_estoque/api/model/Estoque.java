package br.com.herbertleone.controle_de_estoque.api.model;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "estoque")
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId
    private Filial filial;

    @OneToMany(mappedBy = "estoque", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> itens = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer quantidade(){
        return itens.stream()
                .mapToInt(item -> item.getQuantidade())
                .sum();
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
}