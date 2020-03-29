package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<Cliente, ClienteDTO> dto = new DTO<>(this);

    public ClienteDTO() {  }

    public ClienteDTO(Cliente categoria) {
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
    public Cliente getCliente() {
        return dto.getEntity(new Cliente() );
    }

    public ClienteDTO comDadosDe(Cliente categoria) {
        return dto.comDadosDe(categoria );
    }

    public Cliente atualizaIgnorandoNuloA(Cliente categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
