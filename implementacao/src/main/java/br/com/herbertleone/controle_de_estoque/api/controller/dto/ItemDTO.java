package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Item;
import br.com.herbertleone.controle_de_estoque.api.model.enums.StatusItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Min(0)
    @Column
    private Integer quantidade;

    private BigDecimal valorUnitario;

    private EstoqueDTO estoqueDTO;

    private DTO<Item, ItemDTO> dto = new DTO<>(this);

    public ItemDTO() {  }

    public ItemDTO(Item item) {
        this.comDadosDe(item );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonIgnore
    public Item getItem() {
        return dto.getEntity(new Item() );
    }

    public ItemDTO comDadosDe(Item item) {
        return dto.comDadosDe(item );
    }

    public Item atualizaIgnorandoNuloA(Item item) {
        return dto.mergeIgnorandoNulo(item );
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public EstoqueDTO getEstoqueDTO() {
        return estoqueDTO;
    }

    public void setEstoqueDTO(EstoqueDTO estoqueDTO) {
        this.estoqueDTO = estoqueDTO;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preço='" + valorUnitario + '\'' +
                ", estoque='" + estoqueDTO.getNome() + '\'' +
                '}';
    }
}
