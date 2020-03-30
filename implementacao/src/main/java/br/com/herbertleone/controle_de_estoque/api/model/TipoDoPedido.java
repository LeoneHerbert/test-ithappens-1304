package br.com.herbertleone.controle_de_estoque.api.model;

public enum TipoDoPedido {
    SAIDA ("Venda"),
    ENTRADA ("Compra");

    private String tipo;

    private TipoDoPedido(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
