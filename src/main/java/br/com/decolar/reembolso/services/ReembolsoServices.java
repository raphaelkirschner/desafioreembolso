package br.com.decolar.reembolso.services;

import br.com.decolar.reembolso.model.Reembolso;

import java.util.List;

public interface ReembolsoServices {
    List<Reembolso> listarTodos();

    Reembolso cadastrar(Reembolso reembolso);

    Reembolso atualizar(Reembolso reembolso);

    Reembolso atualizarReembolsado(String id, boolean isReembolsado);
}