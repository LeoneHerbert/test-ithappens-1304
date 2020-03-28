package br.com.herbertleone.controle_de_estoque.api.model.enums;

public enum StatusItem {
    ATIVO ("Ativo"),
    CANCELADO ("Cancelado"),
    PROCESSADO ("Em processamento");

    private String status;

    private StatusItem(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
