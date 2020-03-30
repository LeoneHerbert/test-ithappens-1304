package br.com.herbertleone.controle_de_estoque.api.controller.dto;

import br.com.herbertleone.controle_de_estoque.api.model.Estoque;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

public class EstoqueDTO {

    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @JsonProperty("filial")
    private FilialDTO filialDTO;

    @JsonProperty("produto")
    private Set<ProdutoDTO> produtosDTO = new LinkedHashSet<>();

    private DTO<Estoque, EstoqueDTO> dto = new DTO<>(this);

    public EstoqueDTO() {  }

    public EstoqueDTO(Estoque estoque) {
        this.comDadosDe(estoque );
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

    public Set<ProdutoDTO> getProdutosDTO() {
        return produtosDTO;
    }

    public void setProdutosDTO(Set<ProdutoDTO> produtosDTO) {
        this.produtosDTO = produtosDTO;
    }

    @Override
    public String toString() {
        return "EstoqueDTO{" +
                ", nome='" + nome + '\'' +
                ", produtos='" + produtosDTO.toString() + '\'' +
                '}';
    }
}
