package com.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.appointment.openfegin")
@EnableJpaRepositories("com.appointment.repo")
@ComponentScan({"com.appointment.controller", "com.appointment.service"})
@EntityScan("com.appointment.entity")
public class MicroAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAppointmentApplication.class, args);
	}

}
