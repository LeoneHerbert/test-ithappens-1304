package br.com.herbertleone.controle_de_estoque.api.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "estoque")
public class Estoque {
    @EmbeddedId
    private EstoquePk id = new EstoquePk();

    @NotNull
    @Min(0)
    @Column(name = "quantidade_produtos")
    private Integer quantidadeProdutos;

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }

    public Filial getFilial() {
        return id.getFilial();
    }

    public void setFilial(Filial filial) {
        id.setFilial(filial);
    }

    public void adicionaEstoque(@Min(1) Integer quantidade) {
        this.setQuantidadeProdutos(this.getQuantidadeProdutos() + quantidade);
    }

    public void baixaEstoque(@Positive Integer quantidade)  {
        final int novaQuantidade = this.getQuantidadeProdutos() - quantidade;

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException
                    ("Não há disponibilidade no estoque de "
                            + quantidade + " itens do produto " + id.getProduto().getNome() + "."
                            + "Temos disponível apenas " + this.quantidadeProdutos + "itens" );
        }
        this.setQuantidadeProdutos(novaQuantidade );
    }


}