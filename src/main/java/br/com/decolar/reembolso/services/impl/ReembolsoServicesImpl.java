package br.com.decolar.reembolso.services.impl;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.repository.ReembolsoRepository;
import br.com.decolar.reembolso.services.ReembolsoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReembolsoServicesImpl implements ReembolsoServices {
    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @Override
    public List<Reembolso> listarTodos() {
        return this.reembolsoRepository.findAll();
    }

    @Override
    public Reembolso cadastrar(Reembolso detalhesReembolso) {
        return this.reembolsoRepository.save(detalhesReembolso);
    }

    @Override
    public Reembolso atualizar(Reembolso detalhesReembolso) {
        return this.reembolsoRepository.save(detalhesReembolso);
    }
}
