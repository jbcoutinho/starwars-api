package br.com.mercadolivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.model.Character;

@Repository
public interface CharacterRepository extends JpaRepository<br.com.mercadolivre.model.Character, Integer>{

	Character findByName(String name);

	Character findByNameContainingIgnoreCase(String name);

}
