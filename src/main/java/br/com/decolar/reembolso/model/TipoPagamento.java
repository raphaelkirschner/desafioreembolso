package br.com.decolar.reembolso.model;

public enum TipoPagamento {
    CONTA_CORRENTE("Conta corrente"),
    PIX("PIX");

    private String descricao;

    TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
