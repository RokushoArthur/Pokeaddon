package com.pokemonaddon.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pokemon_team")
public class PokemonTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "first_pokemon_id")
	private Pokemon firstPokemon;
	
	@ManyToOne
	@JoinColumn(name = "second_pokemon_id")
	private Pokemon secondPokemon;
	
	@ManyToOne
	@JoinColumn(name = "third_pokemon_id")
	private Pokemon thirdPokemon;
	
	@ManyToOne
	@JoinColumn(name = "fourth_pokemon_id")
	private Pokemon fourthPokemon;
	
	@ManyToOne
	@JoinColumn(name = "fifith_pokemon_id")
	private Pokemon fifithPokemon;
	
	@ManyToOne
	@JoinColumn(name = "sixth_pokemon_id")
	private Pokemon sixthPokemon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pokemon getFirstPokemon() {
		return firstPokemon;
	}

	public void setFirstPokemon(Pokemon firstPokemon) {
		this.firstPokemon = firstPokemon;
	}

	public Pokemon getSecondPokemon() {
		return secondPokemon;
	}

	public void setSecondPokemon(Pokemon secondPokemon) {
		this.secondPokemon = secondPokemon;
	}

	public Pokemon getThirdPokemon() {
		return thirdPokemon;
	}

	public void setThirdPokemon(Pokemon thirdPokemon) {
		this.thirdPokemon = thirdPokemon;
	}

	public Pokemon getFourthPokemon() {
		return fourthPokemon;
	}

	public void setFourthPokemon(Pokemon fourthPokemon) {
		this.fourthPokemon = fourthPokemon;
	}

	public Pokemon getFifithPokemon() {
		return fifithPokemon;
	}

	public void setFifithPokemon(Pokemon fifithPokemon) {
		this.fifithPokemon = fifithPokemon;
	}

	public Pokemon getSixthPokemon() {
		return sixthPokemon;
	}

	public void setSixthPokemon(Pokemon sixthPokemon) {
		this.sixthPokemon = sixthPokemon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonTeam other = (PokemonTeam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
