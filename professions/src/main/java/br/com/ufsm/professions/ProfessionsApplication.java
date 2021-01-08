package br.com.ufsm.professions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ProfessionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessionsApplication.class, args);
	}
}
