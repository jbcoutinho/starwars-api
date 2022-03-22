package br.com.mercadolivre.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadolivre.dto.CharacterDTO;
import br.com.mercadolivre.model.Character;
import br.com.mercadolivre.repository.CharacterRepository;

@Service
public class CharacterService {
	
	@Autowired
	private CharacterRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	public void save(List<Character> character) {
		repository.saveAll(character);
	}

	public CharacterDTO findByNameContainingIgnoreCase(String name) {
		Character findByNameContainingIgnoreCase = repository.findByNameContainingIgnoreCase(name);
		return mapper.map (findByNameContainingIgnoreCase, CharacterDTO.class);
	}


}
