package com.pokemonaddon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonaddon.api.model.PokemonMove;

public interface PokemonMoveRepository extends JpaRepository<PokemonMove, Long>{

}
