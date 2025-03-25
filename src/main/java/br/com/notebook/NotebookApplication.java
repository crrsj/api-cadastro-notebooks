package br.com.notebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Notebooks.",
			version = "1.0",
			description = "API para gerenciamento de notebooks.",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class NotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotebookApplication.class, args);
	}

}
