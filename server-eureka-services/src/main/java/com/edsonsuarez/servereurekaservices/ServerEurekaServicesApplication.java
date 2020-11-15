package com.edsonsuarez.servereurekaservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerEurekaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerEurekaServicesApplication.class, args);
	}

}
