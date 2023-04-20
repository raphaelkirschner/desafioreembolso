package br.com.decolar.reembolso;

import br.com.decolar.reembolso.events.ReembolsoAfterLoadEventListener;
import br.com.decolar.reembolso.events.ReembolsoBeforeSaveEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReembolsoApplication {

	@Bean
	public ReembolsoBeforeSaveEventListener reembolsoBeforeSaveEventListener() {
		return new ReembolsoBeforeSaveEventListener();
	}

	@Bean
	public ReembolsoAfterLoadEventListener reembolsoAfterLoadEventListener() {
		return new ReembolsoAfterLoadEventListener();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReembolsoApplication.class, args);
	}
}