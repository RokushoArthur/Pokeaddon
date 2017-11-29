package com.pokemonaddon.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonaddon.api.model.Pokemon;
import com.pokemonaddon.api.model.PokemonAbility;
import com.pokemonaddon.api.model.PokemonMove;
import com.pokemonaddon.api.repository.PokemonAbilityRepository;
import com.pokemonaddon.api.repository.PokemonMoveRepository;
import com.pokemonaddon.api.repository.PokemonRepository;
import com.pokemonaddon.api.service.exception.AbilityDoesNotExistException;
import com.pokemonaddon.api.service.exception.MoveDoesNotExistException;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private PokemonAbilityRepository pokemonAbilityRepository;
	
	@Autowired
	private PokemonMoveRepository pokemonMoveRepository;
	
	public Pokemon savePokemon(Pokemon pokemon) {
		PokemonAbility pokemonAbility = pokemonAbilityRepository.findOne(pokemon.getAbility().getId());
		PokemonMove moveOne = pokemonMoveRepository.findOne(pokemon.getMoveOne().getId());
		
		if (pokemonAbility == null) {
			throw new AbilityDoesNotExistException();
		}
		
		if (moveOne == null) {
			throw new MoveDoesNotExistException();
		}
		
		return pokemonRepository.save(pokemon);
	}
}
