package org.mongen.core.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.mongen.core"))
				.paths(regex("/api/v1.*"))
				.build()
				.apiInfo(metaInfo());
	}
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"API de Street Priest",
				"RestAPI de Street Priest",
				"1.0",
				"Terminos de Servicio",
				new Contact("Street Priest","https://streetpriests.org.ng","marcelo.negrier@gmail.com"),
				"Apache Licencia Version 2.0",
				"https://www.apache.org/licesen.html",
				Collections.emptyList()
				);
		return apiInfo;
	}
}
