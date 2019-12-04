package br.com.jvsiqueira.crudmysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig {
	
	public TestConfig() {
		System.out.println("Utilizando ambiente de Teste");
	}

}
