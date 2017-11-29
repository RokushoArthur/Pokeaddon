package com.pokemonaddon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonaddon.api.model.Pokemon;
import com.pokemonaddon.api.pokemon.PokemonRepositoryQuery;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>, PokemonRepositoryQuery{

}
