package com.pokemonaddon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonaddon.api.model.PokemonTeam;

public interface PokemonTeamRepository extends JpaRepository<PokemonTeam, Long>{

}
