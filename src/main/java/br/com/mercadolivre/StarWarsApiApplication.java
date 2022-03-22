package br.com.mercadolivre;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mercadolivre.service.CharacterService;

@SpringBootApplication
public class StarWarsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CharacterService characterService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<br.com.mercadolivre.model.Character>> typeReference = new TypeReference<List<br.com.mercadolivre.model.Character>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/init.json");
			try {
				List<br.com.mercadolivre.model.Character> characters = mapper.readValue(inputStream,typeReference);
				characterService.save(characters);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
	
}
