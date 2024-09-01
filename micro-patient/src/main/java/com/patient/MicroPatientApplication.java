package com.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.patient.openfegin")
@EnableJpaRepositories("com.patient.repo")
@ComponentScan({"com.patient.controller", "com.patient.service"})
@EntityScan("com.patient.entity")

 public class MicroPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPatientApplication.class, args);
	}

}
