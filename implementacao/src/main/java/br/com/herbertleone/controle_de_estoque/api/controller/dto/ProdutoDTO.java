package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<Produto, ProdutoDTO> dto = new DTO<>(this);

    public ProdutoDTO() {  }

    public ProdutoDTO(Produto categoria) {
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
    public Produto getProduto() {
        return dto.getEntity(new Produto() );
    }

    public ProdutoDTO comDadosDe(Produto categoria) {
        return dto.comDadosDe(categoria );
    }

    public Produto atualizaIgnorandoNuloA(Produto categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
