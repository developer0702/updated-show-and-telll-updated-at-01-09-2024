package com.medication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.medication.openfegin")
@EnableJpaRepositories("com.medication.repository")
@ComponentScan({"com.medication.controller", "com.medication.service"})
@EntityScan("com.medication.entity")
public class MedicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicationApplication.class, args);
	}

}
