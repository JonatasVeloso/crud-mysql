package br.com.jvsiqueira.crudmysql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class GeralConfig implements ApplicationListener<ContextRefreshedEvent>{
	
	@Value("${spring.profiles.active}")
	private String ambiente;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (this.ambiente.equals("dev")) {
			System.out.println("Favor utilizar o ambiente de Test");
		}
	}
}
