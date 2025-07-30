package br.com.fiap.fiapmotors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "br.com.fiap")
public class FiapmotorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapmotorsApplication.class, args);
	}

}
