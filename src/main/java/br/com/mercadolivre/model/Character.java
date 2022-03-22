package br.com.mercadolivre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String height;
	private String mass;
	@JsonProperty("hair_color")
	private String hairColor;
	@JsonProperty("skin_color")
	private String skinColor;
	@JsonProperty("eye_color")
	private String eyeColor;
	@JsonProperty("birth_year")
	private String birthYear;
	private String gender;
	private String homeworld;
	private String species;
}
