package com.example.conf;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext()))
        		.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.example.api"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());
	}

	  
	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Eventos Corporativos").description("Eventos Corporativos es un app que se encarga de verificar diponilibades de lugares y permitir la creación de eventos en ellos. Adicional debe permiitr el registro de personas al evento")
				.contact(new Contact("John Smith", "https://www.example.com", "example@example.com")).license("Wiki")
				.licenseUrl("https://github.com/features/code-review/").version("v1.0").build();
	}
	
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();

		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder()
			.securityReferences(defaultAuth())
			.build();
	}
	
	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope
			= new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}


