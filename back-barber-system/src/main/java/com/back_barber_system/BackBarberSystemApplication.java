package com.back_barber_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(servers  = { @Server(url = "/", description = "Defualt Server URL")})
public class BackBarberSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackBarberSystemApplication.class, args);
	}

}
