package br.com.decolar.reembolso.repository;

import br.com.decolar.reembolso.model.Reembolso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReembolsoRepository extends MongoRepository<Reembolso, String> {
}
