package br.com.decolar.reembolso.services.impl;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.repository.ReembolsoRepository;
import br.com.decolar.reembolso.services.ReembolsoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReembolsoServicesImpl implements ReembolsoServices {
    @Autowired
    private ReembolsoRepository reembolsoRepository;

    @Override
    public List<Reembolso> listarTodos() {
        return this.reembolsoRepository.findAll();
    }

    public Reembolso listarPorId(String id) {
        Optional<Reembolso> reembolso = reembolsoRepository.findById(id);
        return reembolso.get();
    }

    @Override
    public Reembolso cadastrar(Reembolso reembolso) {
        return this.reembolsoRepository.save(reembolso);
    }

    @Override
    public Reembolso atualizar(Reembolso reembolso) {
        return this.reembolsoRepository.save(reembolso);
    }

    @Override
    public Reembolso atualizarReembolsado(String id, Reembolso reembolso) {
        Reembolso reembolsoAll = this.listarPorId(id);

        if (reembolsoAll != null)
        {
            reembolsoAll.setReembolsado(reembolso.isReembolsado());
        }

        return this.reembolsoRepository.save(reembolsoAll);
    }
}
