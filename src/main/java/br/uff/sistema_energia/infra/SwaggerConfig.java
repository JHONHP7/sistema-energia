package br.uff.sistema_energia.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Sistema Energia API").version("1.0")
						.description("API para cadastro e atendimento de solicitações de reparos de falta de energia")
						.contact(new Contact().name("Jhonatan Oliveira da Silva, Rafael Costa, Pedro Monnerat")))
				.externalDocs(new ExternalDocumentation().description("Documentação Completa")
						.url("https://github.com/JHONHP7/sistema-energia"));
	}
}
