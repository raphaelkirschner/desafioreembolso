package br.com.decolar.reembolso;

import br.com.decolar.reembolso.events.ReembolsoAfterLoadEventListener;
import br.com.decolar.reembolso.events.ReembolsoBeforeSaveEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReembolsoApplication {

	/*
    We register a bean of type MongoDBBeforeSaveEventListener. This will make sure that the MongoDB event
    listener will be called by SpringBoot just before a save operation is about to happen.
    In this listener, we'll encrypt all the values in the document before it is being stored to the database.
     */
	@Bean
	public ReembolsoBeforeSaveEventListener reembolsoBeforeSaveEventListener() {
		return new ReembolsoBeforeSaveEventListener();
	}

	/*
    We register a bean of type MongoDBAfterLoadEventListener. This will make sure that the MongoDB event
    listener will be called by springBoot right after a load operation has happened.
    In this listener, we'll decrypt the values in the document loaded before it mapped to an object.
     */
	@Bean
	public ReembolsoAfterLoadEventListener reembolsoAfterLoadEventListener() {
		return new ReembolsoAfterLoadEventListener();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReembolsoApplication.class, args);
	}
}