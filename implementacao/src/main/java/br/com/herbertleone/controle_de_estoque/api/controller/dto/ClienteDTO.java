package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClienteDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @JsonProperty("itenspedido")
    private Set<ItensPedidoDTO> itensPedidoDTO = new LinkedHashSet<>();

    private DTO<Cliente, ClienteDTO> dto = new DTO<>(this);

    public ClienteDTO() {  }

    public ClienteDTO(Cliente cliente) {
        this.comDadosDe(cliente );
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

    public ClienteDTO comDadosDe(Cliente cliente) {
        return dto.comDadosDe(cliente );
    }

    public Cliente atualizaIgnorandoNuloA(Cliente cliente) {
        return dto.mergeIgnorandoNulo(cliente );
    }


    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }

    public Set<ItensPedidoDTO> getItensPedidoDTO() {
        return itensPedidoDTO;
    }

    public void setItensPedidoDTO(Set<ItensPedidoDTO> itensPedidoDTO) {
        this.itensPedidoDTO = itensPedidoDTO;
    }
}
