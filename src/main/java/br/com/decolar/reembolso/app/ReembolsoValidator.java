package br.com.decolar.reembolso.app;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.model.TipoChavePIX;
import br.com.decolar.reembolso.model.TipoPagamento;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class ReembolsoValidator {

    public static List<String> validarReembolso(BindingResult result, Reembolso reembolso) {
        List<String> erros = new ArrayList<String>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
        }

        if (reembolso.getTipoPagamento() == TipoPagamento.PIX)
        {
            if (!reembolso.getTipoChavePIX().equals(TipoChavePIX.CPF) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.EMAIL) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.CELULAR) &&
                    !reembolso.getTipoChavePIX().equals(TipoChavePIX.ALEATORIO)) {
                erros.add("Tipo de chave PIX inválido");
            }

            if (reembolso.getChavePIX() == null || reembolso.getChavePIX().isBlank() || reembolso.getChavePIX().isEmpty()) {
                erros.add("Chave PIX não pode ser vazia");
            }
            else {
                if (reembolso.getTipoChavePIX().equals(TipoChavePIX.ALEATORIO))
                {
                    if (reembolso.getChavePIX().length() != 32)
                    {
                        erros.add("Chave PIX inválida");
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
