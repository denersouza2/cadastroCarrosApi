package br.com.devdener.cadastroCarros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CadastroCarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroCarrosApplication.class, args);
	}

}
