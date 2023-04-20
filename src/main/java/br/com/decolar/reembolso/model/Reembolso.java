package br.com.decolar.reembolso.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document("detalhesReembolso")
public class Reembolso {
    @Id
    private String id;

    @NotBlank(message = "Pedido não pode ser vazio")
    @NotNull(message = "Pedido não pode ser nulo")
    @Size(max = 20, message = "Pedido excede a quantidade de 20 caracteres")
    private String idPedido;

    @NotBlank(message = "Nome não pode ser vazio")
    @NotNull(message = "Nome não pode ser nulo")
    @Size(max = 100, message = "Nome excede a quantidade de 100 caracteres")
    private String nomeCliente;

    @NotNull(message = "Telefone não pode ser nulo")
    @Size(min = 10, max = 11, message = "Telefone deve ter 10 ou 11 números")
    private String telefoneCliente;

    @NotNull(message = "CPF não pode ser nulo")
    @CPF(message = "CPF inválido")
    private String cpfCliente;

    private boolean reembolsado;

    private String banco;

    private String bancoAgencia;

    private String bancoConta;

    private String chavePIX;

    @NotNull(message = "Tipo de pagamento não pode ser nulo")
    private TipoPagamento tipoPagamento;

    private TipoChavePIX tipoChavePIX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
        //return ReembolsoCrypto.decrypt(cpfCliente, "secrettest");
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public boolean isReembolsado() {
        return reembolsado;
    }

    public void setReembolsado(boolean reembolsado) {
        this.reembolsado = reembolsado;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getBancoAgencia() {
        return bancoAgencia;
    }

    public void setBancoAgencia(String bancoAgencia) {
        this.bancoAgencia = bancoAgencia;
    }

    public String getBancoConta() {
        return bancoConta;
    }

    public void setBancoConta(String bancoConta) {
        this.bancoConta = bancoConta;
    }

    public String getChavePIX() {
        return chavePIX;
    }

    public void setChavePIX(String chavePIX) {
        this.chavePIX = chavePIX;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoChavePIX getTipoChavePIX() {
        return tipoChavePIX;
    }

    public void setTipoChavePIX(TipoChavePIX tipoChavePIX) {
        this.tipoChavePIX = tipoChavePIX;
    }
}