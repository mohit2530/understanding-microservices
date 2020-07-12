package com.example.ratingdatarepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingDataRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataRepoApplication.class, args);
	}

}
