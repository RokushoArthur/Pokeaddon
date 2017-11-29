package com.pokemonaddon.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonaddon.api.model.PokeItem;

public interface PokeItemRepository extends JpaRepository<PokeItem, Long>{

}
