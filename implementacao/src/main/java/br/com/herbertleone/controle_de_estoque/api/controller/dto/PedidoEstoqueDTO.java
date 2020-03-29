package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.PedidoEstoque;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PedidoEstoqueDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<PedidoEstoque, PedidoEstoqueDTO> dto = new DTO<>(this);

    public PedidoEstoqueDTO() {  }

    public PedidoEstoqueDTO(PedidoEstoque categoria) {
        this.comDadosDe(categoria );
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

    public String getDescricao() {
        return cpf;
    }

    public void setDescricao(String descricao) {
        this.cpf = descricao;
    }


    @JsonIgnore
    public PedidoEstoque getPedidoEstoque() {
        return dto.getEntity(new PedidoEstoque() );
    }

    public PedidoEstoqueDTO comDadosDe(PedidoEstoque categoria) {
        return dto.comDadosDe(categoria );
    }

    public PedidoEstoque atualizaIgnorandoNuloA(PedidoEstoque categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "PedidoEstoqueDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
