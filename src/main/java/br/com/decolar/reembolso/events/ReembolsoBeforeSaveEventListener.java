package br.com.decolar.reembolso.events;

import br.com.decolar.reembolso.security.ReembolsoSecurity;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import java.util.Arrays;
import java.util.List;

public class ReembolsoBeforeSaveEventListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {

        Document eventObject = event.getDocument();

        List<String> keysNotToEncrypt = Arrays.asList("_class","_id","idPedido","tipoPagamento",
                "reembolsado","tipoChavePIX","chavePIX","banco","bancoAgencia","bancoConta");

        for ( String key : eventObject.keySet() ) {
            if (!keysNotToEncrypt.contains(key)) {
                eventObject.put(key, ReembolsoSecurity.encrypt(eventObject.get(key).toString()));
            }
        }

        super.onBeforeSave(event);
    }
}
