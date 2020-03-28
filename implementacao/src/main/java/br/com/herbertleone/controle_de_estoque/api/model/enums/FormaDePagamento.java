package br.com.herbertleone.controle_de_estoque.api.model.enums;

public enum FormaDePagamento {
    AVISTA("Pagamento a vista"),
    BOLETO("Pagamento com boleto"),
    CARTAO("Pagamento com cartão");

    private String formaDePagamento;

    private FormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }
}

