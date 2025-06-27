package com.ciu.db2.tp3.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVuelosApplication.class, args);
	}

}
