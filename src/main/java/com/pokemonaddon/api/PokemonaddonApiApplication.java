package com.pokemonaddon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pokemonaddon.api.config.property.PokemonAddonApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(PokemonAddonApiProperty.class)
public class PokemonaddonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonaddonApiApplication.class, args);
	}
}
