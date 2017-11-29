package com.pokemonaddon.api.pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.pokemonaddon.api.model.Pokemon;
import com.pokemonaddon.api.model.PokemonAbility_;
import com.pokemonaddon.api.model.Pokemon_;
import com.pokemonaddon.api.repository.filter.PokemonFilter;
import com.pokemonaddon.api.repository.projection.ResumePokemon;

public class PokemonRepositoryImpl implements PokemonRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Pokemon> filter(PokemonFilter pokemonFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pokemon> criteria = builder.createQuery(Pokemon.class);
		Root<Pokemon> root = criteria.from(Pokemon.class);
		
		TypedQuery<Pokemon> query = manager.createQuery(criteria);
		
		Predicate[] predicates = createRestrictions(pokemonFilter, builder, root);
		criteria.where(predicates);
		
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pokemonFilter));
	}

	@Override
	public Page<ResumePokemon> resume(PokemonFilter pokemonFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumePokemon> criteria = builder.createQuery(ResumePokemon.class);
		Root<Pokemon> root = criteria.from(Pokemon.class);
		
		criteria.select(builder.construct(ResumePokemon.class, 
											root.get(Pokemon_.pokedexId), root.get(Pokemon_.name),
											root.get(Pokemon_.pokedexDescription), root.get(Pokemon_.typeOne),
											root.get(Pokemon_.typeTwo), root.get(Pokemon_.gender),
											root.get(Pokemon_.ability).get(PokemonAbility_.name)));
		
		TypedQuery<ResumePokemon> query = manager.createQuery(criteria);
		
		Predicate[] predicates = createRestrictions(pokemonFilter, builder, root);
		criteria.where(predicates);
		
		addPaginationRestrictions(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pokemonFilter));
	}
	
	private void addPaginationRestrictions(TypedQuery<?> query, Pageable pageable) {
		int actualPage = pageable.getPageNumber();
		int totalRegistersPerPage = pageable.getPageSize();
		int firstPageRegister = actualPage * totalRegistersPerPage;
		
		query.setFirstResult(firstPageRegister);
		query.setMaxResults(totalRegistersPerPage);
	}

	private Long total(PokemonFilter pokemonFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Pokemon> root = criteria.from(Pokemon.class);
		
		Predicate[] predicates = createRestrictions(pokemonFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		
		
		return manager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] createRestrictions(PokemonFilter pokemonFilter, CriteriaBuilder builder, Root<Pokemon> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(pokemonFilter.getName())) {
			predicates.add(builder.like(builder.lower(root.get(Pokemon_.name)), 
										"%" + pokemonFilter.getName() + "%"));
		}
		
		if (!StringUtils.isEmpty(pokemonFilter.getTypeOne())) {
			predicates.add(builder.like(builder.lower(root.get(Pokemon_.typeOne.toString())), 
										"%" + pokemonFilter.getTypeOne() + "%"));
		}
		
		if (!StringUtils.isEmpty(pokemonFilter.getTypeTwo())) {
			predicates.add(builder.like(builder.lower(root.get(Pokemon_.typeTwo.toString())), 
										"%" + pokemonFilter.getTypeTwo() + "%"));
		}
		
		if (!StringUtils.isEmpty(pokemonFilter.getAbility())) {
			predicates.add(builder.like(builder.lower(root.get(Pokemon_.ability).get(PokemonAbility_.name)), 
										"%" + pokemonFilter.getAbility() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
