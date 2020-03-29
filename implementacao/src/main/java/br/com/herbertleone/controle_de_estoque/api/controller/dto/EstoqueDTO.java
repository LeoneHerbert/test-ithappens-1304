package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Estoque;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

public class EstoqueDTO {
    private Integer id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @JsonProperty("filial")
    private FilialDTO filialDTO;

    @JsonProperty("item")
    private Set<ItemDTO> itensDTO = new LinkedHashSet<>();

    private DTO<Estoque, EstoqueDTO> dto = new DTO<>(this);

    public EstoqueDTO() {  }

    public EstoqueDTO(Estoque estoque) {
        this.comDadosDe(estoque );
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
    public Estoque getEstoque() {
        return dto.getEntity(new Estoque() );
    }

    public EstoqueDTO comDadosDe(Estoque estoque) {
        return dto.comDadosDe(estoque );
    }

    public Estoque atualizaIgnorandoNuloA(Estoque estoque) {
        return dto.mergeIgnorandoNulo(estoque );
    }

    public FilialDTO getFilialDTO() {
        return filialDTO;
    }

    public void setFilialDTO(FilialDTO filialDTO) {
        this.filialDTO = filialDTO;
    }

    public Set<ItemDTO> getItemDTO() {
        return itensDTO;
    }

    public void setItemDTO(Set<ItemDTO> itemDTO) {
        this.itensDTO = itemDTO;
    }

    @Override
    public String toString() {
        return "EstoqueDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", itens='" + itensDTO.toString() + '\'' +
                '}';
    }
}
