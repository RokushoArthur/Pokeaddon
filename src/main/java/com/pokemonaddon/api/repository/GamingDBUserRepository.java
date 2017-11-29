package com.pokemonaddon.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokemonaddon.api.model.GamingDBUser;

public interface GamingDBUserRepository extends JpaRepository<GamingDBUser, Long>{

	public Optional<GamingDBUser> findByEmail(String email);
}
