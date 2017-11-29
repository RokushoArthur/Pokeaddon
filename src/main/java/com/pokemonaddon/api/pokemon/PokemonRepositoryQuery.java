package com.pokemonaddon.api.pokemon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pokemonaddon.api.model.Pokemon;
import com.pokemonaddon.api.repository.filter.PokemonFilter;
import com.pokemonaddon.api.repository.projection.ResumePokemon;

public interface PokemonRepositoryQuery {

	Page<Pokemon> filter(PokemonFilter pokemonFilter, Pageable pageable);
	Page<ResumePokemon> resume(PokemonFilter pokemonFilter, Pageable pageable);
}
