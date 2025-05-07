package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration

@OpenAPIDefinition(info = @Info(title = "API de Inmobiliaria", version = "1.0", description = "Documentación de la API para la aplicación inmobiliaria", contact = @Contact(name = "Soporte", email = "soporte@tudominio.com")), security = @SecurityRequirement(name = "Security Token"), servers = @Server(url = "http://localhost:8090", description = "Server API"))
@SecurityScheme(name = "Security Token", description = "Access Token For My API", type = SecuritySchemeType.HTTP, paramName = HttpHeaders.AUTHORIZATION, in = SecuritySchemeIn.HEADER, scheme = "bearer", bearerFormat = "JWT")
public class SwaggerConfig {
}
