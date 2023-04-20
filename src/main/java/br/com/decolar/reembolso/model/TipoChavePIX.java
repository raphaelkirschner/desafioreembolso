package br.com.decolar.reembolso.model;

public enum TipoChavePIX {
    EMAIL("E-mail"),
    CELULAR("Celular"),
    CPF("CPF"),
    ALEATORIO("Chave aleatória");

    private String descricao;

    TipoChavePIX(String descricao) {

        this.descricao = descricao;
    }

    public String getDescricao(){

        return descricao;
    }
}