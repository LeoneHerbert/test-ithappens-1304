package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "estoque")
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId
    private Filial filial;

    @NotNull
    @Min(0)
    @Column(name = "quantidade_estoque")
    private Integer quantidadeProdutos;

    @ManyToOne
    private Produto produto;

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

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public void baixaEstoque(@Positive Integer quantidade)  {
        final int novaQuantidade = this.getQuantidadeProdutos() - quantidade;

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException
                    ("Não há disponibilidade no estoque de "
                            + quantidade + " itens do produto " + produto.getNome() + "."
                            + "Temos disponível apenas " + this.quantidadeProdutos + "itens" );
        }
        this.setQuantidadeProdutos(novaQuantidade );
    }

    public void adicionaEstoque(@Min(1) Integer quantidade) {
        this.setQuantidadeProdutos(this.getQuantidadeProdutos() + quantidade);
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}