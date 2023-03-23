package com.ingg.ipas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ingg.ipas.*")
@EntityScan("com.ingg.ipas.*")
public class IPASApplication {

	public static void main(String[] args) {
		SpringApplication.run(IPASApplication.class, args);
	}

}
