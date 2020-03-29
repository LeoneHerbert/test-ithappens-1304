package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Filial;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FilialDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<Filial, FilialDTO> dto = new DTO<>(this);

    public FilialDTO() {  }

    public FilialDTO(Filial categoria) {
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
    public Filial getFilial() {
        return dto.getEntity(new Filial() );
    }

    public FilialDTO comDadosDe(Filial categoria) {
        return dto.comDadosDe(categoria );
    }

    public Filial atualizaIgnorandoNuloA(Filial categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "FilialDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
