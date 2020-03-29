package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.ItensPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItensPedidoDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<ItensPedido, ItensPedidoDTO> dto = new DTO<>(this);

    public ItensPedidoDTO() {  }

    public ItensPedidoDTO(ItensPedido categoria) {
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
    public ItensPedido getItensPedido() {
        return dto.getEntity(new ItensPedido() );
    }

    public ItensPedidoDTO comDadosDe(ItensPedido categoria) {
        return dto.comDadosDe(categoria );
    }

    public ItensPedido atualizaIgnorandoNuloA(ItensPedido categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "ItensPedidoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
