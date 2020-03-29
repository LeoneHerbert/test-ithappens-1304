package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Endereco;
import br.com.herbertleone.controle_de_estoque.api.model.Filial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

public class FilialDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    private Endereco endereco;

    @JsonProperty("filial")
    private EstoqueDTO estoqueDTO;

    @JsonProperty("pedidoestoque")
    private Set<PedidoEstoqueDTO> pedidoEstoqueDTO = new LinkedHashSet<>();

    private DTO<Filial, FilialDTO> dto = new DTO<>(this);

    public FilialDTO() {  }

    public FilialDTO(Filial filial) {
        this.comDadosDe(filial );
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
    public Filial getFilial() {
        return dto.getEntity(new Filial() );
    }

    public FilialDTO comDadosDe(Filial filial) {
        return dto.comDadosDe(filial );
    }

    public Filial atualizaIgnorandoNuloA(Filial filial) {
        return dto.mergeIgnorandoNulo(filial );
    }

    public Set<PedidoEstoqueDTO> getPedidoEstoqueDTO() {
        return pedidoEstoqueDTO;
    }

    public void setPedidoEstoqueDTO(Set<PedidoEstoqueDTO> pedidoEstoqueDTO) {
        this.pedidoEstoqueDTO = pedidoEstoqueDTO;
    }

    @Override
    public String toString() {
        return "FilialDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereço='" + endereco.toString() + '\'' +
                ", estoque='" + estoqueDTO.getNome() + '\'' +
                '}';
    }


}
