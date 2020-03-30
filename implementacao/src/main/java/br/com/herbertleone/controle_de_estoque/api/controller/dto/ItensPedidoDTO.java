package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.ItensPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class ItensPedidoDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @JsonProperty("produtos")
    private Set<ProdutoDTO> produtosDTO = new LinkedHashSet<>();

    @NotNull
    private BigDecimal valorTotalDoPedido;

    private DTO<ItensPedido, ItensPedidoDTO> dto = new DTO<>(this);

    public ItensPedidoDTO() {  }

    public ItensPedidoDTO(ItensPedido produtosPedido) {
        this.comDadosDe(produtosPedido );
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
    public ItensPedido getItensPedido() {
        return dto.getEntity(new ItensPedido() );
    }

    public ItensPedidoDTO comDadosDe(ItensPedido produtosPedido) {
        return dto.comDadosDe(produtosPedido );
    }

    public ItensPedido atualizaIgnorandoNuloA(ItensPedido produtosPedido) {
        return dto.mergeIgnorandoNulo(produtosPedido );
    }


    @Override
    public String toString() {
        return "ItensPedidoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", produtos='" + produtosDTO.toString() + '\'' +
                '}';
    }

    public BigDecimal getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }
}
