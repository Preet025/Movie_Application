package com.Favourite_Movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FavouriteMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteMoviesApplication.class, args);
	}

}
