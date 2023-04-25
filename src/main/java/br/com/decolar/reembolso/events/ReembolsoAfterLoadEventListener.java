package br.com.decolar.reembolso.events;

import br.com.decolar.reembolso.security.ReembolsoSecurity;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;

import java.util.Arrays;
import java.util.List;

public class ReembolsoAfterLoadEventListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onAfterLoad(AfterLoadEvent<Object> event) {

        Document eventObject = event.getDocument();

        List<String> keysNotToDecrypt = Arrays.asList("_class","_id","idPedido","tipoPagamento",
                "reembolsado","tipoChavePIX","banco","bancoAgencia","bancoConta");

        for ( String key : eventObject.keySet() ) {
            if (!keysNotToDecrypt.contains(key)) {
                eventObject.put(key, ReembolsoSecurity.decrypt(eventObject.get(key).toString()));
            }
        }

        super.onAfterLoad(event);
    }
}