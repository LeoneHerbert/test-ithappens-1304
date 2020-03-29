package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private DTO<Usuario, UsuarioDTO> dto = new DTO<>(this);

    public UsuarioDTO() {  }

    public UsuarioDTO(Usuario categoria) {
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
    public Usuario getUsuario() {
        return dto.getEntity(new Usuario() );
    }

    public UsuarioDTO comDadosDe(Usuario categoria) {
        return dto.comDadosDe(categoria );
    }

    public Usuario atualizaIgnorandoNuloA(Usuario categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }


    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
