package br.com.decolar.reembolso.services;

import br.com.decolar.reembolso.model.Reembolso;

import java.util.List;

public interface ReembolsoService {
    List<Reembolso> listarTodos();

    Reembolso cadastrar(Reembolso detalhesReembolso);

    Reembolso atualizar(Reembolso detalhesReembolso);
}
