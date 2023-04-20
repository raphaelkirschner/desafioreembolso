package br.com.decolar.reembolso.app;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.model.TipoChavePIX;
import br.com.decolar.reembolso.model.TipoPagamento;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ReembolsoValidator {

    public static List<String> validarReembolso(@NotNull BindingResult result, @NotNull Reembolso reembolso) {
        List<String> erros = new ArrayList<String>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
        }

        if (reembolso.getIdPedido() != null && !reembolso.getIdPedido().matches("[0-9]+"))
        {
            erros.add("Pedido deve conter somente números");
        }

        if (reembolso.getTelefoneCliente() != null && !reembolso.getTelefoneCliente().matches("[0-9]+"))
        {
            erros.add("Telefone deve conter somente números");
        }

        if (reembolso.getNomeCliente() != null && reembolso.getNomeCliente().matches(".*[0-9].*"))
        {
            erros.add("Nome deve conter somente letras");
        }

        if (reembolso.getTipoPagamento() != null && (!reembolso.getTipoPagamento().equals(TipoPagamento.PIX) &&
                !reembolso.getTipoPagamento().equals(TipoPagamento.CONTA_CORRENTE))) {
            erros.add("Tipo de pagamento inválido");
        }
        else if (reembolso.getTipoPagamento() == TipoPagamento.PIX)
        {
            if (!reembolso.getTipoChavePIX().equals(TipoChavePIX.CPF) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.EMAIL) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.CELULAR) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.ALEATORIO)) {
                erros.add("Tipo de chave PIX inválido");
            }
            else {
                if (reembolso.getChavePIX() == null || reembolso.getChavePIX().isBlank() || reembolso.getChavePIX().isEmpty()) {
                    erros.add("Chave PIX não pode ser vazia");
                } else {
                    if (reembolso.getTipoChavePIX().equals(TipoChavePIX.ALEATORIO)) {
                        if (reembolso.getChavePIX().length() != 32) {
                            erros.add("Chave PIX do tipo 'Aleatória' deve ter 32 caracteres");
                        }
                    } else if (reembolso.getTipoChavePIX().equals(TipoChavePIX.CELULAR)) {
                        if (reembolso.getChavePIX().length() < 10 || reembolso.getChavePIX().length() > 11) {
                            erros.add("Chave PIX do tipo 'Celular' deve ter 10 ou 11 caracteres");
                        }

                        if (!reembolso.getChavePIX().matches("[0-9]+")) {
                            erros.add("Chave PIX do tipo 'Celular' deve conter somente números");
                        }
                    } else if (reembolso.getTipoChavePIX().equals(TipoChavePIX.CPF)) {
                        if (reembolso.getChavePIX().length() != 11) {
                            erros.add("Chave PIX do tipo 'CPF' deve ter 11 caracteres");
                        }

                        if (!reembolso.getChavePIX().matches("[0-9]+")) {
                            erros.add("Chave PIX do tipo 'CPF' deve conter somente números");
                        }
                    }
                }
            }
        }
        else if (reembolso.getTipoPagamento() == TipoPagamento.CONTA_CORRENTE)
        {
            if (reembolso.getBanco() == null || reembolso.getBanco().isBlank() || reembolso.getBanco().isEmpty()){
                erros.add("Banco não pode ser vazia");
            }
            if (reembolso.getBancoAgencia() == null || reembolso.getBancoAgencia().isBlank() || reembolso.getBancoAgencia().isEmpty()){
                erros.add("Agência não pode ser vazia");
            }
            if (reembolso.getBancoConta() == null || reembolso.getBancoConta().isBlank() || reembolso.getBancoConta().isEmpty()){
                erros.add("Conta corrente não pode ser vazia");
            }
        }

        return erros;
    }
}