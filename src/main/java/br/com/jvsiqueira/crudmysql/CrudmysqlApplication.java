package br.com.jvsiqueira.crudmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudmysqlApplication.class, args);
		System.out.println("Context: Aplicação iniciada com sucesso!");
	}

}