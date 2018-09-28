package com.kapil.h2.inmemory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InmemoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmemoryApplication.class, args);
	}
}