package com.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.doctor.openfeign")
@EnableJpaRepositories("com.doctor.repo")
@ComponentScan({"com.doctor.controller", "com.doctor.service"})
@EntityScan("com.doctor.entity")
public class MicroDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroDoctorApplication.class, args);
	}

}
