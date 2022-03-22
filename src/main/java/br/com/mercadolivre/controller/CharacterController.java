package br.com.mercadolivre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.dto.CharacterDTO;
import br.com.mercadolivre.service.CharacterService;

@RestController
public class CharacterController {
	
	@Autowired
	private CharacterService service;
	
	@GetMapping("/character/{name}")
	public CharacterDTO findByName(@PathVariable String name) {
		return service.findByNameContainingIgnoreCase(name);
	}

}
